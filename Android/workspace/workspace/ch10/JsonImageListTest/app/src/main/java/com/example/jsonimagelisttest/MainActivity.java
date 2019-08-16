package com.example.jsonimagelisttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.example.jsonimagelisttest.model.Job;
import com.example.jsonimagelisttest.response.JobResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // 객체 선언
    ListView listView;
    List<Job> list;
    JobAdapter adapter;
    AsyncHttpClient client;
    JobResponse response;
    String URL = "http://192.168.0.61:8080/server_data/job.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        adapter = new JobAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new JobResponse(this,adapter);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        client.get(URL, response);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (adapter.getCount() >0){
        adapter.clear();
        // 통신 요청
        client.get(URL,response);}
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Job item = adapter.getItem(position);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }
}
