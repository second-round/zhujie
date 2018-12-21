package com.example.hyyyuekao.persenter;

import com.example.hyyyuekao.model.ModelImpl;
import com.example.hyyyuekao.util.MyCallBack;
import com.example.hyyyuekao.view.IView;

import java.util.Map;

public class PersenterImpl implements Persenter{
    private IView iView;
    private ModelImpl model;

    public PersenterImpl(IView iView) {
        this.iView = iView;
        model=new ModelImpl();
    }

    @Override
    public void sendMessage(String path, Map<String, String> map, Class imageBeanClass) {
        model.sendMessage(path,map,imageBeanClass, new MyCallBack() {
            @Override
            public void setData(Object o) {
                iView.setData(o);
            }
        });
    }
}
