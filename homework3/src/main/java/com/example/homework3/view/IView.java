package com.example.homework3.view;

public interface IView<T> {
    void getDataSuccess(T data);
    void getDataFail(String error);
}
