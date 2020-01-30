package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.quiz.R;
import com.example.quiz.common.Common;
import com.example.quiz.pojoClass.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DynamicGameActivity extends AppCompatActivity {
    int index = 0, score = 0, thisQuestion = 0, totalQuestion, correctAnswer;
    private ImageView imageQuestion, audioQuestion;
    private VideoView videoQuestion;
    private TextView difficulty, textQuestion;
    private ImageButton play, pause;
    private CheckBox ans1, ans2, ans3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_game);
        imageQuestion = findViewById(R.id.img_question);
        audioQuestion = findViewById(R.id.audio_question);
        videoQuestion = findViewById(R.id.vdo_question);
        difficulty = findViewById(R.id.difficulty);
        textQuestion = findViewById(R.id.text_question);
        play = findViewById(R.id.btn_play);
        pause = findViewById(R.id.btn_pause);
        ans1 = findViewById(R.id.checkbox_ans1);
        ans2 = findViewById(R.id.checkbox_ans2);
        ans3 = findViewById(R.id.checkbox_ans3);
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void doThis(MessageEvent messageEvent) {
        Toast.makeText(this,messageEvent.getMessage(), Toast.LENGTH_SHORT).show();
//        Intent intent=new Intent(DynamicGameActivity.this,DynamicGameActivity.class);
//        startActivity(intent);
    }
    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }


}
