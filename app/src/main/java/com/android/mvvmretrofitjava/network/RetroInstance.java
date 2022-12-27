package com.android.mvvmretrofitjava.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String BASE_NEWS_URL = "https://static.mixerbox.com/interview/";

    private static Retrofit retrofit;

    public static Retrofit getRetroClient() {

        if(retrofit == null ) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_NEWS_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
