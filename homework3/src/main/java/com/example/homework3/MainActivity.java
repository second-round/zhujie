package com.example.homework3;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.homework3.adapter.RecyclerAdapters;
import com.example.homework3.bean.PhoneBeans;
import com.example.homework3.persenter.PersenterImpl;
import com.example.homework3.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {
    @BindView(R.id.recycle)
    private XRecyclerView xRecyclerView;
    @BindView(R.id.huan)
    private ImageView huan;
    private PersenterImpl persenter;
    private boolean isLiear=true;
    private String path;
    private final int ITEM_COUNT=2;
    private RecyclerAdapters adapter;
    private int page;
    private Map<String, String> map;
    private List<PhoneBeans.DataBean> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        listener();
        data();
        getdata();
    }



    private void listener() {
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                data.clear();
                getdata();
            }

            @Override
            public void onLoadMore() {
                getdata();
            }
        });
        huan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data();
                getdata();
            }
        });
    }

    private void data() {
        if (isLiear){
            isLiear=false;
            GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,ITEM_COUNT);
            //设置方向
            gridLayoutManager.setOrientation(OrientationHelper.VERTICAL);
            xRecyclerView.setLayoutManager(gridLayoutManager);
            adapter=new RecyclerAdapters(MainActivity.this,isLiear);
            xRecyclerView.setAdapter(adapter);
        }else {
            isLiear=true;
            LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            xRecyclerView.setLayoutManager(layoutManager);
            adapter=new RecyclerAdapters(MainActivity.this,isLiear);
            xRecyclerView.setAdapter(adapter);
        }
        adapter.setOnItemClickListener(new RecyclerAdapters.OnItemClickListener() {
            @Override
            public void onitemClick(View item, int position) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void getdata() {
        Map<String,String> map=new HashMap<>();
        map.put("keywords","手机");
        map.put("page",page+"");
        persenter.startRequest(path,map,PhoneBeans.class);
    }


    private void init() {
        persenter=new PersenterImpl(this);
        path="searchProducts?keywords=手机&page=1&sort=0";
        map = new HashMap<>();
        data=new ArrayList<>();
        page=1;
        adapter=new RecyclerAdapters(MainActivity.this,isLiear);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        xRecyclerView.setAdapter(adapter);
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);
    }

    @Override
    public void getDataSuccess(Object data) {
        Toast.makeText(this, "sss", Toast.LENGTH_SHORT).show();
        PhoneBeans phoneBeans= (PhoneBeans) data;
        adapter.setPhone(phoneBeans.getData());
        xRecyclerView.loadMoreComplete();
        xRecyclerView.refreshComplete();
    }

    @Override
    public void getDataFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        Log.i("TAG",error);
    }
}
