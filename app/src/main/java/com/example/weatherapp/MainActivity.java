package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;


import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    Intent intent;
    Repo repo = new Repo();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 3:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Validate the permissions result
                    if(!isMyServiceRunning(intent.getClass())){
                        Log.v("serviceTest", "Service triggered");
                        startService(intent);
                    }
                }else{
                    finish();
                }
                break;
        }
    }



    RestInterface restInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent = new Intent(getApplicationContext(),LocationTrackerService.class);


        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=  PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE}, 3);
        }else{
            startService(intent);
        }
        final RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ImageView imgToday = findViewById(R.id.imgToday);
        final TextView todayDescription = findViewById(R.id.todayDescription);
        final TextView todayhigh = findViewById(R.id.todayHighDegree);
        final TextView todayLow = findViewById(R.id.todayLowDegree);
        final TextView date=findViewById(R.id.date);

        restInterface= ApiClient.getClient().create(RestInterface.class);
        Call<Repo> call = restInterface.getRepo();
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                repo = response.body();
                MyAdapter adapter = new MyAdapter(getApplication(), repo);
                recyclerView.setAdapter(adapter);
                Picasso.get().load( "https://openweathermap.org/img/wn/" + repo.list.get(0).weather.get(0).icon + "@2x.png").into(imgToday);
                todayDescription.setText(repo.list.get(0).weather.get(0).main);
                String dates = MyAdapter.getReadableDateString(repo.list.get(0).dt, "dd/MM/yyyy");
                date.setText(dates);
                todayhigh.setText(String.valueOf(repo.list.get(0).temp.max + "\u2103" ));
                todayLow.setText(String.valueOf(repo.list.get(0).temp.min + "\u2103"));

                //recyclerView.notify();
                Log.v("aa", "aaa");
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                Log.v("aa", "aaa");
            }
        });
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("serviceTest", "main on destroy called");
        stopService(intent);
    }
}
