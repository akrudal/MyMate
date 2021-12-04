package com.example.mymate_test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mymate_test.data.member.Repository;
import com.example.mymate_test.data.member.model.DetailRequest;
import com.example.mymate_test.data.member.model.MyResponse;

public class EditInfoActivity extends AppCompatActivity {

    Button btn_start;
    TextView add_nickname;
    TextView add_info_name1;
    EditText edt_wake,edt_sleep;
    Repository repository; // 네트워크 요청을 위한 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        repository = new Repository();

        Spinner noiseSpinner = (Spinner) findViewById(R.id.spinner_noise);
        ArrayAdapter noiseAdapter = ArrayAdapter.createFromResource(this,
                R.array.noise, android.R.layout.simple_spinner_item);
        noiseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        noiseSpinner.setAdapter(noiseAdapter);

        Spinner smokeSpinner = (Spinner) findViewById(R.id.spinner_smoke);
        ArrayAdapter smokeAdapter = ArrayAdapter.createFromResource(this,
                R.array.smoke, android.R.layout.simple_spinner_item);
        smokeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        smokeSpinner.setAdapter(smokeAdapter);

        Spinner showerSpinner = (Spinner) findViewById(R.id.spinner_shower);
        ArrayAdapter showerAdapter = ArrayAdapter.createFromResource(this,
                R.array.shower, android.R.layout.simple_spinner_item);
        showerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        showerSpinner.setAdapter(showerAdapter);

        Spinner cleanSpinner = (Spinner) findViewById(R.id.spinner_clean);
        ArrayAdapter cleanAdapter = ArrayAdapter.createFromResource(this,
                R.array.clean, android.R.layout.simple_spinner_item);
        cleanAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cleanSpinner.setAdapter(cleanAdapter);

        add_nickname = findViewById(R.id.add_nickname);
        add_info_name1 = findViewById(R.id.add_info_name1);
        edt_wake=findViewById(R.id.edt_wake);
        edt_sleep=findViewById(R.id.edt_sleep);

        MyApplication myApp = (MyApplication) getApplicationContext();

        repository.getMy(myApp.getState(), new Repository.GetDataCallback<MyResponse>() {
            @Override
            public void onSuccess(MyResponse data) {
                add_nickname.setText(data.getNickname());
                String type_s=data.getMateType1()+data.getMateType2();
                add_info_name1.setText(type_s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getApplicationContext(), "내 정보 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean smoke_s;
                boolean noise_s;
                if(noiseSpinner.getSelectedItem().toString().equals("없다")){
                    noise_s=false;
                } else{
                    noise_s=true;
                }
                if(smokeSpinner.getSelectedItem().toString().equals("안 한다")){
                    smoke_s=false;
                } else{
                    smoke_s=true;
                }
                String wake_s=edt_wake.getText().toString();
                String sleep_s=edt_sleep.getText().toString();
                String shower_s=showerSpinner.getSelectedItem().toString();
                String clean_s=cleanSpinner.getSelectedItem().toString();


                DetailRequest detailRequest = new DetailRequest(myApp.getState(), noise_s,smoke_s,wake_s,sleep_s,shower_s,clean_s);
                repository.createDetail(detailRequest, new Repository.GetDataCallback<Void>() {
                    @Override
                    public void onSuccess(Void data) {
                        Toast.makeText(getApplicationContext(),"추가 정보 저장 성공!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Toast.makeText(getApplicationContext(),"로그인 실패", Toast.LENGTH_LONG).show();
                        Log.d("moment", "실패 했습니다..\n" + throwable);
                    }
                });

            }
        });


    }
}