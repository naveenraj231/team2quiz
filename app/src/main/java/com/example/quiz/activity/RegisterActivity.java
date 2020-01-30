package com.example.quiz.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.quiz.R;
import com.example.quiz.pojoClass.Interest;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private EditText userName, password, emailAddress;
    private Toolbar toolbar;
    private Button register;
    private CheckBox literature, lifestyle, coding, movies, booze, series, politics, food, cricket, cartoon;
    List<Interest> interestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        emailAddress = findViewById(R.id.emailAddress);
        register = findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName = userName.getText().toString().trim();
                String myEmail = emailAddress.getText().toString().trim();
                String myPassword = password.getText().toString().trim();
                if (TextUtils.isEmpty(myName)) {
                    userName.setError("Name is Required");
                    return;
                }
                if (TextUtils.isEmpty(myEmail)) {
                    emailAddress.setError("Email is Required");
                    return;
                }
                if (TextUtils.isEmpty(myPassword)) {
                    password.setError("Password is Required");
                    return;
                }
                if (myPassword.length() < 6) {
                    password.setError("Password Must be Greater than Six Characters");
                    return;
                }
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addListenerOnButtonClick() {
        literature = (CheckBox) findViewById(R.id.checkbox_list1);
        lifestyle = (CheckBox) findViewById(R.id.checkbox_list2);
        coding = (CheckBox) findViewById(R.id.checkbox_list3);
        movies = (CheckBox) findViewById(R.id.checkbox_list4);
        booze = (CheckBox) findViewById(R.id.checkbox_list5);
        cartoon = (CheckBox) findViewById(R.id.checkbox_list6);
        cricket = (CheckBox) findViewById(R.id.checkbox_list7);
        series = (CheckBox) findViewById(R.id.checkbox_list8);
        politics = (CheckBox) findViewById(R.id.checkbox_list9);
        food = (CheckBox) findViewById(R.id.checkbox_list10);
        int position = 1;
        if (literature.isChecked()) {
            // interestList.add(position,"literature");
            position++;
        }
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


}