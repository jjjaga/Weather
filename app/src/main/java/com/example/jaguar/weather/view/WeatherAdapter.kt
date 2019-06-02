package com.example.jaguar.weather.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jaguar.weather.R
import com.example.jaguar.weather.model.WeatherObj
import java.util.ArrayList

class WeatherAdapter : RecyclerView.Adapter<WeatherHolder>() {
    private val wList = ArrayList<WeatherObj>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherHolder {
        val li = LayoutInflater.from(parent.context)
        val view = li.inflate(R.layout.list_item_weather, parent, false)
        return WeatherHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        val weatherObj = wList[position]
        holder.bindCrime(weatherObj)
    }

    override fun getItemCount(): Int {
        return wList.size
    }

    fun setAll(objs: List<WeatherObj>) {
        wList.clear()
        wList.addAll(objs)
        notifyDataSetChanged()
    }
}