package com.example.mymate_test.data.member.model;

import com.google.gson.annotations.SerializedName;

public class DetailRequest {
    @SerializedName("id")
    private Long id;
    @SerializedName("noise")
    private boolean noise;
    @SerializedName("smoke")
    private boolean smoke;
    @SerializedName("wakeUp")
    private String wakeUp;
    @SerializedName("sleep")
    private String sleep;
    @SerializedName("shower")
    private String shower;
    @SerializedName("clean")
    private String clean;

    public DetailRequest(Long id,boolean noise,boolean smoke,String wakeUp,String sleep,String shower,String clean) {
        this.id=id;
        this.noise=noise;
        this.smoke=smoke;
        this.wakeUp=wakeUp;
        this.sleep=sleep;
        this.shower=shower;
        this.clean=clean;
    }

    public Long getId() {
        return id;
    }

    public Boolean getNoise() {
        return noise;
    }

    public void setNoise(Boolean noise) {
        this.noise=noise;
    }

    public Boolean getSmoke() {
        return smoke;
    }

    public void setSmoke(Boolean smoke) {
        this.smoke = smoke;
    }

    public String getWakeUp() {
        return wakeUp;
    }

    public void setWakeUp(String wakeUp) {
        this.wakeUp = wakeUp;
    }

    public String getSleep() {
        return sleep;
    }

    public void setSleep(String sleep) {
        this.sleep = sleep;
    }

    public String getShower() {
        return shower;
    }

    public void setShower(String shower) {
        this.shower = shower;
    }

    public String getClean(){
        return clean;
    }

    public void setClean(String clean){
        this.clean=clean;
    }
}

