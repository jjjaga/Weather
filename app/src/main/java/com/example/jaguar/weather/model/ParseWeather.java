package com.example.jaguar.weather.model;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ParseWeather {
    private List<WeatherObj> list = new ArrayList<>();

    public List<WeatherObj> parseWeather(JSONObject json){

        for(int i=0; i<6; i++) {
            try {
                String location = json.getJSONObject("location").getString("name");
                String date = json.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(i).getString("date");
                String temp = json.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(i).getJSONObject("day").getString("maxtemp_c");
                String speedwind = json.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(i).getJSONObject("day").getString("maxwind_kph");
                String humidity = json.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(i).getJSONObject("day").getString("avghumidity");
                String UrliconWeather = json.getJSONObject("forecast").getJSONArray("forecastday").getJSONObject(i).getJSONObject("day").getJSONObject("condition").getString("icon");

                list.add(new WeatherObj("https:" + UrliconWeather,date+"\n"+"Город: " + location + "\n"+
                        "Макс. температура " + temp + "\n" +
                        "Макс. скорость ветра " + speedwind + " km/h" + "\n" +
                        "Влажность " + humidity + " %\n"));
            } catch (Exception e) {
            }
        }
        return list;
    }
}


