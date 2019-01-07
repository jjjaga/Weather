package com.example.jaguar.weather;

import android.graphics.Bitmap;

import java.util.List;

public class WeatherObjFactory {

    public static List<WeatherObj> listWeather;

    public static void setWeatherObj(WeatherObj weatherObj) {
        WeatherObjFactory.weatherObj = weatherObj;
    }

    public static WeatherObj weatherObj;

    public static class WeatherObj{
        static Bitmap image;
        static String text;

        public Bitmap getImage() {
            return image;
        }
        public void setImage(Bitmap image) {
            this.image = image;
        }
        public String getText() {
            return text;
        }
        public void setText(String text) {
            this.text = text;
        }

    }

    public static List<WeatherObj> getList(){
        listWeather.add(weatherObj);
        return listWeather;
    }
}
