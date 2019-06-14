package com.example.learn.provider.rest;

import retrofit2.Retrofit;

public class RestProvider {

    private static Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();
    }

    public static Retrofit getRetrofit(){
        return provideRetrofit();
    }
}
