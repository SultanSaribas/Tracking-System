package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp_ {
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @SerializedName("min") //Min daily temperature.
    @Expose
    public double min;
    @SerializedName("max") //Max daily temperature.
    @Expose
    public double max;
}
