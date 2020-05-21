package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temp_ {
    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    @SerializedName("min") //Min daily temperature.
    @Expose
    public Float min;
    @SerializedName("max") //Max daily temperature.
    @Expose
    public Float max;
}
