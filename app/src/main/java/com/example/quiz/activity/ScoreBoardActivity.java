package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.quiz.R;
public class ScoreBoardActivity extends AppCompatActivity {
    private TextView yourScore,noOfCorrectAnswers,noOfWrongAnswers,noOfQuestionsAttempted;
    private Button viewLeaderBoard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        yourScore=findViewById(R.id.score);
        noOfCorrectAnswers=findViewById(R.id.noOfCorrectAnswers);
        noOfQuestionsAttempted=findViewById(R.id.noOfQuestionsAttempted);
        noOfWrongAnswers=findViewById(R.id.noOfWrongAnswers);
        viewLeaderBoard=findViewById(R.id.btn_viewLeaderBoard);
        viewLeaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ScoreBoardActivity.this, LeaderBoardActivity.class);
                startActivity(intent);
            }
        });
    }
}
