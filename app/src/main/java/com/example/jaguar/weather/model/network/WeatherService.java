package com.example.jaguar.weather.model.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

    public interface WeatherService {
        @GET("forecast.json")
        Call<UserModelResponse> getWeather(@Query("key") String key,
                                           @Query("q") String q,
                                           @Query("lang") String lang,
                                           @Query("days") String days);
    }

