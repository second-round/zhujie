package com.example.homework3;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.homework3.adapter.MainPageAdapter;

public class Main2Activity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tabLayout=findViewById(R.id.tab);
        pager = findViewById(R.id.fragent);
        pager.setAdapter(new MainPageAdapter(getSupportFragmentManager()));
        TabLayout tabLayout = findViewById(R.id.tab);
        //使tabLayout和contents结合起来
        tabLayout.setupWithViewPager(pager);
    }
}
