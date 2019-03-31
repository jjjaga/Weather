package com.example.jaguar.weather.model;

import com.example.jaguar.weather.model.network.RetrofitConnection;
import java.util.List;

public class WeatherModel implements WeatherContract.WeatherModel {
    RetrofitConnection ret = new RetrofitConnection();
    @Override
    public void updateWeather(String str, final CallBack call) {
        ret.getWeatherFullTime(str, new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                call.UpdateWeather(objs);
            }
        });
    }
}
