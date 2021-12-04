package com.example.mymate_test.data.message.model;

import java.time.LocalDateTime;

public class Message {
    private Long id;

    private String nickname;

    private String context;

    private String time;

    public Message(Long id,String nickname,String context,String time){
        this.id=id;
        this.nickname=nickname;
        this.context=context;
        this.time=time;
    }

    public Long getId(){return id;}

    public String getNickname(){return nickname;}

    public void setNickname(String nickname){
        this.nickname=nickname;
    }

    public String getContext(){return context;}

    public void setContext(String context){
        this.context=context;
    }

    public String getTime(){return time;}
}
