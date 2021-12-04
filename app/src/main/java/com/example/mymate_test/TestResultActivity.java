package com.example.mymate_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymate_test.data.member.Repository;
import com.example.mymate_test.data.member.model.TypeRequest;
import com.example.mymate_test.data.member.model.TypeResponse;

public class TestResultActivity extends AppCompatActivity {

    String nickname;

    Button btn_add_info;
    int name1, name2;
    int score1,score2, score3, score4, score5, score6;
    TextView name_1, name_2;
    ImageView character_view;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);

        name_1 = (TextView)findViewById(R.id.name1);
        name_2 = (TextView)findViewById(R.id.name2);

        character_view = (ImageView)findViewById(R.id.character_view);

        Intent intent = getIntent();
        name1 = intent.getIntExtra("question", 0);
        name2 = intent.getIntExtra("score", 0 );
        score1 = intent.getIntExtra("score1", 0 );
        score2 = intent.getIntExtra("score2", 0 );
        score3 = intent.getIntExtra("score3", 0 );
        score4 = intent.getIntExtra("score4", 0 );
        score5 = intent.getIntExtra("score5", 0 );
        score6 = intent.getIntExtra("score6", 0 );
        createName1();
        createName2();

        repository=new Repository();
        String type=name_1.getText().toString()+name_2.getText().toString();


        MyApplication myApp = (MyApplication)getApplicationContext();


        btn_add_info = (Button)findViewById(R.id.btn_add_info);
        btn_add_info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                TypeRequest typeRequest = new TypeRequest(myApp.getState(),name_1.getText().toString(),name_2.getText().toString());
                repository.createType(typeRequest, new Repository.GetDataCallback<TypeResponse>() {
                    @Override
                    public void onSuccess(TypeResponse data) {
                        Toast.makeText(getApplicationContext(),"type 저장 성공!", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"저장 실패", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });
                Intent intent = new Intent(getApplicationContext(), AddInfoActivity.class);
                intent.putExtra("name1", name1);
                intent.putExtra("name2", name2);
                intent.putExtra("nickname", nickname);

                startActivity(intent);
            }
        });
    }

    private void createName1(){
        if((name1 == 0) && (score1 == 5))
            name_1.setText("귀가 큰");
        else if((name1 == 0) && (score1 == -5))
            name_1.setText("귀가 작은");
        else if((name1 == 1) && (score2 == -1))
            name_1.setText("집 안이 좋은");
        else if((name1 == 1) && (score2 == 1))
            name_1.setText("집 밖이 좋은");
        else if((name1 == 2) && (score3 == 3))
            name_1.setText("비밀스러운");
        else if((name1 == 2) && (score3 == -3))
            name_1.setText("비밀이 없는");
        else if((name1 == 3) && (score4 == 3))
            name_1.setText("프로게이머");
        else if((name1 == 3) && (score4 == -3))
            name_1.setText("PC방 게임이 좋은");
        else if((name1 == 4) && (score5 == -5))
            name_1.setText("인싸");
        else if((name1 == 4) && (score5 == 5))
            name_1.setText("당신과 거리 두는");
        else if((name1 == 5) && (score6 == -1))
            name_1.setText("초대왕");
        else if((name1 == 5) && (score6 == 1))
            name_1.setText("다른 친구 초대는 안 되는");

    }

    private void createName2(){
        if(name2 >= 10 && name2 <= 18){
            name_2.setText("테크");
            character_view.setImageResource(R.drawable.character4);
        }
        else if(name2 >= 0 && name2 <= 9) {
            name_2.setText("소무니");
            character_view.setImageResource(R.drawable.character3);
        }
        else if(name2 >= -8 && name2 <= 0) {
            name_2.setText("자니");
            character_view.setImageResource(R.drawable.character2);
        }
        else if(name2 >= -18 && name2 <=-9) {
            name_2.setText("밥");
            character_view.setImageResource(R.drawable.character1);
        }
    }
}