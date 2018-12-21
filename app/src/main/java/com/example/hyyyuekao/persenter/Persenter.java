package com.example.hyyyuekao.persenter;

import com.example.hyyyuekao.bean.ImageBean;

import java.util.Map;

public interface Persenter {
    void sendMessage(String pathImage, Map<String,String> map, Class imageBeanClass);
}
