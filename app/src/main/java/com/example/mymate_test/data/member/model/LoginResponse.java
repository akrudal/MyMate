package com.example.mymate_test.data.member.model;

import com.google.gson.annotations.SerializedName;

public class LoginResponse { // 로그인 응답을 위한 객체
    @SerializedName("id")
    public Long id;

    // Getter and Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
