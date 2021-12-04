package com.example.mymate_test.data.member.model;

public class MyResponse {
    private String nickname;

    private String mateType1;

    private String mateType2;

    private double rate;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getMateType1() {
        return mateType1;
    }

    public void setMateType1(String mateType1){
        this.mateType1=mateType1;
    }

    public String getMateType2(){return mateType2;}

    public void setMateType2(String mateType2){this.mateType2=mateType2;}

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }


}
