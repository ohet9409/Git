package com.example.a3_simplejsonexam;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    Button button;
    TextView textView;
    AsyncHttpClient client;
    HttpResponse response;
    String URL ="http://192.168.0.61:8080/server_data/simple.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        client = new AsyncHttpClient();
        response = new HttpResponse();

        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                    client.get(URL,response);
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler{

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String content = new String(responseBody);
            try {
                JSONObject json = new JSONObject(content);
                JSONObject device = json.getJSONObject("device");
                String name = device.getString("name");
                String type = device.getString("type");

                String result = name + " / " + type;
                textView.setText(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this, statusCode+", 통신에 실패했습니다. ",Toast.LENGTH_SHORT).show();
        }
    }
}
