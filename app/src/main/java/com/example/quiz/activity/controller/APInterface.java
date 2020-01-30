package com.example.quiz.activity.controller;

import com.example.quiz.pojoClass.QuestionItem;
import com.example.quiz.pojoClass.Response;
import com.example.quiz.pojoClass.StaticQuizPojo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APInterface {

    String BASE_URL="http://10.177.68.85:8080";

@GET("staticQuestions/getQuestions/{category}")
    Call<Response<List<QuestionItem>>>  getStaticQuestion(@Path("category") String string);


}
