package com.example.weatherapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.ActivityCompat;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.Bundle;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    Intent intent;

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


        restInterface= ApiClient.getClient().create(RestInterface.class);
        Call<Repo> call = restInterface.getRepo();
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {

            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {

            }

            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
           /*     List<Repo> myList = new ArrayList<>();
                myList=response.body();*/

          //      System.out.println(""+ City.class.getName() + "\n");

         /*       for (int i=0; i<myList.size(); i++){
                    System.out.println(""+ myList.get(i).city.name+ "\n");
                    Log.v(""+ myList.get(i).list.weather.main + "\n", "mesaj");


                }*/
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

            }
        })

        if (checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) !=  PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE}, 3);
        }else{
            startService(intent);
        }




        /*
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
        */


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
