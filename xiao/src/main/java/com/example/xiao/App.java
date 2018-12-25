package com.example.xiao;

import android.app.Application;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;

import java.io.File;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        Fresco.initialize(this);
        //高级初始化
        Fresco.initialize(this,ImagePipelineConfig.newBuilder(App.this)
                .setMainDiskCacheConfig(
                        DiskCacheConfig.newBuilder(this)
                                .setBaseDirectoryPath(new File("SD卡路径"))
                                .build()
                )
                .build());
    }
}