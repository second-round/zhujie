package com.example.hyyyuekao.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.hyyyuekao.R;
import com.example.hyyyuekao.bean.RecycleBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<RecycleBean.DataBean.UserBean> list;
    private Context context;
    private boolean linear;

    public RecycleAdapter(Context context,boolean isLinear) {
        this.context = context;
        list=new ArrayList<>();
        this.linear=isLinear;
    }

    public void setList(List<RecycleBean.DataBean.UserBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<RecycleBean.DataBean.UserBean> getList() {
        return list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder holder=null;
        if (linear){
            View view=View.inflate(context, R.layout.item_one,null);
            holder=new ViewHolder(view);
        }else {
            View view=View.inflate(context,R.layout.item_two,null);
            holder=new ViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String images = list.get(i).getImages();
        String[] split = images.split("\\|");
        final List<String> lists = Arrays.asList(split);
        Glide.with(context).load(lists.get(0)).into(viewHolder.imageView);
        viewHolder.textView.setText(list.get(i).getTitle());
        viewHolder.textView2.setText(list.get(i).getPrice()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,lists.get(0),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView textView,textView2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);
            textView2=itemView.findViewById(R.id.textView2);
        }
    }
}
