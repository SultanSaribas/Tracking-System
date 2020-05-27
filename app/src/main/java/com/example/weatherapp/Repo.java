package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repo {
    @SerializedName("city")
    @Expose
    public City city;

    @SerializedName("list")
    @Expose
    public List<ListObject> list;
}
