package com.example.hyyyuekao.adapter;

import android.content.Context;
        import android.support.annotation.NonNull;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.bumptech.glide.Glide;
        import com.example.hyyyuekao.R;
import com.example.hyyyuekao.bean.NineBean;
        import java.util.ArrayList;
        import java.util.List;
public class NineAdapter extends RecyclerView.Adapter<NineAdapter.ViewHolder> {
    private List<NineBean.DataBean> list;
    private Context context;

    public NineAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<NineBean.DataBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public List<NineBean.DataBean> getList() {
        return list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ViewHolder holder=null;
        View view=View.inflate(context, R.layout.item_two,null);
        holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(list.get(i).getIcon()).into(viewHolder.imageView);
        viewHolder.textView.setText(list.get(i).getName());
        viewHolder.textView2.setVisibility(View.GONE);
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