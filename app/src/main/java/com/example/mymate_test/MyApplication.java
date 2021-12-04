package com.example.mymate_test;

import android.app.Application;

public class MyApplication extends Application {

    private Long state;

    @Override
    public void onCreate() {
        //전역 변수 초기화
        state = Long.valueOf(0);
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void setState(Long state){
        this.state = state;
    }

    public Long getState(){
        return state;
    }
}