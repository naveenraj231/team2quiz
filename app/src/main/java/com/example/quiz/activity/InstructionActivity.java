package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.quiz.R;
import androidx.appcompat.widget.Toolbar;
public class InstructionActivity extends AppCompatActivity {
    private Button start;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);
        initView();
        start=findViewById(R.id.btn_start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InstructionActivity.this,HomepageActivity.class);
                startActivity(intent);
            }
        });
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
    }
}