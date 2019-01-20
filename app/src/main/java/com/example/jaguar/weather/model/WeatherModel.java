package com.example.jaguar.weather.model;

import com.example.jaguar.weather.WeatherContract;
import java.util.List;

public class WeatherModel implements WeatherContract.WeatherModel {
    public List<WeatherObj> getObj() {
        return obj;
    }

    private List<WeatherObj> obj;

    public void setObj(List<WeatherObj> objs) {
        this.obj = objs;
    }
    public void updateWeather(String str, final CallBack callBack) {
        new UpdateWeather(str, "ru", "7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                callBack.UpdateWeather(objs);
            }
        }).execute();
    }
}
