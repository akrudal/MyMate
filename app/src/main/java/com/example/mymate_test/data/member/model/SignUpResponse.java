package com.example.mymate_test.data.member.model;

import com.google.gson.annotations.SerializedName;

public class SignUpResponse {
    @SerializedName("id")
    public Long id;

    public Long getId(){return id;}

    public void setId(Long id){this.id=id;}
}
