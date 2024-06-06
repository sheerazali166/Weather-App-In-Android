package com.example.weatherapp.API;

import com.example.weatherapp.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sheeraz on 6/6/2024.
 */


public interface WeatherInterface {


    @GET("weather?")
    Call<WeatherResponse> getWeatherFromCity(

            @Query("id") String id,
            @Query("APIKEY") String api_key,
            @Query("units") String units
    );

}
