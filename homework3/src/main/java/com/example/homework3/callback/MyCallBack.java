package com.example.homework3.callback;

public interface MyCallBack<T> {
    void onSuccess(T data);
    void onFail(String error);
}