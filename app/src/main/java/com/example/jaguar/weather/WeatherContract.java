package com.example.jaguar.weather;

import com.example.jaguar.weather.model.WeatherObj;
import java.util.List;

public interface WeatherContract {

    interface WeatherModel {
        List<WeatherObj> updateWeather(String str);
    }
    interface WeatherView {
        void updateAdapter(List<WeatherObj> objs);
    }
    interface WeatherPresenter {
        void onSelect(String str);
    }

}
