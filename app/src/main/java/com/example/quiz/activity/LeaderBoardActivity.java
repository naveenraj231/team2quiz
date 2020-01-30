package com.example.quiz.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import com.example.quiz.R;
import com.example.quiz.adapter.LeaderBoardAdapter;
import com.example.quiz.pojoClass.LeaderModel;

import java.util.ArrayList;
import java.util.List;

public class LeaderBoardActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private Bundle savedInstanceState;
    private TextView userName,score;
    List<LeaderModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        userName=findViewById(R.id.userName);
        score=findViewById(R.id.userName);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            LeaderModel leaderModel=new LeaderModel(
                    "John",
                    74 +i
            );
            list.add(leaderModel);
            adapter=new LeaderBoardAdapter(this,list);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
        }
    }
}