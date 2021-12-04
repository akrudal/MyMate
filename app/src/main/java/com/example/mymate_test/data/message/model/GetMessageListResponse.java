package com.example.mymate_test.data.message.model;

import java.util.List;

public class GetMessageListResponse {
    private int count;

    private List<Message> data;

    public int getCount(){return count;}

    public List<Message> getData(){
        return data;
    }
}
