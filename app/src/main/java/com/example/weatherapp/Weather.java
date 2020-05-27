package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("main")  //desciptionoftheWeather -- snow, rain ...
    @Expose
    public String main;
    @SerializedName("icon") //weathericon ID
    @Expose
    public String icon;
}
