package com.example.jaguar.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherActivity extends AppCompatActivity {
    public static TextView text;
    public static ImageView imageWeather;
    public static Button button;
    public static EditText enterCity;
    View view;
    UpdateWeather upd = new UpdateWeather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        text = findViewById(R.id.hello);
        text.setText("null");
        imageWeather = findViewById(R.id.imageWeather);
        button = findViewById(R.id.button);
        enterCity = findViewById(R.id.enterCity);
    }
    public void updateButton(View view)
    {
        upd.city = enterCity.getText().toString();
        upd.lang = "ru";
        upd.days = "7";
        upd.execute();
    }
}
