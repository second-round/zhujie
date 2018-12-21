package com.example.hyyyuekao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.hyyyuekao.adapter.NineAdapter;
import com.example.hyyyuekao.adapter.RecycleAdapter;
import com.example.hyyyuekao.bean.NineBean;
import com.example.hyyyuekao.bean.RecycleBean;
import com.example.hyyyuekao.persenter.Persenter;
import com.example.hyyyuekao.persenter.PersenterImpl;
import com.example.hyyyuekao.view.IView;
import com.example.hyyyuekao.view.MyView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements IView {
    private PersenterImpl persenter;
    private RecyclerView recyclerView,recycle_nine;
    private RecycleAdapter adapter;
    private final int NUM=2,NUM_NINE=5;
    private MyView myView;
    private boolean isLinear=true;
    private NineAdapter nineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        loadData();
    }

    private void loadData() {
        Map<String,String> map=new HashMap<>();
        map.put("uid",71+"");
        persenter.sendMessage(Apis.PATH_LIST,map,RecycleBean.class);
    }

    private void initView() {
        persenter=new PersenterImpl(this);
        recyclerView=findViewById(R.id.recycle);
        recycle_nine=findViewById(R.id.recycle_nine);
        linear();
        nine();
    }

    private void nine() {
        nineAdapter = new NineAdapter(LoginActivity.this);
        GridLayoutManager manager=new GridLayoutManager(LoginActivity.this,NUM_NINE);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recycle_nine.setLayoutManager(manager);
        recycle_nine.setAdapter(nineAdapter);
        Map<String,String> map=new HashMap<>();
        persenter.sendMessage(Apis.PATH_NINE,map,NineBean.class);
    }

    public void grid() {
        adapter=new RecycleAdapter(LoginActivity.this,isLinear);
        GridLayoutManager manager=new GridLayoutManager(LoginActivity.this,NUM);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }

    public void linear() {
        adapter=new RecycleAdapter(LoginActivity.this,isLinear);
        LinearLayoutManager manager=new LinearLayoutManager(LoginActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    public void huan(){
        List<RecycleBean.DataBean.UserBean> list = adapter.getList();
        isLinear=!isLinear;
        if (isLinear){
            linear();
        }else {
            grid();
        }
        adapter.setList(list);
    }

    @Override
    public void setData(Object o) {
        if (o instanceof RecycleBean){
            RecycleBean recycleBean= (RecycleBean) o;
            adapter.setList(recycleBean.getData().get(2).getList());
        }
        if (o instanceof NineBean){
            NineBean nineBean= (NineBean) o;
            Log.i("TAG",nineBean.getData().size()+"");
            nineAdapter.setList(nineBean.getData());
        }
    }
}