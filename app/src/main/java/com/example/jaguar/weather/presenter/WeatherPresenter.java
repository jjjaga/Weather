package com.example.jaguar.weather.presenter;

import android.widget.ProgressBar;
import android.widget.Spinner;
import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.UpdateWeather;
import com.example.jaguar.weather.model.WeatherObj;
import com.example.jaguar.weather.view.WeatherActivity;

import java.util.List;

public class WeatherPresenter {
    private Spinner wSpinner;
    private ProgressBar wProgressBar;

    public WeatherPresenter(Spinner sp, ProgressBar pb) {
        this.wSpinner = sp;
        this.wProgressBar = pb;
    }

    public void onSelect() {
        new UpdateWeather(wProgressBar, wSpinner.getSelectedItem().toString(), "ru", "7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                updateWeatherList(objs);
            }
        }).execute();

    }
    private void updateWeatherList(List<WeatherObj> objs) {
        WeatherActivity.wAdapter.setAll(objs);
    }

}
