package com.example.mymate_test.ui.note;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymate_test.data.message.MessageAdapter;
import com.example.mymate_test.MyApplication;
import com.example.mymate_test.R;
import com.example.mymate_test.data.message.Repository;
import com.example.mymate_test.data.message.model.GetMessageListResponse;
import com.example.mymate_test.data.message.model.Message;

import java.util.ArrayList;
import java.util.List;

public class NoteFragment extends Fragment {

    Repository repository;
    RecyclerView recyclerView;
    MessageAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_note,container,false);

        List<Message> list = new ArrayList<>();

        repository=new Repository();
        MyApplication myApp = (MyApplication) getActivity().getApplicationContext();

        adapter = new MessageAdapter() ;
        recyclerView=(RecyclerView)v.findViewById(R.id.recycler1);


        repository.getMessageList(myApp.getState(), new Repository.GetDataCallback<GetMessageListResponse>() {
            @Override
            public void onSuccess(GetMessageListResponse data) {
                for (int i = 0; i < data.getCount(); i++) {
                    Message temp = data.getData().get(i);
                    adapter.addItem(new Message(temp.getId(), temp.getNickname(), temp.getContext(), temp.getTime()));
                }
                recyclerView.setAdapter(adapter);
            }



            @Override
            public void onFailure(Throwable throwable) {
                Toast.makeText(getActivity().getApplicationContext(), "메세지 불러오기 실패", Toast.LENGTH_LONG).show();
                Log.d("moment", "실패 했습니다..\n" + throwable);
            }
        });


        // 리사이클러뷰에 LinearLayoutManager 객체 지정.

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        return v;
    }
}