package com.example.weatherapp;

public class WeatherInfo {
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHighDegree() {
        return highDegree;
    }

    public void setHighDegree(String highDegree) {
        this.highDegree = highDegree;
    }

    public String getLowDegree() {
        return lowDegree;
    }

    public void setLowDegree(String lowDegree) {
        this.lowDegree = lowDegree;
    }

    private int image;
private String name;
private String description;
private String highDegree;
private String lowDegree;



}
