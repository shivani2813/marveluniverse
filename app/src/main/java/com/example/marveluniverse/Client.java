package com.example.marveluniverse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client{
        Retrofit retrofit;

public ApiClient getAPIclient() {
        HttpLoggingInterceptor logged=new HttpLoggingInterceptor();
        logged.level(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
        .addInterceptor(logged)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS);

        if (retrofit == null) {
        retrofit = new Retrofit.Builder().
        baseUrl("https://gateway.marvel.com:443").
        addConverterFactory(GsonConverterFactory.create()).
        client(builder.build()).
        build();
        }

        return retrofit.create(ApiClient.class);

        }

}
