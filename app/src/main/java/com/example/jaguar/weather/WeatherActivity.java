package com.example.jaguar.weather;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    WeatherAdapter wAdapter;
    RecyclerView wRecyclerView;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        context = getBaseContext();
        wRecyclerView = findViewById(R.id.recyclerView);
        wRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        new UpdateWeather("Moskow","ru","7");

        List<WeatherObjFactory.WeatherObj> weatherList = WeatherObjFactory.getList();
        wAdapter = new WeatherAdapter(weatherList);
        wRecyclerView.setAdapter(wAdapter);
    }
}
