package com.example.jaguar.weather.model.network;

import android.support.annotation.NonNull;

import com.example.jaguar.weather.model.CallBack;
import com.example.jaguar.weather.model.ConstApi;
import com.example.jaguar.weather.model.WeatherObj;
import com.example.jaguar.weather.view.WeatherAdapter;

import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConnection {
    private Retrofit retrofit;
    private List<WeatherObj> listWe = new ArrayList<>();
  public RetrofitConnection(){
      OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
      HttpLoggingInterceptor logger = new HttpLoggingInterceptor();
      logger.setLevel(HttpLoggingInterceptor.Level.BODY);
      httpClient.addInterceptor(logger);
      //------------------------------------------------------------
      retrofit = new Retrofit.Builder()
              .baseUrl(ConstApi.BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .client(httpClient.build())
              .build();
  }

  public void getWeatherFullTime(String str, CallBack callBack){
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<UserModelResponse> weather = weatherService.getWeather(
                ConstApi.ACCSESS_TOKEN, str, "ru", "7");

        weather.enqueue(new Callback<UserModelResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserModelResponse> call, @NonNull Response<UserModelResponse> response) {
                int code = response.code();
                switch (code){
                    case 200:
                    System.out.println(response.body().location.getName());
                    listWe.clear();
                    listWe.add(new WeatherObj("Город: " + response.body().location.getName()));
                    listWe.add(new WeatherObj("Город: " + response.body().location.getRegion()));
                    listWe.add(new WeatherObj("Город: " + response.body().location.getRegion()));
                    System.out.println(response.body().current.condition.getIcon());
                    break;
                    case 400:
                    System.out.println(" 404!!!!!!!!!!!");
                    break;
                    default:
                    System.out.println(" что-то пошло не так");
                    break;
                }
            }

            @Override
            public void onFailure(@NonNull Call<UserModelResponse> call, @NonNull Throwable t) {
                System.out.println(t);
            }
        });
        callBack.UpdateWeather(listWe);
    }
}

