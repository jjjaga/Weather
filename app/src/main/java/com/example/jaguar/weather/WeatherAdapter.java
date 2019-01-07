package com.example.jaguar.weather;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder>{
    List<WeatherObjFactory.WeatherObj> wList;

    public WeatherAdapter(List<WeatherObjFactory.WeatherObj> weatherList) {
        wList = weatherList;
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(WeatherActivity.context);
        View view = li.inflate(R.layout.list_item_weather, parent, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        WeatherObjFactory.WeatherObj weatherObj = wList.get(position);
        holder.bindCrime(weatherObj);
    }

    @Override
    public int getItemCount() {
        return wList.size();
    }
}
