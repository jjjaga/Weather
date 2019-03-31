package com.example.jaguar.weather.model.network;

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
    private String str;
    private List<WeatherObj> listWe = new ArrayList<>();
  public RetrofitConnection(String str){
      this.str = str;
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

  public void getWeatherFullTime(CallBack callBack){
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<UserModelResponse> weather = weatherService.getWeather(
                ConstApi.ACCSESS_TOKEN, str, "ru", "7");

        weather.enqueue(new Callback<UserModelResponse>() {
            @Override
            public void onResponse(Call<UserModelResponse> call, Response<UserModelResponse> response) {
                if(response.code() == 200) {
                    System.out.println(response.body().location.getName());
                    listWe.add(new WeatherObj("Город: " + response.body().location.getName()));
                    listWe.add(new WeatherObj("Город: " + response.body().location.getRegion()));
                    listWe.add(new WeatherObj("Город: " + response.body().location.getRegion()));
                    System.out.println(response.body().current.condition.getIcon());
//                    Picasso.get()
//                            .load("http:" + response.body().current.condition.getIcon())
//                            .into(imageView);
                    System.out.println(listWe.get(1).getText());
                }else if(response.code() == 404){
                    System.out.println(" 404!!!!!!!!!!!");
                }else{
                    System.out.println(" что-то пошло не так");
                }
            }

            @Override
            public void onFailure(Call<UserModelResponse> call, Throwable t) {

            }
        });
        callBack.UpdateWeather(listWe);
    }
}

