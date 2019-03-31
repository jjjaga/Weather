package com.example.jaguar.weather.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.jaguar.weather.R;
import com.example.jaguar.weather.model.WeatherObj;
import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder>{
    private static final List<WeatherObj> wList = new ArrayList<>();

    @Override
    public WeatherHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view = li.inflate(R.layout.list_item_weather, parent, false);
        return new WeatherHolder(view);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        WeatherObj weatherObj = wList.get(position);
        holder.bindCrime(weatherObj);
    }

    @Override
    public int getItemCount() {
        return wList.size();
    }

    public void setAll(List<WeatherObj> objs) {
        wList.clear();
        wList.addAll(objs);
        notifyDataSetChanged();
    }
}