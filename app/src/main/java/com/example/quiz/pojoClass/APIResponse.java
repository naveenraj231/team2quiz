package com.example.quiz.pojoClass;

public class APIResponse {
    int statusCode;
    String message;
    RegisterDTO data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RegisterDTO getData() {
        return data;
    }

    public void setData(RegisterDTO data) {
        this.data = data;
    }
}
