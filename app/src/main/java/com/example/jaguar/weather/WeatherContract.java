package com.example.jaguar.weather;

import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.WeatherObj;
import java.util.List;

public interface WeatherContract {

    interface WeatherModel {
        void updateWeather(String str, CallBack callBack);
        List<WeatherObj> getObj();
        void setObj(List<WeatherObj> obj);
    }
    interface WeatherView {
        void updateAdapter(List<WeatherObj> objs);
    }
    interface WeatherPresenter {
        void onSelect(String str);
    }

}
