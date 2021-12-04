package com.example.mymate_test.data.message.model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Member;

public class SendMessageRequest {
    @SerializedName("senderId")
    private Long senderId;

    @SerializedName("receiverId")
    private Long receiverId;

    @SerializedName("context")
    private String context;

    public SendMessageRequest(Long senderId,Long receiverId,String context){
        this.senderId=senderId;
        this.receiverId=receiverId;
        this.context=context;
    }

}
