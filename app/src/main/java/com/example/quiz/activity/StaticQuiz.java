package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz.R;
import com.example.quiz.pojoClass.StaticQuizPojo;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;

public class StaticQuiz extends AppCompatActivity {
    private List<StaticQuizPojo> questionlist=new ArrayList();
    private Button submit;
    private Retrofit retrofit;
    CheckBox option1,option2,option3;
    TextView timer;
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_quiz);
   //     initRetrofitAndCallApi();
        countDownTimer=new CountDownTimer(900000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               long minutes=millisUntilFinished/60000;
               long seconds=(millisUntilFinished/1000 -minutes*60);
                timer.setText(minutes+" minutes"+":"+seconds +" seconds left");
            }

            @Override
            public void onFinish() {
                  Toast.makeText(StaticQuiz.this,"Time is Finished",Toast.LENGTH_LONG).show();
            }
        };
        countDownTimer.start();
        Toast.makeText(StaticQuiz.this,"Timer has started",Toast.LENGTH_LONG).show();
        addListenerOnSubmit();
    }
    public void addListenerOnSubmit(){
        timer=findViewById(R.id.timer);
        option1=findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);


        submit=findViewById(R.id.btn_submit_answer);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
//    public void initRetrofitAndCallApi() {
//        retrofit = App.getApp().getRetrofit();
//        APIInterface api = retrofit.create(APIInterface.class);
//        progressBar = findViewById(R.id.progress_bar);
//        progressBar.setVisibility(View.VISIBLE);
//        call = api.getProducts();
        //SharedPreferences sharedPreferences = getSharedPreferences("com.example.myapplication.activity", MODE_PRIVATE);
        //callCartCount=api.getCartCount()
    }

//    @Override
//    protected void onStop() {
//        super.onStop();
//        countDownTimer.onFinish();
//    }


