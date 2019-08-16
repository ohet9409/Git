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
    List<Grade> list;
    GradeAdapter adapter;
    ListView listView;
    GradeResponse response;
    AsyncHttpClient client;
    String URL ="http://192.168.0.61:8080/server_data/grade.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        adapter = new GradeAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        response = new GradeResponse(this,adapter);
        client = new AsyncHttpClient();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        client.get(URL,response);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Grade item = adapter.getItem(position);
        String name = item.getName();
        int kor = item.getKor();
        int eng = item.getEng();
        int math = item.getMath();
        int tot = kor + eng + math;
        double avg = tot/3.0;
        String result = "이름 : "+name + "\n국어 : " + kor + "\n영어 : " + eng + "\n수학 : " + math
                +"\n총점 : "+tot+"\n평균 : " + String.format("%4.1f",avg);
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
}
