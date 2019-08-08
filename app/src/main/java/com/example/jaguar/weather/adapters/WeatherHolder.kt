package com.example.jaguar.weather.adapters

import android.app.Dialog
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.jaguar.weather.R
import com.example.jaguar.weather.common.WeatherObj
import kotlinx.android.synthetic.main.activity_weather_full.*
import kotlinx.android.synthetic.main.list_item_weather.view.*

class WeatherHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var weatherTextView: TextView
    private var weatherCondition: TextView
    private var imageWeather: ImageView
    private var dateR: TextView

    init {
        weatherTextView = this.itemView.hello
        imageWeather = this.itemView.imgV
        weatherCondition = this.itemView.condition
        dateR = this.itemView.date

        var dialog = Dialog(this.itemView.context)
        dialog.setContentView(R.layout.activity_weather_full)

        val text:TextView = dialog.text
        itemView?.setOnClickListener {
            text.setText(weatherTextView.text)
            dialog.show()
        }
    }

    fun bindCrime(wObj: WeatherObj) {
        weatherTextView.text = wObj.text
        Glide.with(itemView.getContext()).load(wObj.imgUrl1).override(100).into(imageWeather)
        weatherCondition.text = wObj.weatherCondition
        dateR.text = wObj.date
    }

}