package com.example.mymate_test.ui.my;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mymate_test.EditInfoActivity;
import com.example.mymate_test.MyApplication;
import com.example.mymate_test.R;
import com.example.mymate_test.data.member.Repository;
import com.example.mymate_test.data.member.model.DetailResponse;
import com.example.mymate_test.data.member.model.MyResponse;

public class MyFragment extends Fragment {
    TextView txt_nickname,txt_type,txt_noise,txt_smoke,txt_wakeUp,txt_sleep,txt_shower,txt_clean;
    Repository repository;
    Button btn_edit_info;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_my,container,false);

        txt_nickname=(TextView) v.findViewById(R.id.txt_nickname);
        txt_type=(TextView) v.findViewById(R.id.txt_type);
        txt_noise=(TextView) v.findViewById(R.id.txt_noise);
        txt_smoke=(TextView) v.findViewById(R.id.txt_smoke);
        txt_wakeUp=(TextView) v.findViewById(R.id.txt_wakeUp);
        txt_sleep=(TextView) v.findViewById(R.id.txt_sleep);
        txt_shower=(TextView) v.findViewById(R.id.txt_shower);
        txt_clean=(TextView) v.findViewById(R.id.txt_clean);


        repository = new Repository();
        MyApplication myApp = (MyApplication) getActivity().getApplicationContext();
        repository.getMy(myApp.getState(), new Repository.GetDataCallback<MyResponse>() {
            @Override
            public void onSuccess(MyResponse data) {
                txt_nickname.setText(data.getNickname());
                String type_s=data.getMateType1()+data.getMateType2();
                txt_type.setText(type_s);
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getActivity().getApplicationContext(), "내 정보 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });

        repository.getDetail(myApp.getState(), new Repository.GetDataCallback<DetailResponse>() {
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
                Toast.makeText(getActivity().getApplicationContext(), "내 Detail 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });

        btn_edit_info=v.findViewById(R.id.btn_edit_info);

        btn_edit_info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent=new Intent(getActivity().getApplicationContext(), EditInfoActivity.class);
                startActivity(intent);
            }
        });

        return v;


    }
}