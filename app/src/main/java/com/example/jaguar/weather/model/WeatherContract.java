package com.example.jaguar.weather.model;

import java.util.List;

public interface WeatherContract {

    interface WeatherModel {
        void updateWeather(String str, CallBack call);
    }
    interface WeatherView {
        void updateAdapter(List<WeatherObj> objs);
        void showProgress();
        void hideProgress();
    }
    interface WeatherPresenter {
        void onSelect(String str);
    }

}
