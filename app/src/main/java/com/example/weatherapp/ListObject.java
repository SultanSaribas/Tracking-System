package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListObject {
    @SerializedName("temp")
    @Expose
    public Temp_ temp;
    @SerializedName("dt")
    @Expose
    public long dt;
    @SerializedName("weather")
    @Expose
    public List<Weather> weather;
}
