package com.example.mymate_test.data.member.model;

import com.google.gson.annotations.SerializedName;

public class LoginRequest { // 로그인 요청을 위한 객체

    @SerializedName("userId")
    public String userId;

    @SerializedName("password")
    public String password;

    // Constructor
    public LoginRequest(String userId, String password) {
        this.userId=userId;
        this.password = password;
    }

    // Getter and Setter

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
