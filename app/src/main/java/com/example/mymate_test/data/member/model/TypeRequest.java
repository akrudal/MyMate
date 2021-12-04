package com.example.mymate_test.data.member.model;

import com.google.gson.annotations.SerializedName;

public class TypeRequest {

    @SerializedName("id")
    public Long id;

    @SerializedName("mateType1")
    public String mateType1;

    @SerializedName("mateType2")
    public String mateType2;

    public TypeRequest(Long id,String mateType1,String mateType2){
        this.id=id;
        this.mateType1=mateType1;
        this.mateType2=mateType2;
    }

    public Long getId(){
        return id;
    }

    public Long SetId(){
        return id;
    }

    public String getMateType1(){
        return mateType1;
    }

    public void setMateType1(String mateType1){
        this.mateType1=mateType1;
    }

    public String getMateType2() {return mateType2;}
    public void setMateType2(String mateType2) {
        this.mateType2=mateType2;
    }
}