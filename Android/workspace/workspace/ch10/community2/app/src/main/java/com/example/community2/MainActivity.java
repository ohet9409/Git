package com.example.community2;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.community2.adapter.CommunityAdapter;
import com.example.community2.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    // 객체 선언
    Button button;
    ListView listView;
    List<Community> list;
    CommunityAdapter adapter;
    HttpResponse response;
    AsyncHttpClient client;

    String URL ="http://192.168.0.61:8080/miniboard/community/community_list.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        list = new ArrayList<>();
        adapter = new CommunityAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);

        button.setOnClickListener(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        //  퍼미션 체크
        permissionCheck();
    }
    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();    // List 데이터 비우기

        client.post(URL,response);
    }

    class HttpResponse extends AsyncHttpResponseHandler{
        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요");
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
                int total = json.getInt("total");
                JSONArray item = json.getJSONArray("item");
                for (int i=0; i<item.length(); i++){
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
                    community.setFilename(temp.getString("filename"));
                    adapter.add(community);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity,"통신 실패", Toast.LENGTH_SHORT).show();
            Log.e("[errror] ",statusCode+"");
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
        Community item = adapter.getItem(position);
        //intent.putExtra("item",item);
        intent.putExtra("seq",item.getSeq());
        intent.putExtra("item",item);
        startActivity(intent);
    }
}
