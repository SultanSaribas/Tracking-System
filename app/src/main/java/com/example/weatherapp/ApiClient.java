package com.example.weatherapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
//http://api.openweathermap.org/data/2.5/forecast/daily?q=Kayseri,T%C3%BCrkiye&appid=1b3a6d183e0681e26f960c86ee271000
    private static Retrofit retrofit=null;
    private static String Base_Url= "https://api.openweathermap.org/data/2.5/forecast/";
    public static Retrofit getClient(){
        if(retrofit== null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Base_Url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient())
                    .build();
            return retrofit;
        }
        return retrofit;
    }//ApiClient.class
}
