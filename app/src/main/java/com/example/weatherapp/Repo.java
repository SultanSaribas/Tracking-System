package com.example.weatherapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Repo {
    @SerializedName("city")
    @Expose
    public City city;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List getList() {
        return list;
    }

    public void setList(ListObject listObject) {
        this.list = list;
    }

    @SerializedName("list")
    @Expose
    public List<ListObject> list;
}
