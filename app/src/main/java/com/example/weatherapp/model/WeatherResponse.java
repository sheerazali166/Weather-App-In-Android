package com.example.weatherapp.model;

import java.util.ArrayList;

/**
 * Created by Sheeraz on 6/6/2024.
 */

public class WeatherResponse {

    private Coord coord;
    public Coord getCoord() { return this.coord; }
    public void setCoord(Coord coord) { this.coord = coord; }
    private ArrayList<Weather> weather;
    public ArrayList<Weather> getWeather() { return this.weather; }
    public void setWeather(ArrayList<Weather> weather) { this.weather = weather; }
    private String base;
    public String getBase() { return this.base; }
    public void setBase(String base) { this.base = base; }
    private Main main;
    public Main getMain() { return this.main; }
    public void setMain(Main main) { this.main = main; }
    private int visibility;
    public int getVisibility() { return this.visibility; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
    private Wind wind;
    public Wind getWind() { return wind; }
    public void setWind(Wind wind) { this.wind = wind; }
    private Clouds clouds;
    public Clouds getClouds() { return this.clouds; }
    public void setClouds(Clouds clouds) { this.clouds = clouds; }
    private int dt;
    public int getDt() { return this.dt; }
    public void setDt(int dt) { this.dt = dt; }
    private Sys sys;
    public Sys getSys() { return this.sys; }
    public void setSys(Sys sys) { this.sys = sys; }
    private int id;
    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }
    private String name;
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    private int cod;
    public int getCod() { return this.cod; }
    public void setCod(int cod) { this.cod = cod; }


}
