package com.example.jaguar.weather.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.AdapterView
import android.widget.ProgressBar
import android.widget.Spinner
import com.example.jaguar.weather.R
import com.example.jaguar.weather.model.WeatherContract
import com.example.jaguar.weather.model.WeatherObj
import com.example.jaguar.weather.presenter.WeatherPresenter

class WeatherActivity : WeatherContract.WeatherView, AppCompatActivity(){

    private lateinit var wAdapter: WeatherAdapter
    private lateinit var wRecyclerView: RecyclerView
    private lateinit var wSpinner: Spinner
    private lateinit var wProgressBar: ProgressBar
    private lateinit var wPresenter: WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)
        wRecyclerView = findViewById(R.id.recyclerView)
        wSpinner = findViewById(R.id.spinner)
        wProgressBar = findViewById(R.id.progressBar)
        wProgressBar.visibility = View.INVISIBLE
        wPresenter = WeatherPresenter(this)
        wRecyclerView.layoutManager = LinearLayoutManager(this)
        wAdapter = WeatherAdapter()
        wRecyclerView.adapter = wAdapter

        wSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                wPresenter.onSelect(wSpinner.selectedItem.toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
    override fun updateAdapter(objs: MutableList<WeatherObj>) {
        wAdapter.setAll(objs)
    }
    override fun showProgress() {
        wProgressBar.visibility = View.VISIBLE
    }
    override fun hideProgress() {
        wProgressBar.visibility = View.INVISIBLE
    }
}