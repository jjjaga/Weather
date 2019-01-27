package com.example.jaguar.weather.model;

import java.util.List;

public class WeatherModel implements WeatherContract.WeatherModel {

    public void updateWeather(String str, final CallBack callBack) {
        new UpdateWeather(str, "ru", "7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                callBack.UpdateWeather(objs);
            }
        }).execute();
    }
}
