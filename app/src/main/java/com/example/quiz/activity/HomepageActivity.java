package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import com.example.quiz.R;

public class HomepageActivity extends AppCompatActivity {
    private Button staticButton,dynamicButton;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        initView();
        initStatic();
       initDynamic();
    }
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

    public void initStatic() {
        staticButton=findViewById(R.id.btn_static);
        staticButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this, StaticCategories.class);
                startActivity(intent);
            }
        });
    }
    public void initDynamic()
    {
        dynamicButton=findViewById(R.id.btn_dynamic);
        dynamicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomepageActivity.this,DynamicGameActivity.class);
               startActivity(intent);

            }
        });
}
}
