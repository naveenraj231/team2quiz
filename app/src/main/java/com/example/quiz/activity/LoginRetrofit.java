package com.example.quiz.activity;

import android.app.Application;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRetrofit extends Application{

    static Retrofit retrofit;
    static Retrofit getRetrofit(){
        if(retrofit==null){
            OkHttpClient client = new OkHttpClient.Builder().build();
            retrofit=new Retrofit.Builder().baseUrl("http://172.16.20.121:8080").addConverterFactory(GsonConverterFactory.create()).client(client).build();
        }
        return retrofit;
    }
}
