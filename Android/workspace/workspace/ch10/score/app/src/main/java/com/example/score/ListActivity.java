package com.example.score;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.score.adapter.ScoreAdapter;
import com.example.score.model.Score;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    List<Score> list;
    ListView listView;
    ScoreAdapter adapter;
    AsyncHttpClient client;
    HttpResponse response;
    String URL = "http://192.168.0.61:8080/score/score/score_list.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list =new ArrayList<>();
        adapter = new ScoreAdapter(this,R.layout.list_item,list);
        listView = findViewById(R.id.listView);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);
        listView.setAdapter(adapter);
    }

   /* @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    */
    @Override
    protected void onResume() {
        super.onResume();
        adapter.clear();
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
            dialog=null;
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String strJson = new String(responseBody);
            try {
                JSONObject json = new JSONObject(strJson);
                Log.e("[ERROR]","Test1");
                String rt = json.getString("rt");
                int total = json.getInt("total");
                Log.e("[ERROR]","test2");
                JSONArray item = json.getJSONArray("item");
                for (int i=0; i<item.length(); i++){
                    Log.e("[ERROR]","test3");
                    JSONObject jsonObject = item.getJSONObject(i);
                    Score score = new Score();
                    score.setStudNo(jsonObject.getString("studNo"));
                    score.setName(jsonObject.getString("name"));
                    score.setKor(jsonObject.getInt("kor"));
                    score.setEng(jsonObject.getInt("eng"));
                    score.setMat(jsonObject.getInt("mat"));
                    score.setTot(jsonObject.getInt("tot"));
                    score.setAvg(jsonObject.getDouble("avg"));
                    score.setLogtime(jsonObject.getString("logtime"));
                    adapter.add(score);
                    Log.e("[ERROR]","test4");
                }
                Log.e("[ERROR]","test5");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity,"통신 실패",Toast.LENGTH_SHORT).show();
            Log.e("[ERROR]",statusCode+"");
        }
    }

    @Override
    public void onClick(View v) {

    }
}
