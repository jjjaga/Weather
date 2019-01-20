package com.example.jaguar.weather.presenter;

import com.example.jaguar.weather.WeatherContract;
import com.example.jaguar.weather.model.WeatherModel;

public class WeatherPresenter implements WeatherContract.WeatherPresenter {
    private WeatherContract.WeatherView wView;
    private WeatherContract.WeatherModel wModel;

    public WeatherPresenter(WeatherContract.WeatherView wView) {
        this.wView = wView;
        this.wModel = new WeatherModel();
    }

    public void onSelect(String str) {
        wView.updateAdapter(wModel.updateWeather(str));
    }
}
