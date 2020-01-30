package com.example.quiz.activity;

import android.app.Application;

import com.example.quiz.activity.controller.APInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



    public class App extends Application
    {
        static Retrofit retrofit;
        @Override
        public void onCreate() {
            super.onCreate();
        }
        public static Retrofit getRetrofit()
        {
            if(retrofit == null)
            {
                OkHttpClient client = new OkHttpClient.Builder().build();
                retrofit = new Retrofit.Builder()
                        .baseUrl(APInterface.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();
            }
            return retrofit;
        }
    }

