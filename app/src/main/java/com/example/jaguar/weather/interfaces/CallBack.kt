package com.example.jaguar.weather.interfaces

import com.example.jaguar.weather.common.WeatherObj

interface CallBack {
    fun UpdateWeather(objs: MutableList<WeatherObj>)
}