package com.example.mymate_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymate_test.data.member.Repository;
import com.example.mymate_test.data.member.model.DetailResponse;
import com.example.mymate_test.data.member.model.MyResponse;

public class MateInfoActivity extends AppCompatActivity {

    Button btn_send_msg, btn_apply;

    TextView txt_nickname,txt_type,txt_smoke,txt_noise,txt_wakeUp,txt_sleep,txt_shower,txt_clean;

    Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mate_info);

        btn_send_msg = (Button) findViewById(R.id.btn_send_msg);
        btn_apply = (Button) findViewById(R.id.btn_apply);
        txt_nickname=(TextView) findViewById(R.id.txt_nickname);
        txt_type=(TextView)findViewById(R.id.txt_type);
        txt_noise=(TextView)findViewById(R.id.txt_noise);
        txt_smoke=(TextView) findViewById(R.id.txt_smoke);
        txt_wakeUp=(TextView) findViewById(R.id.txt_wakeUp);
        txt_sleep=(TextView) findViewById(R.id.txt_sleep);
        txt_shower=(TextView) findViewById(R.id.txt_shower);
        txt_clean=(TextView) findViewById(R.id.txt_clean);

        btn_send_msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SendMessageActivity.class);
                startActivity(intent);
            }
        });

        btn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "MATE 신청을 요청했습니다.", Toast.LENGTH_LONG).show();
            }
        });

        repository = new Repository();
        Intent intent=getIntent();
        Long temp=intent.getLongExtra("memberId",0);
        repository.getMy(temp, new Repository.GetDataCallback<MyResponse>() {
            @Override
            public void onSuccess(MyResponse data) {
                Log.d("nickname",data.getNickname());
                txt_nickname.setText(data.getNickname());
                String type_s=data.getMateType1()+data.getMateType2();
                txt_type.setText(type_s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getApplicationContext(), "내 정보 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });

        repository.getDetail(temp, new Repository.GetDataCallback<DetailResponse>() {
            @Override
            public void onSuccess(DetailResponse data) {
                if(data.getNoise().equals(true)) {
                    txt_noise.setText("있다");
                }else{
                    txt_noise.setText("없다");
                }
                if(data.getSmoke().equals(true)){
                    txt_smoke.setText("한다");
                }else{
                    txt_smoke.setText("안 한다");
                }
                txt_wakeUp.setText(data.getWakeUp());
                txt_sleep.setText(data.getSleep());
                txt_shower.setText(data.getShower());
                txt_clean.setText(data.getClean());
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getApplicationContext(), "내 Detail 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });

    }
}