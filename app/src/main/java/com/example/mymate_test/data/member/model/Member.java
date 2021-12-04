package com.example.mymate_test.data.member.model;

import java.util.ArrayList;

public class Member {

    private Long id;

    private String nickname;

    private String mateType1;

    private String mateType2;


    public Member(Long id,String nickname, String mateType1, String mateType2) {
        this.id=id;
        this.nickname = nickname;
        this.mateType1 = mateType1;
        this.mateType2 = mateType2;
    }

    public Member() {
    }

    public Long getId(){
        return id;
    }


    public String getNickname(){ return nickname;}

    public String getMateType1() {return mateType1;}

    public String getMateType2() {return mateType2;}
}
