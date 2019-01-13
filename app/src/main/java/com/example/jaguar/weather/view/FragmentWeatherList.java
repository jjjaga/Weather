package com.example.jaguar.weather.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.presenter.WeatherAdapter;

public class FragmentWeatherList extends Fragment {
    static WeatherAdapter wAdapter;
    private RecyclerView wRecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list_weather, container, false);
        wAdapter = new WeatherAdapter(getActivity());
        wRecyclerView = rootView.findViewById(R.id.recyclerView);
        wRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        wRecyclerView.setAdapter(wAdapter);

        return rootView;
    }
}
