package com.example.jaguar.weather;

import java.util.List;

interface CallBack {
    void UpdateWeather(List<WeatherObjFactory.WeatherObj> objs);

}