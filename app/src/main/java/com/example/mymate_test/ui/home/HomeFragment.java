package com.example.mymate_test.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymate_test.MateInfoActivity;
import com.example.mymate_test.MyApplication;
import com.example.mymate_test.R;
import com.example.mymate_test.data.member.MemberAdapter;
import com.example.mymate_test.data.member.Repository;
import com.example.mymate_test.data.member.model.GetRecommendMateListResponse;
import com.example.mymate_test.data.member.model.Member;
import com.example.mymate_test.data.member.model.MyResponse;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    Repository repository;
    RecyclerView recyclerView;
    MemberAdapter adapter;
    String str_mateType1;
    String str_mateType2;

    LinearLayout  char_layout3, char_layout4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);


        List<Member> list=new ArrayList<>();

        repository=new Repository();

        adapter=new MemberAdapter();
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler2);

        MyApplication myApp=(MyApplication)getActivity().getApplicationContext();

        repository.getMy(myApp.getState(), new Repository.GetDataCallback<MyResponse>() {
            @Override
            public void onSuccess(MyResponse data) {
               str_mateType1 = data.getMateType1();
                str_mateType2 =data.getMateType2();
                Log.d("mateType","type:"+str_mateType1);

                repository.getRecommendMateList(myApp.getState(),str_mateType1,new Repository.GetDataCallback<GetRecommendMateListResponse>(){
                    @Override
                    public void onSuccess(GetRecommendMateListResponse data){
                        for(int i=0;i<data.getCount();i++){
                            Member temp=data.getData().get(i);
                            adapter.addItem(new Member(temp.getId(),temp.getNickname(),temp.getMateType1(),temp.getMateType2()));
                        }
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Throwable throwable){
                        Toast.makeText(getActivity().getApplicationContext(),"추천 MATE 불러오기를 실패하였습니다",Toast.LENGTH_LONG).show();;
                        Log.d("추천 MATE","실패했습니다..\n"+throwable);
                    }
                });
            }

            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getActivity().getApplicationContext(), "내 정보 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });


        char_layout3 = v.findViewById(R.id.char_layout3);
        char_layout4 = v.findViewById(R.id.char_layout4);




        char_layout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MateInfoActivity.class);
                startActivity(intent);
            }
        });

        char_layout4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), MateInfoActivity.class);
                startActivity(intent);
            }

        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        return v;
    }

}