package com.example.homework3.persenter;

import java.util.Map;

public interface Persenter {
    void startRequest(String url, Map<String, String> params, Class clazz);
}
