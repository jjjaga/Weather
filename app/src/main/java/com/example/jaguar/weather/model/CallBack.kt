package com.example.jaguar.weather.model

interface CallBack {
    fun UpdateWeather(objs: MutableList<WeatherObj>)
}