package com.example.hyyyuekao;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hyyyuekao.adapter.ImageAdapter;
import com.example.hyyyuekao.bean.ImageBean;
import com.example.hyyyuekao.persenter.PersenterImpl;
import com.example.hyyyuekao.view.IView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements IView,View.OnClickListener {
    private PersenterImpl persenter;
    private ViewPager pager;
    private Button buttonshow;
    private ImageAdapter adapter;
    private int page=0;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            pager.setCurrentItem(page);
            page++;
            if (page==4){
                buttonshow.setVisibility(View.VISIBLE);
                return;
            }
            handler.sendEmptyMessageDelayed(0,2000);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        getData();
    }

    private void getData() {
        Map<String ,String> map=new HashMap<>();
        persenter.sendMessage(Apis.PATH_IMAGE,map,ImageBean.class);
    }

    private void init() {
        persenter=new PersenterImpl(this);
        pager=findViewById(R.id.pager);
        buttonshow=findViewById(R.id.button_show);
        buttonshow.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_show:
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            default:
                break;
        }
    }

    @Override
    public void setData(Object o) {
        ImageBean imageBean= (ImageBean) o;
        List<ImageBean.DataBean> data = imageBean.getData();
        Toast.makeText(MainActivity.this,data.size()+"",Toast.LENGTH_LONG).show();
        adapter=new ImageAdapter(data,MainActivity.this);
        pager.setAdapter(adapter);
        handler.sendEmptyMessageDelayed(0,2000);
    }
}
