package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather {
    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @SerializedName("main")  //desciptionoftheWeather -- snow, rain ...
    @Expose
    public String main;
    @SerializedName("icon") //weathericon ID
    @Expose
    public String icon;
}
