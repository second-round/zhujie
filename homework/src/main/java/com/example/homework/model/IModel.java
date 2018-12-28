package com.example.homework.model;

import android.content.Intent;
import android.util.Log;

import com.example.homework.ICallBack;
import com.example.homework.MainActivity;
import com.example.homework.OkHttps;
import com.example.homework.bean.RecycleBean;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Map;

public class IModel {
    private String path="http://www.zhaoapi.cn/product/searchProducts";

    public IModel() {
        getData();
    }

    private void getData() {
        Log.i("TAG","aaaa");
        Map<String,String> map=new HashMap<>();
        map.put("keywords","笔记本");
        map.put("page","1");
        OkHttps.getInstance().setData(path, map, RecycleBean.class, new ICallBack() {
            @Override
            public void success(Object o) {
                Log.i("TAG","aaa6666a");
                EventBus.getDefault().postSticky((o));
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }
}
