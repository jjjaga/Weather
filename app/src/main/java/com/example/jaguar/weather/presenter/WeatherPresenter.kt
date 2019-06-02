package com.example.jaguar.weather.presenter

import com.example.jaguar.weather.model.CallBack
import com.example.jaguar.weather.model.WeatherContract
import com.example.jaguar.weather.model.WeatherModel
import com.example.jaguar.weather.model.WeatherObj

class WeatherPresenter(var wView: WeatherContract.WeatherView) : WeatherContract.WeatherPresenter{

    private var wModel: WeatherContract.WeatherModel = WeatherModel()

    override fun onSelect(str: String) {
        wView.showProgress()
        wModel.updateWeather(str, object : CallBack {
            override fun UpdateWeather(objs: MutableList<WeatherObj>) {
                wView.updateAdapter(objs)
                wView.hideProgress()
            }
        })
    }
}