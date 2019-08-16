package com.example.miniboard;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;

import com.example.miniboard.adapter.CommunityAdapter;
import com.example.miniboard.model.Community;
import com.example.miniboard.response.CommunityResponse;
import com.loopj.android.http.AsyncHttpClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    Button button;
    List<Community> list;
    CommunityAdapter adapter;
    ListView listView;
    CommunityResponse response;
    AsyncHttpClient client;
    String URL="http://192.168.0.61:8080/miniboard/community/community_list.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        adapter = new CommunityAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        response=new CommunityResponse(this,adapter);
        client = new AsyncHttpClient();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        client.get(URL,response);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,WriteActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Community item = adapter.getItem(position);
        Intent intent = new Intent(this,ReadActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
        finish();
    }
}
