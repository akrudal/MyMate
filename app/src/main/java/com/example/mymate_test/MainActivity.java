package com.example.mymate_test;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mymate_test.ui.home.HomeFragment;
import com.example.mymate_test.ui.list.ListFragment;
import com.example.mymate_test.ui.my.MyFragment;
import com.example.mymate_test.ui.note.NoteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_main, new HomeFragment()).commit();

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    //item을 클릭시 id값을 가져와 FrameLayout에 fragment.xml띄우기
                    case R.id.navigation_home: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, new HomeFragment()).commit();
                        break;
                    case R.id.navigation_list: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, new ListFragment()).commit();
                        break;
                    case R.id.navigation_note: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, new NoteFragment()).commit();
                        break;
                    case R.id.navigation_my: getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, new MyFragment()).commit();
                        break;
                }
                return true; } });
    }
}