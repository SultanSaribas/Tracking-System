package com.example.weatherapp;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestInterface {
    @GET ("daily?q=Kayseri,T%C3%BCrkiye&appid=1b3a6d183e0681e26f960c86ee271000&units=metric")
    Call<Repo> getRepo();
}
