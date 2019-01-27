package com.example.jaguar.weather.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.WeatherContract;
import com.example.jaguar.weather.model.WeatherObj;
import com.example.jaguar.weather.presenter.WeatherAdapter;
import com.example.jaguar.weather.presenter.WeatherPresenter;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements WeatherContract.WeatherView {
    private WeatherAdapter wAdapter;
    private RecyclerView wRecyclerView;
    private Spinner wSpinner;
    private ProgressBar wProgresBar;
    private WeatherContract.WeatherPresenter wPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        wRecyclerView = findViewById(R.id.recyclerView);
        wSpinner = findViewById(R.id.spinner);
        wProgresBar = findViewById(R.id.progressBar);
        wProgresBar.setVisibility(View.INVISIBLE);
        wRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        wAdapter = new WeatherAdapter(this);
        wRecyclerView.setAdapter(wAdapter);
        wPresenter = new WeatherPresenter(this);

        wSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                wPresenter.onSelect(wSpinner.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void updateAdapter(List<WeatherObj> objs) {
        wAdapter.setAll(objs);
    }

    @Override
    public void showProgress() {
        wProgresBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        wProgresBar.setVisibility(View.INVISIBLE);
    }
}
