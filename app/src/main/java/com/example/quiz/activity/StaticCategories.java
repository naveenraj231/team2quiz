package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.widget.Toolbar;
import com.example.quiz.R;

public class StaticCategories extends AppCompatActivity {
    private Button litrearture,lifestyle,coding,movies,booze,cartoon,cricket,webseries,politics,food;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_categories);
        initView();
        initStartQuiz();
    }

    public void initStartQuiz(){

    }
    public void initView(){
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.btn_login);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(R.drawable.ic_back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        litrearture=findViewById(R.id.litreature);
        litrearture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });


        lifestyle=findViewById(R.id.lifestyle);
        lifestyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });

        coding=findViewById(R.id.coding);
        coding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });


        movies=findViewById(R.id.movies);
        movies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });


        booze=findViewById(R.id.booze);
        booze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });


        cartoon=findViewById(R.id.cartoon);
        cartoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });


        cricket=findViewById(R.id.cricket);
        cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });


        webseries=findViewById(R.id.web_series);
        webseries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StaticCategories.this,StaticQuiz.class);
                startActivity(intent);
            }
        });

    }
}
