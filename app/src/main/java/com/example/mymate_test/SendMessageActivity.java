package com.example.mymate_test;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymate_test.data.message.Repository;
import com.example.mymate_test.data.message.model.SendMessageRequest;
import com.example.mymate_test.data.message.model.SendMessageResponse;

public class SendMessageActivity extends AppCompatActivity {

    Repository repository;
    EditText edt_content;
    Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);

        repository = new Repository();
        MyApplication myApp = (MyApplication) getApplicationContext();

        edt_content=(EditText)findViewById(R.id.edt_content);
        btn_send=(Button)findViewById(R.id.btn_send);


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMessageRequest sendMessageRequest=new SendMessageRequest(myApp.getState(),(long)2,edt_content.getText().toString());
                repository.createMessage(sendMessageRequest, new Repository.GetDataCallback<SendMessageResponse>() {
                    @Override
                    public void onSuccess(SendMessageResponse data) {
                        Toast.makeText(getApplicationContext(),"메세지 전송을 완료했습니다.", Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(getApplicationContext(),MateInfoActivity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"메세지 전송에 실패했습니다.", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });

            }
        });

    }
}