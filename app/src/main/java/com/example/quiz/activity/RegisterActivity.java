package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.quiz.R;
import com.example.quiz.activity.controller.APInterface;
import com.example.quiz.pojoClass.APIResponse;
import com.example.quiz.pojoClass.InterestDTO;
import com.example.quiz.pojoClass.RegisterDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {
    private EditText userName,password,emailAddress;
    private Button register;
    private CheckBox literature,lifestyle,coding,movies,booze,series,politics,food,cricket,cartoon;
    String profile="Public";
    String channel="quiz";
    String role="Player";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        emailAddress=findViewById(R.id.emailAddress);
        final List<InterestDTO> interestList=addListenerOnButtonClick();
        register=findViewById(R.id.btn_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myName=userName.getText().toString().trim();
                String myEmail =emailAddress.getText().toString().trim();
                String myPassword=password.getText().toString().trim();
                if(TextUtils.isEmpty(myName)){
                    userName.setError("Name is Required");
                    return;
                }
                if(TextUtils.isEmpty(myEmail)){
                    emailAddress.setError("Email is Required");
                    return;
                }
                if(TextUtils.isEmpty(myPassword)){
                    password.setError("Password is Required");
                    return;
                }

                if(myPassword.length()<6){
                    password.setError("Password Must be Greater than Six Characters");
                    return;
                }
                RegisterDTO registerDTO=setRegistrationDetails(userName.getText().toString(),password.getText().toString(),emailAddress.getText().toString(),interestList);
                LoginRetrofit.getRetrofit().create(APInterface.class).register(registerDTO).enqueue(new Callback<APIResponse>() {
                    @Override
                    public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                        APIResponse apiResponse=response.body();
                        if(apiResponse.getStatusCode()==1000){
                            Intent intent= new Intent(RegisterActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<APIResponse> call, Throwable t) {

                    }
                });
                Intent intent=new Intent(RegisterActivity.this,InstructionActivity.class);
                startActivity(intent);
            }
        });
    }
    public List<InterestDTO> addListenerOnButtonClick(){
        List<InterestDTO> interestDTOList=new ArrayList<>();
        int position=1;
        literature=(CheckBox)findViewById(R.id.checkbox_literature);
        lifestyle=(CheckBox)findViewById(R.id.checkbox_lifestyle);
        coding=(CheckBox)findViewById(R.id.checkbox_coding);
        movies=(CheckBox)findViewById(R.id.checkbox_movies);
        booze=(CheckBox)findViewById(R.id.checkbox_booze);
        cartoon=(CheckBox)findViewById(R.id.checkbox_cartoon);
        cricket=(CheckBox)findViewById(R.id.checkbox_cricket);
        series=(CheckBox)findViewById(R.id.checkbox_series);
        politics=(CheckBox)findViewById(R.id.checkbox_politics);
        food=(CheckBox)findViewById(R.id.checkbox_food);
        if(literature.isChecked())
        {
            InterestDTO dataModelLiterature=new InterestDTO(
                    "literature"
            );
            interestDTOList.add(dataModelLiterature);

        }
        if(lifestyle.isChecked()){
            InterestDTO dataModelLifestyle = new InterestDTO(
                    "lifestyle"

            );
            interestDTOList.add(dataModelLifestyle);
        }
        if(coding.isChecked()){
            InterestDTO dataModelCoding = new InterestDTO(
                    "Coding"

            );
            interestDTOList.add(dataModelCoding);
        }
        if(movies.isChecked()){
            InterestDTO dataModelMovies = new InterestDTO(
                    "Movies"

            );
            interestDTOList.add(dataModelMovies);
        }
        if(booze.isChecked()){
            InterestDTO dataModelBooze = new InterestDTO(
                    "Booze"

            );
            interestDTOList.add(dataModelBooze);
        }
        if(cartoon.isChecked()){
            InterestDTO dataModelCartoon = new InterestDTO(
                    "Cartoon"

            );
            interestDTOList.add(dataModelCartoon);
        }
        if(cricket.isChecked()){
            InterestDTO dataModelCricket = new InterestDTO(
                    "Cricket"

            );
            interestDTOList.add(dataModelCricket);
        }
        if(politics.isChecked()){
            InterestDTO dataModelPolitics = new InterestDTO(
                    "Politics"

            );
            interestDTOList.add(dataModelPolitics);
        }
        if(food.isChecked()){
            InterestDTO dataModelFood = new InterestDTO(
                    "Food"

            );
            interestDTOList.add(dataModelFood);
        }
        if(series.isChecked()){
            InterestDTO dataModelSeries = new InterestDTO(
                    "Web/TV Series"

            );
            interestDTOList.add(dataModelSeries);
        }
        return interestDTOList;

    }
    RegisterDTO setRegistrationDetails(String username,String password,String email,List<InterestDTO> interestDTOList){
        RegisterDTO registerDTO=new RegisterDTO();
        registerDTO.setChannel(channel);
        registerDTO.setEmailAddress(email);
        registerDTO.setInterest(interestDTOList);
        registerDTO.setName(username);
        registerDTO.setProfile(profile);
        registerDTO.setPassword(password);
        registerDTO.setRole(role);
        return registerDTO;
    }
}
