package com.example.admin.examone.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.admin.examone.R;
import com.example.admin.examone.pojo.SocialData;

import java.util.List;

/**
 * Created by Admin on 23-02-2018.
 */

public class Cust_SocialAdapter extends RecyclerView.Adapter<Cust_SocialAdapter.MyViewHolder>{
    private final Context context;
    private final List<SocialData> list;

    public Cust_SocialAdapter(Context context, List<SocialData> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.cust_social,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        SocialData socialData=list.get(position);
        Glide.with(context).load(socialData.getPic()).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        holder.txtFullName.setText(socialData.getFullName());
        holder.txtUsername.setText(socialData.getUsername());
        holder.txtUserTime.setText(socialData.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtFullName,txtUsername,txtUserTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imgInsta);
            txtFullName=itemView.findViewById(R.id.txtFullName);
            txtUsername=itemView.findViewById(R.id.txtUsername);
            txtUserTime=itemView.findViewById(R.id.txtInstaTime);
        }
    }
}
