package com.example.jaguar.weather.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.UpdateWeather;
import com.example.jaguar.weather.model.WeatherObj;
import java.util.List;
import static com.example.jaguar.weather.view.FragmentWeatherList.wAdapter;

public class FragmentWeatherSelect extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weather_select, container, false);
        final Spinner sp = rootView.findViewById(R.id.spinner);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                new UpdateWeather(sp.getSelectedItem().toString(),"ru","7", new CallBack() {
                    @Override
                    public void UpdateWeather(List<WeatherObj> objs) {
                        updateWeatherList(objs);
                    }
                }).execute();
            }
            private void updateWeatherList(List<WeatherObj> objs) {
                wAdapter.setAll(objs);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        return rootView;
    }
}
