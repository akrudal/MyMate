package com.example.mymate_test.ui.list;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mymate_test.MateInfoActivity;
import com.example.mymate_test.R;
import com.example.mymate_test.RatingBar;

public class ListFragment extends Fragment {

    Button rating_mate1, rating_mate2, rating_mate3, rating_mate4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list, container, false);

        rating_mate1 = v.findViewById(R.id.rating_mate1);
        rating_mate2 = v.findViewById(R.id.rating_mate2);
        rating_mate3 = v.findViewById(R.id.rating_mate3);

        rating_mate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), RatingBar.class);
                startActivity(intent);
            }
        });

        rating_mate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), RatingBar.class);
                startActivity(intent);
            }
        });

        rating_mate3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(), RatingBar.class);
                startActivity(intent);
            }
        });


        return v;

    }

}