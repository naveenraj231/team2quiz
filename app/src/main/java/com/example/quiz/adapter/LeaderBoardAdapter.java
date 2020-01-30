package com.example.quiz.adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.quiz.R;
import com.example.quiz.pojoClass.LeaderModel;

import java.util.List;

public class LeaderBoardAdapter extends RecyclerView.Adapter<LeaderBoardAdapter.ViewHolder>{
    Context context;
    List<LeaderModel> leaderModelList;
    public LeaderBoardAdapter(Context context, List<LeaderModel> leaderModelList) {
        this.context = context;
        this.leaderModelList = leaderModelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_leader_board, parent, false);
        LeaderBoardAdapter.ViewHolder viewHolder = new LeaderBoardAdapter.ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final int index = position;
        holder.userName.setText(leaderModelList.get(position).getUserName());
        holder.score.setText(String.valueOf(leaderModelList.get(position).getScore()));
    }
    @Override
    public int getItemCount() {
        return leaderModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView userName,score;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userName=itemView.findViewById(R.id.userName);
            score=itemView.findViewById(R.id.score);
        }
    }
}