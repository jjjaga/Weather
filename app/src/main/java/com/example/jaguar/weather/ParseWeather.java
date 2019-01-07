package com.example.jaguar.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.InputStream;

public class ParseWeather {
    public String UrliconWeather;
    WeatherObjFactory.WeatherObj wth;

    public void  parseWeather(JSONObject json){
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

            }catch(Exception e){
            }
            if(UrliconWeather != null) {
                ImageLoad load = new ImageLoad();
                load.execute(UrliconWeather);
            }
        WeatherObjFactory.setWeatherObj(wth);
        }
    class ImageLoad extends AsyncTask<String, Void, Bitmap> {

        protected Bitmap doInBackground(String... strings) {
            String urldisplay = "https:"+UrliconWeather;
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            wth.setImage(result);
        }
    }
    }


