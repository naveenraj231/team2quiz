package com.example.quiz.activity;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static Retrofit retrofit;
    private static App app;
    public static String BASE_URL = "http:10.177.68.77:8089/";
    public Retrofit getRetrofit() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        OkHttpClient client = new OkHttpClient.Builder().build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client).build();

        return retrofit;
    }

    public static App getApp() {
        return app;
    }

    public static void setApp(App app) {
        App.app = app;
    }
}
