//Test2Activity
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

public class Test2Activity extends AppCompatActivity{

    String nickname;

    Button btn_test2;

    int question, question_page1, question_page2;
    int score, score_page1, score4, score5, score6;
    int score1, score2, score3;
    RadioGroup question_page2_456;    //질문 4, 5, 6
    RadioGroup question_num4, question_num5, question_num6;    //응답 4, 5, 6


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);

        //질문 4, 5, 6
        question_page2_456 = (RadioGroup) findViewById(R.id.question_page2_456);

        //응답 4, 5, 6
        question_num4 = (RadioGroup) findViewById(R.id.question_num4);
        question_num5 = (RadioGroup) findViewById(R.id.question_num5);
        question_num6 = (RadioGroup) findViewById(R.id.question_num6);

        question_page2_456.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.q4:
                        question_page2 = 3;
                        break;
                    case R.id.q5:
                        question_page2 = 4;
                        break;
                    case R.id.q6:
                        question_page2 = 5;
                        break;
                }
            }
        });

        question_num4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.a41:
                        score1 = 3;
                        break;
                    case R.id.a42:
                        score1 = -3;
                        break;
                }
            }
        });

        question_num5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.a51:
                        score2 = -5;
                        break;
                    case R.id.a52:
                        score2 = 5;
                        break;
                }
            }
        });

        question_num6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.a61:
                        score3 = -1;
                        break;
                    case R.id.a62:
                        score3 = 1;
                        break;
                }
            }
        });

        Intent intent1 = getIntent();

        question_page1= intent1.getIntExtra("question_page1", 0);
        score_page1 = intent1.getIntExtra("score_page1", 0 );
        score1 = intent1.getIntExtra("score1", 0 );
        score2 = intent1.getIntExtra("score2", 0 );
        score3 = intent1.getIntExtra("score3", 0 );

        btn_test2 = findViewById(R.id.btn_test2);
        btn_test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question = question_page1 + question_page2;
                score = score_page1 + score4 + score5 + score6;

                Intent intent = new Intent(getApplicationContext(), TestResultActivity.class);
                intent.putExtra("question", question);
                intent.putExtra("score", score);
                intent.putExtra("nickname", nickname);
                intent.putExtra("score1", score1);
                intent.putExtra("score2", score2);
                intent.putExtra("score3", score3);
                intent.putExtra("score4", score4);
                intent.putExtra("score5", score5);
                intent.putExtra("score6", score6);
                startActivity(intent);
                finish();
            }
        });
    }
}
