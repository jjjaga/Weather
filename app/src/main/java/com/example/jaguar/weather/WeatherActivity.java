package com.example.jaguar.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaguar.weather.Resources.ConstApi;

import org.json.JSONObject;

import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {
    TextView text;
    ImageView imageWeather;
    public String UrliconWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        text = findViewById(R.id.hello);
        text.setText("sdf");
        imageWeather = findViewById(R.id.imageWeather);

        UpdateWeather upd = new UpdateWeather();
        upd.city = "Moscow"; upd.lang = "ru"; upd.days = "7";
        upd.execute();

    }
    class UpdateWeather extends AsyncTask<Void, Void, JSONObject> {
        String city; String lang; String days;

        @Override
        protected JSONObject doInBackground(Void... voids) {
            final JSONObject json = RemoteFetch.getJSON(ConstApi.KEY, city, lang, days);

            return json;
        }

        @Override
        protected void onPostExecute(JSONObject json) {
            ParseWeather parse = new ParseWeather();
            parse.parseWeather(json);
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
            imageWeather.setImageBitmap(result);
        }
    }
    public class ParseWeather {
        public void  parseWeather(JSONObject json){
            try {
                String location = json.getJSONObject("location").getString("name");
                String temp = json.getJSONObject("current").getString("temp_c");
                String speedwind = json.getJSONObject("current").getString("wind_kph");
                String cond = json.getJSONObject("current").getJSONObject("condition").getString("text");
                UrliconWeather = json.getJSONObject("current").getJSONObject("condition").getString("icon");
                text.setText("Город: "+location+"\nt " + temp +"\n"+cond+"\n"+"Скорость ветра "+ speedwind);

            }catch(Exception e){
            }
            if(UrliconWeather != null) {
                ImageLoad load = new ImageLoad();
                load.execute(UrliconWeather);
            }
        }
    }

}
