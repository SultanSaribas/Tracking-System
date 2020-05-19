package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<WeatherInfo> wi = new ArrayList<>();

        WeatherInfo w1=new WeatherInfo();
        w1.setImage(R.drawable.ic_launcher_background);
        w1.setName("Pazartesi");
        w1.setDescription("Parçalı Bulutlu");
        w1.setHighDegree("23°");
        w1.setLowDegree("12°");


        WeatherInfo w2=new WeatherInfo();
        w2.setImage(R.drawable.ic_launcher_background);
        w2.setName("Salı");
        w2.setDescription("Bulutlu");
        w2.setHighDegree("23°");
        w2.setLowDegree("12°");


        wi.add(w1);
        wi.add(w2);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MyAdapter adapter= new MyAdapter(this,wi);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(lm);


    }
}
