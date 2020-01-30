package com.example.quiz.activity;

import android.app.Activity;
import android.content.Intent;

import org.greenrobot.eventbus.EventBus;

public class IntentServiceResult {
    int mResult;
    String mResultValue;

    IntentServiceResult(int resultCode, String resultValue) {
        mResult = resultCode;
        mResultValue = resultValue;
    }

    public int getResult() {
        return mResult;
    }

    public String getResultValue() {
        return mResultValue;
    }
    protected void onHandleIntent(Intent intent) {

        // do some work
        EventBus.getDefault().post(new IntentServiceResult(Activity.RESULT_OK, "done!!"));
    }
}
