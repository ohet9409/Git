package com.example.gradelistexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gradelistexam.adapter.GradeAdapter;
import com.example.gradelistexam.model.Grade;
import com.example.gradelistexam.response.GradeResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 객체 선언
    List<Grade> list;
    GradeAdapter adapter;
    ListView listView;
    AsyncHttpClient client;
    GradeResponse response;
    // URL
    String URL = "http://192.168.0.53:8080/server_data/grade.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        list = new ArrayList<>();
        adapter = new GradeAdapter(this, R.layout.list_item, list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new GradeResponse(this, adapter);
        // listView 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        listView.setOnItemClickListener(this);
        // 통신 요청
        client.get(URL, response);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Grade item = adapter.getItem(position);
        int tot = item.getKor() + item.getEng() + item.getMath();
        double avg = (double)tot / 3;
        String result = "이름 : " + item.getName() + "\n"
                      + "국어 : " + item.getKor() + "\n"
                      + "영어 : " + item.getEng() + "\n"
                      + "수학 : " + item.getMath() + "\n"
                      + "총점 : " + tot + "\n"
                      + "평균 : " + String.format("%4.1f", avg);
        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }
}
