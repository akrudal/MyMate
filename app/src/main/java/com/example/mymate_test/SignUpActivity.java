package com.example.mymate_test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymate_test.data.member.model.SignUpResponse;
import com.example.mymate_test.data.member.model.User;
import com.example.mymate_test.data.member.Repository;

public class SignUpActivity extends AppCompatActivity {
    private SharedPreferences preferences; // 유저 정보를 위한 SharedPreferences
    Repository repository; // 네트워크 요청을 위한 객체

    EditText edit_nickname;
    EditText edit_userId;
    EditText edit_password;
    Button btn_sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        preferences=getSharedPreferences("UserInfo",MODE_PRIVATE);
        repository=new Repository();

        btn_sign_up = (Button)findViewById(R.id.btn_sign_up);
        edit_nickname=(EditText)findViewById(R.id.edit_nickname);
        edit_userId=(EditText)findViewById(R.id.edit_userId);
        edit_password=(EditText)findViewById(R.id.edit_password);

        btn_sign_up.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                User user = new User(edit_nickname.getText().toString(),edit_userId.getText().toString(), edit_password.getText().toString());
                repository.createUser(user, new Repository.GetDataCallback<SignUpResponse>() {
                    @Override
                    public void onSuccess(SignUpResponse data) {
                        Toast.makeText(getApplicationContext(),"회원가입 완료!", Toast.LENGTH_LONG).show();
                        MyApplication myApp = (MyApplication)getApplicationContext();
                        myApp.setState(data.getId());

                        Intent intent = new Intent(getApplicationContext(), Test1Activity.class);
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"회원가입 실패", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });
            }
        });


    }
}
