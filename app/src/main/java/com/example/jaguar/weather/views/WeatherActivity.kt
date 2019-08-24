package com.example.jaguar.weather.views

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.AdapterView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.jaguar.weather.R
import com.example.jaguar.weather.adapters.WeatherAdapter
import com.example.jaguar.weather.common.WeatherObj
import com.example.jaguar.weather.presenter.WeatherPresenter
import com.example.jaguar.weather.interfaces.WeatherView
import kotlinx.android.synthetic.main.activity_weather.*
import javax.inject.Inject


class WeatherActivity : MvpAppCompatActivity(), WeatherView {

    private lateinit var wAdapter: WeatherAdapter


    @InjectPresenter
    lateinit var mWeatherPresenter: WeatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        progressBar.visibility = View.INVISIBLE
        recyclerView.layoutManager = LinearLayoutManager(this)
        wAdapter = WeatherAdapter()
        recyclerView.adapter = wAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                mWeatherPresenter.onSelect(spinner.selectedItem.toString())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }
    override fun updateAdapter(objs: MutableList<WeatherObj>) {
        wAdapter.setAll(objs)
    }
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }
    override fun hideProgress() {
        progressBar.visibility = View.INVISIBLE
    }
}