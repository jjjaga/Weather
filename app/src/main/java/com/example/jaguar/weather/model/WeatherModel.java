package com.example.jaguar.weather.model;

import com.example.jaguar.weather.WeatherContract;

import java.util.List;

public class WeatherModel implements WeatherContract.WeatherModel {
    private List<WeatherObj> obj;
    public List<WeatherObj> updateWeather(String str) {
        new UpdateWeather(str, "ru", "7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                addObj(objs);
            }
        }).execute();
        return obj;
    }
    public void addObj(List<WeatherObj> objs){
        this.obj = objs;
    }

}
