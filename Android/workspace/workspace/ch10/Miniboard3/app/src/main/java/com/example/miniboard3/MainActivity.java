package com.example.miniboard3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniboard3.adapter.CommunityAdapter;
import com.example.miniboard3.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //  객체 선언
    ListView listView;
    List<Community> list;
    CommunityAdapter adapter;
    Button button;
    //  통신 객체 선언
    AsyncHttpClient client;
    HttpResponse response;
    // URL
    String URL = "http://192.168.0.61:8080/miniboard/community/community_list.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        list = new ArrayList<>();
        adapter = new CommunityAdapter(this, R.layout.list_item,list);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);
        // listView 설정
        listView.setAdapter(adapter);
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        client.post(URL,response);
    }

    // 통신 응답 클래스
    class HttpResponse extends AsyncHttpResponseHandler{

        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요.");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog = null;
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String strJson = new String(responseBody);
            try {
                JSONObject json = new JSONObject(strJson);
                String rt = json.getString("rt");
                JSONArray item = json.getJSONArray("item");
                for (int i=0; i<item.length(); i++){
                    JSONObject temp = item.getJSONObject(i);
                    Community community = new Community();
                    community.setSubject(temp.getString("subject"));
                    community.setEdit_date(temp.getString("edit_date"));
                    community.setSeq(temp.getInt("seq"));
                    community.setUser_name(temp.getString("user_name"));
                    community.setFilename(temp.getString("filename"));
                    // List에 저장
                    adapter.add(community);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity,"통신 실패",Toast.LENGTH_SHORT).show();
            Log.e("[info]",""+statusCode);
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,WriteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,ReadActivity.class);

        startActivity(intent);
    }
}
