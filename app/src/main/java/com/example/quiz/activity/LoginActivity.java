package com.example.quiz.activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import com.example.quiz.R;
import com.example.quiz.activity.controller.APInterface;
import com.example.quiz.pojoClass.LoginDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private Button login,register;
    private Toolbar toolbar;
    EditText username=findViewById(R.id.email);
    EditText password=findViewById(R.id.password);
    String profile="Public";
    String channel="quiz";
    String role="Player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initLogin();
        initRegister();
        runtimeEnableAutoInit();

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
                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w("Firebase", "getInstanceId failed", task.getException());
                                    return;
                                }
                                String token = task.getResult().getToken();
                                String msg = getString(R.string.instance_id, token);
                                LoginDTO loginDTO=setLoginDetails(username.getText().toString(),password.getText().toString(),token);
                                LoginRetrofit.getRetrofit().create(APInterface.class).login(loginDTO).enqueue(new Callback<String>() {
                                    @Override
                                    public void onResponse(Call<String> call, Response<String> response) {
                                        if(response!=null){
                                            String accessToken=response.body();
                                            SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                                            SharedPreferences.Editor editor=sharedPreferences.edit();
                                            editor.putBoolean("loginStatus",true);
                                            editor.putString("accessToken",accessToken);
                                            editor.apply();
                                            Intent intent=new Intent(LoginActivity.this,HomepageActivity.class);
                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<String> call, Throwable t) {

                                    }
                                });
                                Log.d("Firebase", msg);
                                Toast.makeText(LoginActivity.this, msg, Toast.LENGTH_SHORT).show();
                            }
                        });
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
    public void runtimeEnableAutoInit() {
        //fcm_runtime_enable_auto_init
        FirebaseMessaging.getInstance().setAutoInitEnabled(true);

    }

    LoginDTO setLoginDetails(String username,String password,String token)
    {
        LoginDTO loginDTO=new LoginDTO();
        loginDTO.setChannel(channel);
        loginDTO.setRole(role);
        loginDTO.setProfile(profile);
        loginDTO.setEmailAddress(username);
        loginDTO.setPassword(password);
        loginDTO.setFcmToken(token);
        return loginDTO;
    }
}
