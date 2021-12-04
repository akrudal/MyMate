package com.example.mymate_test.data.message;

import com.example.mymate_test.data.member.model.MyResponse;
import com.example.mymate_test.data.message.model.GetMessageListResponse;
import com.example.mymate_test.data.message.model.Message;
import com.example.mymate_test.data.message.model.SendMessageRequest;
import com.example.mymate_test.data.message.model.SendMessageResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {
    private Retrofit retrofit=new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


    private MessageService service=retrofit.create(MessageService.class);

    public void createMessage(SendMessageRequest sendMessageRequest,Repository.GetDataCallback<SendMessageResponse> callback){
        service.createMessage(sendMessageRequest).enqueue(new Callback<SendMessageResponse>(){
            @Override
            public void onResponse(Call<SendMessageResponse> call, Response<SendMessageResponse> response){
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }
            @Override
            public void onFailure(Call<SendMessageResponse> call,Throwable t){
                callback.onFailure(t);
            }
        });
    }

    public void getMessageList(Long id, Repository.GetDataCallback<GetMessageListResponse> callback){
        service.getMessageList(id).enqueue(new Callback<GetMessageListResponse>() {
            @Override
            public void onResponse(Call<GetMessageListResponse> call, Response<GetMessageListResponse> response) {
                if(response.isSuccessful()){
                    callback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<GetMessageListResponse> call, Throwable t) {
                callback.onFailure(t);
            }
        });
    }
}
