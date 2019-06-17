package com.example.learn.provider.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestProvider {

    private static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create()) // For JSON serialization
                .build();
    }

    public static Retrofit getRetrofit() {
        return provideRetrofit();
    }
}
