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

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<WeatherInfo> myDataset;

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

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, ArrayList<WeatherInfo> myDataset) {
        this.context = context;
        this.myDataset = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new MyAdapter.MyViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.imgoftheDay.setImageResource(myDataset.get(position).getImage());
        holder.nameoftheday.setText(myDataset.get(position).getName());
        holder.DescriptionoftheDay.setText(myDataset.get(position).getDescription());
        holder.HighDegree.setText(myDataset.get(position).getHighDegree());
        holder.lowDegree.setText(myDataset.get(position).getLowDegree());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return myDataset.size();
    }
}