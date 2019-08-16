package com.example.practice1;

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
    Button button;
    TextView textView;
    HttpResponse response;
    AsyncHttpClient client;
    String URL = "http://192.168.0.61:8080/server_data/student1.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        response = new HttpResponse();
        client = new AsyncHttpClient();

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
                JSONObject student1 = json.getJSONObject("student1");
                String name = student1.getString("name");
                int kor = student1.getInt("kor");
                int eng = student1.getInt("eng");
                int mat = student1.getInt("mat");
                int tot = student1.getInt("tot");
                double avg = student1.getDouble("avg");

                String result = "이름 : " + name + "\n"
                               +"국어 : "+ kor +"\n"
                        + "영어 : "+ eng +"\n"
                        +"수학 : "+  mat +"\n"
                        +"총점 : "+  tot +"\n"
                        + "평균 : "+ avg +"\n";
                textView.setText(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(MainActivity.this,statusCode + " 통신에 실패했습니다." ,Toast.LENGTH_SHORT).show();
        }
    }
}
