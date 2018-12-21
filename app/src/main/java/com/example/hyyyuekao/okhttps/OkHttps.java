package com.example.hyyyuekao.okhttps;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class OkHttps {
    private static OkHttps instance;
    OkHttpClient client;
    private Handler handler=new Handler(Looper.getMainLooper());
    public static OkHttps getInstance() {
        if (instance==null){
            synchronized (OkHttps.class){
                instance=new OkHttps();
            }
        }
        return instance;
    }

    public OkHttps() {
        client=new OkHttpClient.Builder()
                .writeTimeout(10,TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .build();
    }

    public void setData(String url, Map<String,String> map, final Class clazz, final ICallBack iCallBack){
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String,String> maps:map.entrySet()){
            builder.add(maps.getKey(),maps.getValue());
        }
        RequestBody body=builder.build();
        Request request=new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                iCallBack.failed(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                final Object o = new Gson().fromJson(string, clazz);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        iCallBack.success(o);
                    }
                });
            }
        });


    }


}