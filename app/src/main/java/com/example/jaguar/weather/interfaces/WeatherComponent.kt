package com.example.jaguar.weather.interfaces

import com.example.jaguar.weather.common.ParseWeather
import com.example.jaguar.weather.common.RetrofitConnectionModule
import dagger.Component


@Component(modules= [RetrofitConnectionModule::class])
interface WeatherComponent {
    fun inject(app: ParseWeather)
}