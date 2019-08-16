package com.example.viewpagerexam;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.viewpagerexam.Adapter.PersonAdapter;
import com.example.viewpagerexam.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 객체 선언
    ViewPager viewPager;
    PersonAdapter adapter;
    List<Person> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 초기화
        viewPager = findViewById(R.id.viewPager);
        list = new ArrayList<>();
        addData();
        adapter = new PersonAdapter(this, list);
        viewPager.setAdapter(adapter);


    }

    private void addData() {
        list.add(new Person("홍길동", "01012345678",R.drawable.job005));
        list.add(new Person("고길동", "01023456789",R.drawable.job006));
        list.add(new Person("이영희", "01034567890",R.drawable.job007));
    }
}
