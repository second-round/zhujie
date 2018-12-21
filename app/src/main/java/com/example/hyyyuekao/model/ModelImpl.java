package com.example.hyyyuekao.model;

import com.example.hyyyuekao.okhttps.ICallBack;
import com.example.hyyyuekao.util.MyCallBack;
import com.example.hyyyuekao.okhttps.OkHttps;

import java.util.Map;

public class ModelImpl implements Model{
    @Override
    public void sendMessage(String path, Map<String, String> map, Class clazz, final MyCallBack myCallBack) {
        OkHttps.getInstance().setData(path, map, clazz, new ICallBack() {
            @Override
            public void success(Object o) {
                myCallBack.setData(o);
            }

            @Override
            public void failed(Exception e) {
                myCallBack.setData(e);
            }
        });
    }
}
