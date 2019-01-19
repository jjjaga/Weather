package com.example.jaguar.weather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.presenter.WeatherAdapter;
import com.example.jaguar.weather.presenter.WeatherPresenter;

public class WeatherActivity extends AppCompatActivity {
    public static WeatherAdapter wAdapter;
    private RecyclerView wRecyclerView;
    private Spinner wSpinner;
    private WeatherPresenter wPresenter;
    private ProgressBar wProgresBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        wRecyclerView = findViewById(R.id.recyclerView);
        wSpinner = findViewById(R.id.spinner);
        wProgresBar = findViewById(R.id.progressBar);
        wAdapter = new WeatherAdapter(this, wRecyclerView);
        wPresenter = new WeatherPresenter(wSpinner,wProgresBar);

        wSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                wPresenter.onSelect();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
