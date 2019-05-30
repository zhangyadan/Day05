package com.example.mode3.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mode3.R;
import com.example.mode3.beans.User;

import java.util.ArrayList;

/**
 * Created by 张亚丹 on 2019/5/29.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    private ArrayList<User.ResultsBean> list;
    private Context context;

    public MyAdapter(ArrayList<User.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        User.ResultsBean resultsBean = list.get(position);
        holder.tv_title.setText(resultsBean.getDesc());
        Glide.with(context).load(resultsBean.getUrl()).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickm.onClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface onItemClick{
        void onClick();
    }
    private onItemClick mOnItemClickm;

    public void setOnItemClick(onItemClick onItemClick) {
        mOnItemClickm = onItemClick;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_title;
        private ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            img = itemView.findViewById(R.id.img);
        }
    }
}
