package com.example.jaguar.weather.common

class WeatherObj(var text: String, var imgUrl: String, var weatherCondition: String, var date: String) {

    var text1: String = ""
        get() = this.text
        set(value) {
            field = value
        }
    var weatherCondition1: String = ""
        get() = this.weatherCondition
        set(value) {
            field = value
        }
    var imgUrl1: String = ""
        get() = "https:"+this.imgUrl
        set(value) {
            field = value
        }
    var date1: String = ""
        get() = this.date
        set(value) {
            field = value
        }
}