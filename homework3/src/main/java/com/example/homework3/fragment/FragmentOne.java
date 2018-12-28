package com.example.homework3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.homework3.R;

import org.greenrobot.eventbus.EventBus;

public class FragmentOne extends Fragment {
    private Button button1,button2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentont,container,false);
        button1=view.findViewById(R.id.button2);
        button2=view.findViewById(R.id.button3);
        initView();

        return view;
    }

    private void initView() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().unregister(this);
                EventBus.getDefault().postSticky(new EvBean(1,"张自磊我喜欢的人"));
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().unregister(this);
                EventBus.getDefault().postSticky(new EvBean(2,"啦啦啦,张自磊我喜欢的人"));
            }
        });
    }
}