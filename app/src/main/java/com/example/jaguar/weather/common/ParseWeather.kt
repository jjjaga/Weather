package com.example.jaguar.weather.common

import com.example.jaguar.weather.interfaces.CallBack
import com.example.jaguar.weather.interfaces.DaggerWeatherComponent
import com.example.jaguar.weather.interfaces.WeatherService
import retrofit2.*
import java.util.ArrayList
import javax.inject.Inject

class ParseWeather {
    @Inject lateinit var retrofit: Connection

    private val listWe = ArrayList<WeatherObj>()

    fun getWeatherFullTime(str: String, callBack: CallBack) {
        DaggerWeatherComponent.create().inject(this)

        val weatherService : WeatherService = retrofit.some().create(WeatherService::class.java)
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