package com.example.mymate_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.mymate_test.R;

public class Test1Activity extends AppCompatActivity{

    String nickname;

    Button btn_test1;

    int question = 0;   //결과 출력할 배열 값
    int score, score1, score2, score3;
    RadioGroup question_page1_123;     //질문 1, 2, 3
    RadioGroup question_num1, question_num2, question_num3;    //응답 1, 2, 3


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);

        //질문 1, 2, 3
        question_page1_123 = (RadioGroup) findViewById(R.id.question_page1_123);

        //응답 1, 2, 3
        question_num1 = (RadioGroup) findViewById(R.id.question_num1);
        question_num2 = (RadioGroup) findViewById(R.id.question_num2);
        question_num3 = (RadioGroup) findViewById(R.id.question_num3);

        question_page1_123.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.q1:
                        question = 0;
                        break;
                    case R.id.q2:
                        question = 1;
                        break;
                    case R.id.q3:
                        question = 2;
                        break;
                }
            }
        });

        question_num1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.a11:
                        score1 = 5;
                        break;
                    case R.id.a12:
                        score1 = -5;
                        break;
                }
            }
        });

        question_num2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.a21:
                        score2 = -1;
                        break;
                    case R.id.a22:
                        score2 = 1;
                        break;
                }
            }
        });

        question_num3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.a31:
                        score3 = 3;
                        break;
                    case R.id.a32:
                        score3 = -3;
                        break;
                }
            }
        });

        btn_test1 = findViewById(R.id.btn_test1);
        btn_test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                score = score1 + score2 + score3;

                Intent intent = new Intent(getApplicationContext(), Test2Activity.class);
                intent.putExtra("question_page1", question);
                intent.putExtra("score_page1", score);
                intent.putExtra("nickname", nickname);
                intent.putExtra("score1", score1);
                intent.putExtra("score2", score2);
                intent.putExtra("score3", score3);
                startActivity(intent);
            }
        });
    }
}