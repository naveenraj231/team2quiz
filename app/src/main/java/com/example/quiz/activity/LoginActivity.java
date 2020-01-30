package com.example.quiz.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import com.example.quiz.R;

public class LoginActivity extends AppCompatActivity {
    private Button login,register;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initLogin();
        initRegister();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void initView() {
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

    public void initLogin() {
        login = findViewById(R.id.btn_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, InstructionActivity.class);
                startActivity(intent);
            }
        });
    }
    public void initRegister(){
        register=findViewById(R.id.btn_signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
