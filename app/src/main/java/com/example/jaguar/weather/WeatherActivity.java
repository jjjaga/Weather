package com.example.jaguar.weather;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jaguar.weather.Resources.ConstApi;

import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        text = findViewById(R.id.hello);
        text.setText("sdf");

        UpdateWeather upd = new UpdateWeather();
        upd.city = "Москва"; upd.lang = "ru"; upd.days = "7";
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
    public class ParseWeather {
        public void  parseWeather(JSONObject json){
            try {
                String location = json.getJSONObject("location").getString("name").toString();
                String temp = json.getJSONObject("current").getString("temp_c").toString();
                String cond = json.getJSONObject("current").getJSONObject("condition").getString("text").toString();
                text.setText("В городе "+location+" температура " + temp + ""+cond);
            }catch(Exception e){
            }
        }
    }
}
