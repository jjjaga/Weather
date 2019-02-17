package com.example.jaguar.weather.model;

import android.os.AsyncTask;
import org.json.JSONObject;

public class UpdateWeather extends AsyncTask<Void, Void, JSONObject> {
    private final String city;
    private final String lang;
    private final String days;
    private final CallBack callback;

    public UpdateWeather(String city, String lang, String days, CallBack callback) {
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
    protected void onPreExecute() {
        super.onPreExecute();
    }
    @Override
    protected void onPostExecute(JSONObject json) {
        ParseWeather parse = new ParseWeather();
        callback.UpdateWeather(parse.parseWeather(json));
    }
}