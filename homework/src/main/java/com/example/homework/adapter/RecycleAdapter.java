package com.example.homework.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.homework.Main2Activity;
import com.example.homework.R;
import com.example.homework.bean.RecycleBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private List<RecycleBean.DataBean> list;
    private Context context;

    public RecycleAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<RecycleBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<RecycleBean.DataBean> getList() {
        return list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder holder=null;
        View view=View.inflate(context, R.layout.item,null);
        holder=new ViewHolder(view);
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
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context,lists.get(0),Toast.LENGTH_LONG).show();
                context.startActivity(new Intent(context,Main2Activity.class));
                return false;
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
