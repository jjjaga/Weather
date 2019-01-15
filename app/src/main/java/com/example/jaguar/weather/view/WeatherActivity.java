package com.example.jaguar.weather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.presenter.WeatherAdapter;
import com.example.jaguar.weather.presenter.WeatherPresenter;

public class WeatherActivity extends AppCompatActivity {
    private WeatherAdapter wAdapter;
    private RecyclerView wRecyclerView;
    private Spinner sp;
    private WeatherPresenter pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        wAdapter = new WeatherAdapter(this);
        wRecyclerView = findViewById(R.id.recyclerView);
        sp = findViewById(R.id.spinner);

        wRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        wRecyclerView.setAdapter(wAdapter);

        pr = new WeatherPresenter(wAdapter,sp);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                pr.onSelect();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
