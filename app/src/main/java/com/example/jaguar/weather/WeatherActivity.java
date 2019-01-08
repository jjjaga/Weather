package com.example.jaguar.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class WeatherActivity extends AppCompatActivity implements WeatherView {
    private WeatherAdapter wAdapter;
    private RecyclerView wRecyclerView;
    private WeatherPresenter weatherPresenter = new WeatherPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        wAdapter = new WeatherAdapter(this);
        wRecyclerView = findViewById(R.id.recyclerView);
        wRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        wRecyclerView.setAdapter(wAdapter);

        weatherPresenter.onCreate();

        new UpdateWeather("Москва","ru","7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObjFactory.WeatherObj> objs) {
                    updateWeatherList(objs);
            }
        }).execute();
    }

    private void updateWeatherList(List<WeatherObjFactory.WeatherObj> objs) {
        wAdapter.setAll(objs);
    }
}
