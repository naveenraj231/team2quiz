package com.example.quiz.pojoClass;

import java.util.List;
public class QuestionModel {
    String question;
    List<String> answers;
    String answerType;
    String questionType;
    String binaryFilePath;
    String difficulty;
    String quizId;
    public QuestionModel(String question, List<String> answers, String answerType, String questionType, String binaryFilePath, String difficulty, String quizId) {
        this.question = question;
        this.answers = answers;
        this.answerType = answerType;
        this.questionType = questionType;
        this.binaryFilePath = binaryFilePath;
        this.difficulty = difficulty;
        this.quizId = quizId;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public List<String> getAnswers() {
        return answers;
    }
    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
    public String getAnswerType() {
        return answerType;
    }
    public void setAnswerType(String answerType) {
        this.answerType = answerType;
    }
    public String getQuestionType() {
        return questionType;
    }
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }
    public String getBinaryFilePath() {
        return binaryFilePath;
    }
    public void setBinaryFilePath(String binaryFilePath) {
        this.binaryFilePath = binaryFilePath;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
    public String getQuizId() {
        return quizId;
    }
    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }
}