package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp_ {

    @SerializedName("min") //Min daily temperature.
    @Expose
    public double min;
    @SerializedName("max") //Max daily temperature.
    @Expose
    public double max;
}
