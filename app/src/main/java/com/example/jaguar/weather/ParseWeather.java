package com.example.jaguar.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class ParseWeather {
    public String UrliconWeather;
    WeatherObjFactory.WeatherObj wth;
    //List<WeatherObjFactory.WeatherObj> obj;

    public List<WeatherObjFactory.WeatherObj> parseWeather(JSONObject json){
        wth = new WeatherObjFactory.WeatherObj();

            try {
                String location = json.getJSONObject("location").getString("name");
                String temp = json.getJSONObject("current").getString("temp_c");
                String speedwind = json.getJSONObject("current").getString("wind_kph");
                String humidity = json.getJSONObject("current").getString("humidity");
                String cond = json.getJSONObject("current").getJSONObject("condition").getString("text");
                UrliconWeather = json.getJSONObject("current").getJSONObject("condition").getString("icon");
                wth.setText("Город: "+location+"\n"+
                        "t " + temp +"\n"+
                        cond+"\n" +
                        "Скорость ветра "+speedwind+" km/h"+"\n" +
                        "Влажность "+humidity+" %\n");
                wth.setImage("https:"+UrliconWeather);

            }catch(Exception e){
            }
//        if(UrliconWeather != null) {
//            ImageLoad load = new ImageLoad();
//            load.execute(UrliconWeather);
//        }
        //obj.add(wth);
        return Collections.singletonList(wth);
    }

}


