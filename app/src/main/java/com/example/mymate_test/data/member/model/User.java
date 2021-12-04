package com.example.mymate_test.data.member.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId") // JSON 객체와 해당 변수를 매칭
    private String userId;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("password")
    private String password;

    // Constructor
    public User( String nickname,String userId, String password) {
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
    }

    // Getter and Setter
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getNickName() {
        return nickname;
    }

    public void setNickName(String nick) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
