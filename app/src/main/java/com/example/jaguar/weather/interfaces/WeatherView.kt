package com.example.jaguar.weather.interfaces

import com.arellomobile.mvp.MvpView
import com.example.jaguar.weather.common.WeatherObj

interface WeatherView : MvpView {
    fun updateAdapter(objs: MutableList<WeatherObj>)
    fun showProgress()
    fun hideProgress()
}