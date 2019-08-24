package com.example.jaguar.weather.common

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
class RetrofitConnectionModule {
    @Provides
    fun retrofitProvides():Connection {
        return Connection()
    }
}

class Connection {

    fun some(): Retrofit {
        val retrofit : Retrofit
        val httpClient = OkHttpClient.Builder()
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logger)
        retrofit = Retrofit.Builder()
                .baseUrl(ConstApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build()
        return retrofit
    }

}
