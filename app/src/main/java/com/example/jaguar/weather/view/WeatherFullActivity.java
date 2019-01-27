package com.example.jaguar.weather.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.WeatherContract;
import com.example.jaguar.weather.model.WeatherObj;
import java.util.List;

public class WeatherFullActivity extends AppCompatActivity implements WeatherContract.WeatherView {
    TextView text;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_full);
        text=findViewById(R.id.text);
        text.setText(getIntent().getExtras().getString("textFor"));
    }

    @Override
    public void updateAdapter(List<WeatherObj> objs) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
