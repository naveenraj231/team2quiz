package com.example.quiz.pojoClass;
public class LeaderModel {
    String userName;
    int score;
    public LeaderModel(String userName, int score) {
        this.userName = userName;
        this.score = score;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}