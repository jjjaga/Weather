package com.example.jaguar.weather.model

import com.example.jaguar.weather.common.CallBack
import com.example.jaguar.weather.common.WeatherObj
import com.example.jaguar.weather.common.RetrofitConnection

class WeatherModel{
    var ret = RetrofitConnection()
    fun updateWeather(str: String, call: CallBack) {
        ret.getWeatherFullTime(str, object : CallBack {
            override fun UpdateWeather(objs: MutableList<WeatherObj>) {
               call.UpdateWeather(objs)
            }
        })
    }
}