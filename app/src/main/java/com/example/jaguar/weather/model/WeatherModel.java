package com.example.jaguar.weather.model;

import com.example.jaguar.weather.model.network.RetrofitConnection;


import java.util.ArrayList;
import java.util.List;

public class WeatherModel implements WeatherContract.WeatherModel {
    List<WeatherObj> list = new ArrayList<>();

    @Override
    public void updateWeather(String str, CallBack call) {

        RetrofitConnection ret = new RetrofitConnection(str);
        ret.getWeatherFullTime(new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                list = objs;
            }
        });
        call.UpdateWeather(list);
    }
}
