package com.example.mymate_test.data.message;

import com.example.mymate_test.data.message.model.GetMessageListResponse;
import com.example.mymate_test.data.message.model.Message;
import com.example.mymate_test.data.message.model.SendMessageRequest;
import com.example.mymate_test.data.message.model.SendMessageResponse;

public class Repository {
    private RemoteDataSource remoteDataSource=new RemoteDataSource();

    public void createMessage(SendMessageRequest sendMessageRequest, GetDataCallback<SendMessageResponse> callback){
        remoteDataSource.createMessage(sendMessageRequest,callback);
    }

    public void getMessageList(Long id, GetDataCallback<GetMessageListResponse> callback){
        remoteDataSource.getMessageList(id,callback);
    }

    /** 응답 콜백 */
    public interface GetDataCallback<T> {
        void onSuccess(T data);
        void onFailure(Throwable throwable);
    }
}
