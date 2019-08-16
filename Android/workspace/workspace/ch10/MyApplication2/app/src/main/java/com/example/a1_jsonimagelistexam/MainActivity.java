package com.example.a1_jsonimagelistexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a1_jsonimagelistexam.adapter.ColumnAdapter;
import com.example.a1_jsonimagelistexam.model.Column;
import com.example.a1_jsonimagelistexam.response.ColumnResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //  객체 선언
    ListView listView;
    List<Column> list;
    ColumnAdapter adapter;
    AsyncHttpClient client;
    ColumnResponse response;
    // URL
    String URL = "http://192.168.0.61:8080/server_data/column.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        list = new ArrayList<>();
        adapter = new ColumnAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new ColumnResponse(this, adapter);
        //  listView 설정
        listView.setAdapter(adapter);
        //  이벤트 설정
        listView.setOnItemClickListener(this);
        //  통신 요청
        client.get(URL, response);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Column item = adapter.getItem(position);
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
