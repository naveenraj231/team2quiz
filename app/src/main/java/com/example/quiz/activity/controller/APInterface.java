package com.example.quiz.activity.controller;

import com.example.quiz.pojoClass.APIResponse;
import com.example.quiz.pojoClass.LoginDTO;
import com.example.quiz.pojoClass.RegisterDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APInterface {

    @POST("controller/login")
    Call<String> login(@Body LoginDTO loginDTO);

    @POST("controller/register")
    Call<APIResponse> register(@Body RegisterDTO registerDTO);
}
