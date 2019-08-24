package com.example.jaguar.weather.model

import com.example.jaguar.weather.interfaces.CallBack
import com.example.jaguar.weather.common.WeatherObj
import com.example.jaguar.weather.common.ParseWeather

class WeatherModel{
    var ret = ParseWeather()
    fun updateWeather(str: String, call: CallBack) {
        ret.getWeatherFullTime(str, object : CallBack {
            override fun UpdateWeather(objs: MutableList<WeatherObj>) {
               call.UpdateWeather(objs)
            }
        })
    }
}