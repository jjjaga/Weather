package com.example.jaguar.weather.presenter;

import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.WeatherContract;
import com.example.jaguar.weather.model.WeatherModel;
import com.example.jaguar.weather.model.WeatherObj;
import java.util.List;

public class WeatherPresenter implements WeatherContract.WeatherPresenter {
    private final WeatherContract.WeatherView wView;
    private final WeatherContract.WeatherModel wModel;

    public WeatherPresenter(WeatherContract.WeatherView wView) {
        this.wView = wView;
        this.wModel = new WeatherModel();
    }

    public void onSelect(String str) {
        wView.showProgress();
        wModel.updateWeather(str, new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                wView.updateAdapter(objs);
                wView.hideProgress();
            }
        });
    }
}
