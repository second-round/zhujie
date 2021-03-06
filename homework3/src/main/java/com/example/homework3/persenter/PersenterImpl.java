package com.example.homework3.persenter;

import com.example.homework3.callback.MyCallBack;
import com.example.homework3.model.ModelImpl;
import com.example.homework3.view.IView;

import java.util.Map;

public class PersenterImpl implements Persenter{
    private ModelImpl model;
    private IView iView;

    public PersenterImpl(IView iView) {
        this.iView = iView;
        model=new ModelImpl();
    }

    @Override
    public void startRequest(String url, Map<String, String> params, Class clazz) {
        model.requestData(url, params, clazz, new MyCallBack() {
            @Override
            public void onSuccess(Object data) {
                iView.getDataSuccess(data);
            }

            @Override
            public void onFail(String error) {
                iView.getDataFail(error);
            }
        });
    }
}
