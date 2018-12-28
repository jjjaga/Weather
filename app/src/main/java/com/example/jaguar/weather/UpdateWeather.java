package com.example.jaguar.weather;

import android.os.AsyncTask;

import com.example.jaguar.weather.Resources.ConstApi;

import org.json.JSONObject;

public class UpdateWeather extends AsyncTask<Void, Void, JSONObject> {
    public String city;
    public String lang;
    public String days;

    public UpdateWeather(String city, String lang, String days) {
        this.city = city;
        this.lang = lang;
        this.days = days;
    }

    @Override
    protected JSONObject doInBackground(Void... voids) {
        final JSONObject json = RemoteFetch.getJSON(ConstApi.KEY, city, lang, days);
        return json;
    }

    @Override
    protected void onPostExecute(JSONObject json) {
        ParseWeather parse = new ParseWeather();
        parse.parseWeather(json);
    }
}