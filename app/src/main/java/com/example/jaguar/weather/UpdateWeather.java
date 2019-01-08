package com.example.jaguar.weather;

import android.os.AsyncTask;

import com.example.jaguar.weather.resources.ConstApi;

import org.json.JSONObject;

public class UpdateWeather extends AsyncTask<Void, Void, JSONObject> {
    private String city;
    private String lang;
    private String days;
    private CallBack callback;

    UpdateWeather(String city, String lang, String days, CallBack callback) {
        this.city = city;
        this.lang = lang;
        this.days = days;
        this.callback = callback;
    }

    @Override
    protected JSONObject doInBackground(Void... voids) {
        final JSONObject json = RemoteFetch.getJSON(ConstApi.KEY, city, lang, days);
        return json;
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        ParseWeather parse = new ParseWeather();
        callback.UpdateWeather(parse.parseWeather(json));
    }
}