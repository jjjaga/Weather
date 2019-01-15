package com.example.jaguar.weather.presenter;

import android.widget.Spinner;
import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.UpdateWeather;
import com.example.jaguar.weather.model.WeatherObj;
import java.util.List;

public class WeatherPresenter {
    private WeatherAdapter wAdapter;
    private Spinner sp;

    public WeatherPresenter(WeatherAdapter wAdapter, Spinner sp) {
        this.wAdapter = wAdapter;
        this.sp = sp;
    }

    public void onSelect() {
        new UpdateWeather(sp.getSelectedItem().toString(), "ru", "7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                updateWeatherList(objs);
            }
        }).execute();

    }
    private void updateWeatherList(List<WeatherObj> objs) {
        wAdapter.setAll(objs);
    }

}
