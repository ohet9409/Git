package com.example.miniboard2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniboard2.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    TextView textView1, textView2, textView3, textView4;
    Button button1, button2;
    //  통신용 객체 선언
    AsyncHttpClient client;
    HttpResponse response;
    // URL
    String URL = "http://192.168.0.61:8080/miniboard/community/community_select.jsp";
    //  seq 저장 변수
    int seq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        // 인텐트에 저장된 데이터 추출
        seq = getIntent().getIntExtra("seq",seq);
    }

    // 화면 호출시 자동으로 다시 호출 된다.
    // 갱신
    @Override
    protected void onResume() {
        super.onResume();
        RequestParams params = new RequestParams();
        params.put("seq",seq);
        client.post(URL,params,response);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.button1:  // 삭제하기
                intent = new Intent(this,DeleteActivity.class);
                intent.putExtra("seq",seq);
                startActivity(intent);
                break;
            case R.id.button2:  // 수정하기
                intent = new Intent(this,EditActivity.class);
                intent.putExtra("subject",textView1.getText().toString());
                intent.putExtra("user_name",textView2.getText().toString());
                intent.putExtra("email",textView3.getText().toString());
                intent.putExtra("content",textView4.getText().toString());
                intent.putExtra("seq",seq);
                startActivity(intent);
                break;
        }
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
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String strJson = new String(responseBody);
            try {
                JSONObject json = new JSONObject(strJson);
                String rt = json.getString("rt");
                JSONArray item = json.getJSONArray("item");
                if (item.length() > 0){
                    JSONObject temp = item.getJSONObject(0);
                    textView1.setText(temp.getString("subject"));
                    textView2.setText(temp.getString("user_name"));
                    textView3.setText(temp.getString("email"));
                    textView4.setText(temp.getString("content"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity, "통신실패", Toast.LENGTH_SHORT).show();
            Log.e("[ERROR]",statusCode+"");
        }
    }
}
