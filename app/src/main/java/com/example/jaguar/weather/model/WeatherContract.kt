package com.example.jaguar.weather.model

interface WeatherContract {
    interface WeatherModel {
        fun updateWeather(str: String, call: CallBack)
    }

    interface WeatherView {
        fun updateAdapter(objs: MutableList<WeatherObj>)
        fun showProgress()
        fun hideProgress()
    }

    interface WeatherPresenter {
        fun onSelect(str: String)
    }
}