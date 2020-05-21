package com.example.weatherapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RestInterface restInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
