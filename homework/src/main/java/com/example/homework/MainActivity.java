package com.example.homework;

import android.database.sqlite.SQLiteDatabase;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.homework.adapter.RecycleAdapter;
import com.example.homework.bean.RecycleBean;
import com.example.homework.greendao.UserBean;
import com.example.homework.model.IModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.greendao.query.QueryBuilder;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IModel model;
    RecycleAdapter adapter;
    private DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        adapter=new RecycleAdapter(MainActivity.this);
        DaoMaster.DevOpenHelper helper=new DaoMaster.DevOpenHelper(this,"user.db",null);
        SQLiteDatabase database=helper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(database);
        daoSession = daoMaster.newSession();
        GridLayoutManager manager=new GridLayoutManager(MainActivity.this,2);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        model=new IModel();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true)
    public void onEvent(Object o){
        Log.i("TAG","aa444aa");
        RecycleBean recycleBean= (RecycleBean) o;
        adapter.setList(recycleBean.getData());
        for (int i=0;i<recycleBean.getData().size();i++){
            UserBean userBean = new UserBean();
            userBean.setDetailUrl(recycleBean.getData().get(i).getDetailUrl());
            userBean.setId(i);
            userBean.setImages(recycleBean.getData().get(i).getImages());
            userBean.setPrice(recycleBean.getData().get(i).getPrice());
            userBean.setSubhead(recycleBean.getData().get(i).getSubhead());
            userBean.setTitle(recycleBean.getData().get(i).getTitle());
            daoSession.insert(userBean);
        }
//        QueryBuilder<Object> objectQueryBuilder = daoSession.queryBuilder();
    }
    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }


}
