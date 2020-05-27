package com.example.weatherapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Calendar;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private Repo myDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView imgoftheDay;
        public TextView nameoftheday;
        public TextView DescriptionoftheDay;
        public TextView HighDegree;
        public TextView lowDegree;


        public MyViewHolder(@NonNull View  itemView) {
            super(itemView);
            imgoftheDay =(ImageView) itemView.findViewById(R.id.imgoftheDay);
            nameoftheday =(TextView) itemView.findViewById(R.id.nameoftheday);
            DescriptionoftheDay = (TextView)itemView.findViewById(R.id.DescriptionoftheDay);
            HighDegree= (TextView)itemView.findViewById(R.id.HighDegree);
            lowDegree=(TextView) itemView.findViewById(R.id.lowDegree);

        }
    }

    public MyAdapter(Context context, Repo repo) {
        this.context = context;
        this.myDataset = repo;
    }


    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Picasso.get().load( "https://openweathermap.org/img/wn/" + myDataset.list.get(position).weather.get(0).icon + "@2x.png").into(holder.imgoftheDay);
        holder.nameoftheday.setText("2" + position +"/05/2021");
        holder.DescriptionoftheDay.setText(myDataset.list.get(position).weather.get(0).main);
        holder.HighDegree.setText(String.valueOf(myDataset.list.get(position).temp.max) + "\u2109");
        holder.lowDegree.setText(String.valueOf(myDataset.list.get(position).temp.min)+ "\u2109.");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myDataset.list.size();
    }
}