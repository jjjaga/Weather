package com.example.jaguar.weather;

import java.util.List;

interface Callback {
    void UpdateWeather(List<WeatherObjFactory.WeatherObj> objs);

}