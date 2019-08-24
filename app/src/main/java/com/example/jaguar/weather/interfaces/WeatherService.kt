package com.example.jaguar.weather.interfaces

import com.example.jaguar.weather.common.UserModelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("forecast.json")
     fun getWeather(@Query("key") key: String,
                            @Query("q") q: String,
                            @Query("lang") lang: String,
                            @Query("days") days: String): Call<UserModelResponse>
}