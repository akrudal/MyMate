package com.example.mymate_test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MyPage1Actiivty extends AppCompatActivity {

    Button btn_send_msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page1_actiivty);

        btn_send_msg = findViewById(R.id.btn_send_msg);
        Intent intent = new Intent(getApplicationContext(), MyPage2Activity.class);
        startActivity(intent);
    }

}