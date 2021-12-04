package com.example.mymate_test;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mymate_test.data.member.Repository;
import com.example.mymate_test.data.member.model.LoginRequest;
import com.example.mymate_test.data.member.model.LoginResponse;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText edit_id, edit_password;

    //서버에 저장된 아이디, 비밀번호
    Button btn_login;
    String id_right = "";
    String password_right = "";

    //사용자가 입력하는 아이디, 비밀번호
    String inputID = "";
    String inputPassword = "";

    Button btn_signup;
    Repository repository; // 네트워크 요청을 위한 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edit_id = findViewById(R.id.edit_id);
        edit_password = findViewById(R.id.edit_password);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_signup = (Button)findViewById(R.id.btn_signup);

        btn_login.setClickable(false);

        repository=new Repository();

        edit_id.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("아이디 확인", charSequence + "," + i2);
                //널 값 방지
                if(charSequence != null){
                    inputID = charSequence.toString();}

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        edit_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("비밀번호 확인", charSequence + "," + i2);
                //널 값 방지
                if(charSequence != null){
                    inputPassword = charSequence.toString();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId = edit_id.getText().toString();
                String password= edit_password.getText().toString();

                LoginRequest loginRequest = new LoginRequest(userId,password);
                repository.login(loginRequest, new Repository.GetDataCallback<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse data) {
                        Toast.makeText(getApplicationContext(),"로그인 성공!", Toast.LENGTH_LONG).show();


                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        MyApplication myApp = (MyApplication)getApplicationContext();
                        Log.d("오류",data.getId().toString());
                        myApp.setState(data.getId());
                        startActivity(intent);
                        finish();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"로그인 실패", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });




            }
        });


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
                startActivity(intent);
            }
        });

    }

}