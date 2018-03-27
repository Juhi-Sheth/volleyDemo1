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
import com.example.admin.examone.pojo.AllData;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Admin on 23-02-2018.
 */

public class Cust_ALLadapter extends RecyclerView.Adapter<Cust_ALLadapter.MyViewHolder> {
    private final Context context;
    private final List<AllData> list;

    public Cust_ALLadapter(Context context, List<AllData> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.cust_all,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AllData allData=list.get(position);
        String imgUrl="https://www.allintheloop.net/assets/user_files/"+allData.getImg();
        Glide.with(context).load(imgUrl).thumbnail(0.1f).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.imageView);
        holder.txtfName.setText(allData.getFname()+" "+allData.getLname());
        holder.txtPosition.setText(allData.getPosition());
        holder.txtCompany.setText(allData.getCompany());
        holder.txtTime.setText(allData.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView txtfName,txtPosition,txtCompany,txtTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.img);
            txtfName=itemView.findViewById(R.id.txtfName);
            txtPosition=itemView.findViewById(R.id.txtPosition);
            txtCompany=itemView.findViewById(R.id.txtCompany);
            txtTime=itemView.findViewById(R.id.txtTime);
        }
    }
}
