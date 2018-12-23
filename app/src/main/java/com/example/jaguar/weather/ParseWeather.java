package com.example.jaguar.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import org.json.JSONObject;
import java.io.InputStream;

public class ParseWeather {
    public String UrliconWeather;

            public void  parseWeather(JSONObject json){
            try {
                String location = json.getJSONObject("location").getString("name");
                String temp = json.getJSONObject("current").getString("temp_c");
                String speedwind = json.getJSONObject("current").getString("wind_kph");
                String cond = json.getJSONObject("current").getJSONObject("condition").getString("text");
                UrliconWeather = json.getJSONObject("current").getJSONObject("condition").getString("icon");
                WeatherActivity.text.setText("Город: "+location+"\nt " + temp +"\n"+cond+"\n"+"Скорость ветра "+ speedwind);

            }catch(Exception e){
            }
            if(UrliconWeather != null) {
                ImageLoad load = new ImageLoad();
                load.execute(UrliconWeather);
            }
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
            WeatherActivity.imageWeather.setImageBitmap(result);
        }
    }
    }


