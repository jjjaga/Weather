package com.example.jaguar.weather.common

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class RetrofitConnection {
    private val listWe = ArrayList<WeatherObj>()
    var retrofit : Retrofit

    constructor(){
        val httpClient = OkHttpClient.Builder()
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logger)

         retrofit = Retrofit.Builder()
                .baseUrl(ConstApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
    }

    fun getWeatherFullTime(str: String, callBack: CallBack) {
        val weatherService : WeatherService = retrofit.create(WeatherService::class.java)
        val weather : Call<UserModelResponse> = weatherService.getWeather(
                ConstApi.ACCSESS_TOKEN, str, "ru", "7")

        weather.enqueue(object : Callback<UserModelResponse> {
            override fun onResponse(call: Call<UserModelResponse>, response: Response<UserModelResponse>) {
                listWe.clear()
                val code = response.code()
                when (code) {
                    200 ->
                        for (i in 0..5) {
                            listWe.add(WeatherObj("Город: " + response.body()!!.location.name,
                                    response.body()!!.forecast.forecastday[i].day.condition.icon,
                                    response.body()!!.forecast.forecastday[i].day.condition.text,
                                    response.body()!!.forecast.forecastday[i].date))
                            listWe.add(WeatherObj("Город: " + response.body()!!.location.name,
                                    response.body()!!.forecast.forecastday[i].day.condition.icon,
                                    response.body()!!.forecast.forecastday[i].day.condition.text,
                                    response.body()!!.forecast.forecastday[i].date))
                            listWe.add(WeatherObj("Город: " + response.body()!!.location.name,
                                    response.body()!!.forecast.forecastday[i].day.condition.icon,
                                    response.body()!!.forecast.forecastday[i].day.condition.text,
                                    response.body()!!.forecast.forecastday[i].date))
                        }
                    400 -> println(" 404!!!!!!!!!!!")
                    else -> println(" что-то пошло не так")
                }
                callBack.UpdateWeather(listWe)
            }

            override fun onFailure(call: Call<UserModelResponse>, t: Throwable) {
                println(t)
            }
        })
    }
}