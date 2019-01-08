package com.example.jaguar.weather;

import com.example.jaguar.weather.resources.ConstApi;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RemoteFetch {
    public synchronized static JSONObject getJSON(String key, String city, String lang, String days){
        try {
            URL url = new URL(String.format(ConstApi.OPEN_API, key, city, lang, days));
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!= null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            return data;
        }catch(Exception e){
            return null;
        }
    }
}
