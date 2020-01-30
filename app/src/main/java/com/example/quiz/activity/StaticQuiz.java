package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.quiz.R;
import com.example.quiz.activity.controller.APInterface;
import com.example.quiz.pojoClass.Response;
import com.example.quiz.pojoClass.QuestionItem;
import com.example.quiz.pojoClass.StaticQuizPojo;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class StaticQuiz extends AppCompatActivity {
    private List<QuestionItem> responseForStatic = new ArrayList();
    private QuestionItem questionItem = new QuestionItem();
    private Call<Response<List<QuestionItem>>> call;
    private Button submit, skip;
    private Retrofit retrofit;
    private ProgressBar progressBar;
    private String category;
    private CheckBox option1, option2, option3;
    private TextView timer, question;
    private CountDownTimer countDownTimer;
    private ImageView imageView;
    private VideoView videoView;
    private int i = 1;
    private Boolean skipValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_quiz);
        question = findViewById(R.id.textQuestionForStatic);
        imageView = findViewById(R.id.imageForStatic);
        videoView = findViewById(R.id.videoForStatic);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);


        // Intent i = getIntent();
        // category = i.getStringExtra("category");
        category = "test";

        initRetrofitAndCallApi();
        apiCallBack();
        countDownTimer = new CountDownTimer(900000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished / 1000 - minutes * 60);
                timer.setText(minutes + " minutes" + ":" + seconds + " seconds left");
            }

            @Override
            public void onFinish() {
                Toast.makeText(StaticQuiz.this, "Time is Finished", Toast.LENGTH_LONG).show();
            }
        };
        countDownTimer.start();
        Toast.makeText(StaticQuiz.this, "Timer has started", Toast.LENGTH_LONG).show();
        addListenerOnSubmit();
        addListenerOnSkip();
    }

    public void addListenerOnSubmit() {
        timer = findViewById(R.id.timer);


        submit = findViewById(R.id.btn_submit_answer);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i < 3) {
                    if (responseForStatic.get(i).getQuestionType() == "text") {
                        imageView.setVisibility(View.INVISIBLE);
                        videoView.setVisibility(View.INVISIBLE);
                    } else if (responseForStatic.get(i).getQuestionType() == "image") {
                        videoView.setVisibility(View.INVISIBLE);


                    } else if (responseForStatic.get(i).getQuestionType() == "video") {
                        imageView.setVisibility(View.INVISIBLE);
                    }
                    question.setText(responseForStatic.get(i).getQuestion());
                    option1.setText(responseForStatic.get(i).getAnswer().get(0));
                    option2.setText(responseForStatic.get(i).getAnswer().get(1));
                    option3.setText(responseForStatic.get(i).getAnswer().get(2));
                    if (option1.isChecked())
                        option1.toggle();
                    if (option2.isChecked())
                        option2.toggle();
                    if (option3.isChecked())
                        option3.toggle();

                    i++;

                }


            }
        });
    }

    public void initRetrofitAndCallApi() {
        retrofit = App.getRetrofit();
        APInterface api = retrofit.create(APInterface.class);
//       progressBar = findViewById(R.id.progress_bar);
//       progressBar.setVisibility(View.VISIBLE);
        //  category="test";
        call = api.getStaticQuestion(category);

    }

    public void apiCallBack() {
        call.enqueue(new Callback<Response<List<QuestionItem>>>() {


            @Override
            public void onResponse(Call<Response<List<QuestionItem>>> call, retrofit2.Response<Response<List<QuestionItem>>> response) {
                if (response.isSuccessful()) {
//                     assert response.body() != null;
                    responseForStatic = response.body().getData();
                    // list.addAll(responseForStatic.addAll(responseForStatic));
                    if (responseForStatic.get(0).getQuestionType().equals("text")) {
                        imageView.setVisibility(View.INVISIBLE);
                        videoView.setVisibility(View.INVISIBLE);
                    } else if (responseForStatic.get(0).getQuestionType().equals("image")) {
                        videoView.setVisibility(View.INVISIBLE);

                    } else if (responseForStatic.get(0).getQuestionType().equals("video")) {
                        imageView.setVisibility(View.INVISIBLE);
                    }
                    question.setText(responseForStatic.get(0).getQuestion());
                    option1.setText(responseForStatic.get(0).getAnswer().get(0));
                    option2.setText(responseForStatic.get(0).getAnswer().get(1));
                    option3.setText(responseForStatic.get(0).getAnswer().get(2));
                    if (option1.isChecked())
                        option1.toggle();
                    if (option2.isChecked())
                        option2.toggle();
                    if (option3.isChecked())
                        option3.toggle();
                }
            }

            @Override
            public void onFailure(Call<Response<List<QuestionItem>>> call, Throwable t) {

                Log.i("naveen", t.getMessage());
            }
        });


    }

    public void addListenerOnSkip() {
        skip = findViewById(R.id.btn_skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                questionItem = responseForStatic.get(i);
                responseForStatic.add(questionItem);


                if (i < 3) {
                    if (responseForStatic.get(i).getQuestionType() == "text") {
                        imageView.setVisibility(View.INVISIBLE);
                        videoView.setVisibility(View.INVISIBLE);
                    } else if (responseForStatic.get(i).getQuestionType() == "image") {
                        videoView.setVisibility(View.INVISIBLE);


                    } else if (responseForStatic.get(i).getQuestionType() == "video") {
                        imageView.setVisibility(View.INVISIBLE);
                    }
                    question.setText(responseForStatic.get(i).getQuestion());
                    option1.setText(responseForStatic.get(i).getAnswer().get(0));
                    option2.setText(responseForStatic.get(i).getAnswer().get(1));
                    option3.setText(responseForStatic.get(i).getAnswer().get(2));
                    if (option1.isChecked())
                        option1.toggle();
                    if (option2.isChecked())
                        option2.toggle();
                    if (option3.isChecked())
                        option3.toggle();

                    i++;

                }

                //  responseForStatic.ad
                skipValue = true;
                i++;
            }
        });

    }


}


