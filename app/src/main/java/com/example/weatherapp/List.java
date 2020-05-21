package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class List {
    @SerializedName("temp")
    @Expose
    public Temp_ temp;
    @SerializedName("weather")
    @Expose
    public Weather weather;
}
