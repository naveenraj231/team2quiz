package com.example.quiz.adapter;

import android.content.Context;

import com.example.quiz.pojoClass.Interest;

import java.util.List;

public class DynamicGameAdapter {
    Context context;
    List<Interest> list;
    public DynamicGameAdapter(Context context, List<Interest> list) {
        this.context = context;
        this.list = list;
    }
}