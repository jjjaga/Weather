package com.example.jaguar.weather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jaguar.weather.R;
import com.example.jaguar.weather.presenter.WeatherAdapter;
import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.UpdateWeather;
import com.example.jaguar.weather.model.WeatherObj;

import java.util.List;

public class WeatherActivity extends AppCompatActivity {
    private WeatherAdapter wAdapter;
    private RecyclerView wRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        wAdapter = new WeatherAdapter(this);
        wRecyclerView = findViewById(R.id.recyclerView);
        wRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        wRecyclerView.setAdapter(wAdapter);

        new UpdateWeather("Москва","ru","7", new CallBack() {
            @Override
            public void UpdateWeather(List<WeatherObj> objs) {
                    updateWeatherList(objs);
            }
        }).execute();
    }

    private void updateWeatherList(List<WeatherObj> objs) {
        wAdapter.setAll(objs);
    }
}
