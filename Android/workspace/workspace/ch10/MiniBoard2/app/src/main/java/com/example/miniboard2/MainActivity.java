package com.example.miniboard2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.miniboard2.adapter.CommunityAdapter;
import com.example.miniboard2.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    // 객체 선언
    Button button;
    ListView listView;
    List<Community> list;
    CommunityAdapter adapter;

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
        adapter = new CommunityAdapter(this,R.layout.list_item,list);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);
        //  list 초기화
        listView.setAdapter(adapter);
        //  이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);

    }

    // Activity 화면이 뜨기 직전에 자동 호출
    // 갱신 기능
    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();    // List 데이터 비우기
        client.post(URL,response);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this,WriteActivity.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this,ReadActivity.class);
        Community item = adapter.getItem(position);
        //intent.putExtra("item",item);
        intent.putExtra("seq",item.getSeq());
        startActivity(intent);
    }

    class HttpResponse extends AsyncHttpResponseHandler{
        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity) {
            this.activity = activity;
        }

        //  통신 시작
        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요.");
            dialog.setCancelable(false);
            dialog.show();
        }

        //  통신 종료
        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog = null;
        }

        //  통신 성공
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String strJson = new String(responseBody);
            try {
                JSONObject json = new JSONObject(strJson);
                String rt = json.getString("rt");
                int total = json.getInt("total");
                JSONArray item = json.getJSONArray("item");
                for (int i=0; i<item.length();i++){
                    JSONObject temp = item.getJSONObject(i);
                    Community community = new Community();
                    community.setSeq(temp.getInt("seq"));
                    community.setUser_name(temp.getString("user_name"));
                    community.setUser_pwd(temp.getString("user_pwd"));
                    community.setSubject(temp.getString("subject"));
                    community.setContent(temp.getString("content"));
                    community.setEmail(temp.getString("email"));
                    community.setReg_date(temp.getString("reg_date"));
                    community.setEdit_date(temp.getString("edit_date"));
                    adapter.add(community);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        //  통신 실패
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this, "통신실패", Toast.LENGTH_SHORT).show();
            Log.e("[ERROR]",statusCode+"");
        }
    }
}
