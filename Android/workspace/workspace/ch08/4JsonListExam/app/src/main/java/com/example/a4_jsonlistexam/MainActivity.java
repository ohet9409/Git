package com.example.a4_jsonlistexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a4_jsonlistexam.adapter.DeviceAdapter;
import com.example.a4_jsonlistexam.model.Device;
import com.example.a4_jsonlistexam.response.DeviceResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    //  객체 선언
    List<Device> list;
    DeviceAdapter adapter;
    ListView listView;
    DeviceResponse response;        // 응답 클래스
    AsyncHttpClient client;         // 요청 클래스
    //  URL
    String URL = "http://192.168.0.61:8080/server_data/list.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        list = new ArrayList<>();
        adapter = new DeviceAdapter(this, R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        response = new DeviceResponse(this, adapter);
        client = new AsyncHttpClient();

        // listView 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        listView.setOnItemClickListener(this);
        //  통신 요청
        client.get(URL, response);  //  서버에 데이터를 요청하면서, response를 쓰레드로서 구동시킴
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Device item = adapter.getItem(position);
        String name = item.getName();
        String type = item.getType();
        String result = name + " / " + type;
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
}
