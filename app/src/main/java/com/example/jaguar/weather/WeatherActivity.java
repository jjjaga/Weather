package com.example.jaguar.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {
    public static TextView text;
    public static ImageView imageWeather;
    public static Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        text = findViewById(R.id.hello);
        text.setText("sdf");
        imageWeather = findViewById(R.id.imageWeather);
        button = findViewById(R.id.button);

        UpdateWeather upd = new UpdateWeather();
        upd.city = "Moscow";
        upd.lang = "ru";
        upd.days = "7";
        upd.execute();
    }
}
