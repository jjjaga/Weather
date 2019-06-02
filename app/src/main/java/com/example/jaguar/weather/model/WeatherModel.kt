package com.example.jaguar.weather.model

import com.example.jaguar.weather.model.network.RetrofitConnection

class WeatherModel : WeatherContract.WeatherModel {
    var ret = RetrofitConnection()
    override fun updateWeather(str: String, call: CallBack) {
        ret.getWeatherFullTime(str, object :CallBack{
            override fun UpdateWeather(objs: MutableList<WeatherObj>) {
               call.UpdateWeather(objs)
            }
        })
    }
}