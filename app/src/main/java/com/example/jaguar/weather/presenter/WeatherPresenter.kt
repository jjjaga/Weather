package com.example.jaguar.weather.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.jaguar.weather.common.CallBack
import com.example.jaguar.weather.model.WeatherModel
import com.example.jaguar.weather.common.WeatherObj
import com.example.jaguar.weather.views.WeatherView

@InjectViewState
class WeatherPresenter : MvpPresenter<WeatherView>(){

    private var wModel: WeatherModel = WeatherModel()

    fun onSelect(str: String) {
        viewState.showProgress()
        wModel.updateWeather(str, object : CallBack {
            override fun UpdateWeather(objs: MutableList<WeatherObj>) {
                viewState.updateAdapter(objs)
                viewState.hideProgress()
            }
        })
    }
}