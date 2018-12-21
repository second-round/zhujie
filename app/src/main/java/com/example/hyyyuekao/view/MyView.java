package com.example.hyyyuekao.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.hyyyuekao.LoginActivity;
import com.example.hyyyuekao.MainActivity;
import com.example.hyyyuekao.R;
import com.example.hyyyuekao.ZXingActivity;

public class MyView extends RelativeLayout implements View.OnClickListener {
    private Context context;
    public MyView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        this.context=context;
        View view=View.inflate(context, R.layout.myview,null);
        ImageView zxing=view.findViewById(R.id.zxing);
        ImageView change=view.findViewById(R.id.change);
        EditText findText=view.findViewById(R.id.findtext);
        zxing.setOnClickListener(this);
        change.setOnClickListener(this);
        addView(view);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zxing:
                Intent intent=new Intent(context,ZXingActivity.class);
                context.startActivity(intent);
                break;
            case R.id.change:
                ((LoginActivity)context).huan();
                break;
            default:
                break;
        }
    }
}
