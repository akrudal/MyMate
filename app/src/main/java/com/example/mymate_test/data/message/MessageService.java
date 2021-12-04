package com.example.mymate_test.data.message;

import com.example.mymate_test.data.message.model.GetMessageListResponse;
import com.example.mymate_test.data.message.model.SendMessageRequest;
import com.example.mymate_test.data.message.model.SendMessageResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface MessageService {
    @POST("/message")
    Call<SendMessageResponse> createMessage(@Body SendMessageRequest sendMessageRequest);

    @GET("/message/byReceiver/{id}")
    Call<GetMessageListResponse> getMessageList(@Path("id") Long id);
}
