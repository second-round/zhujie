package com.example.hyyyuekao.model;

import com.example.hyyyuekao.util.MyCallBack;

import java.util.Map;

public interface Model {
    void sendMessage(String path, Map<String,String> map, Class imageBeanClass, MyCallBack myCallBack);
}
