package com.example.homework3.model;

import com.example.homework3.callback.MyCallBack;

import java.util.Map;

public interface Model {
    void requestData(String url, Map<String, String> params, Class clazz, MyCallBack callBack);
}
