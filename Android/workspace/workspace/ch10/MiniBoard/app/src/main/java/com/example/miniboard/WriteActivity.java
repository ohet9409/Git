package com.example.miniboard;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpResponse;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextName, editTextPass, editTextEmail, editTextSub, editTextContent;
    Button buttonIns, buttonCan;
    AsyncHttpClient client;
    String URL = "http://192.168.0.61:8080/miniboard/community/community_insert.jsp";
    HttpResponse response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        editTextName = findViewById(R.id.editTextName);
        editTextPass = findViewById(R.id.editTextPass);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSub = findViewById(R.id.editTextSub);
        editTextContent = findViewById(R.id.editTextContent);
        buttonCan = findViewById(R.id.buttonCan);
        buttonIns = findViewById(R.id.buttonIns);
        buttonIns.setOnClickListener(this);
        buttonCan.setOnClickListener(this);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);
    }

    @Override
    public void onBackPressed() {
        Log.e("[INFO]","뒤로가기");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    class HttpResponse extends AsyncHttpResponseHandler {
        // Activity와 기다려 주세요 다이얼로그창
        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity){
            this.activity = activity;
        }

        // 통신 시작시 실행된다. AsyncHttpClient 클래스가 서버에 요청을 한 직후에, 자동호출
        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요.");
            dialog.setCancelable(false);
            dialog.show();
            Log.d("[INFO]", String.valueOf(getRequestURI()));
        }
        //  성공, 실패 여부에 상관없이 통신이 종료되면 실행된다.
        @Override
        public void onFinish() {
            dialog.dismiss();   // 강제 종료
            dialog = null;
        }
        //  서버의 200코드 응답을 수신한 경우 실행된다.
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String content = new String(responseBody);
            Toast.makeText(WriteActivity.this,"저장 성공.",Toast.LENGTH_SHORT).show();
            editTextContent.setText("저장 성공");
            editTextEmail.setText("");
            editTextName.setText("");
            editTextPass.setText("");
            editTextSub.setText("");
        }
        //  서버의 200코드 이외의 응답을 수신한 경우 실행된다
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            if (responseBody != null){
                String content = new String(responseBody);
                String result = "결과코드 : " + statusCode + "\n" + "에러내용 : " + content;

            } else {

                Toast.makeText(WriteActivity.this,"사이트를 찾을 수가 없습니다.",Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.buttonCan:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonIns:
                String user_name = editTextName.getText().toString().trim();
                String user_pwd = editTextPass.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String subject = editTextSub.getText().toString().trim();
                String content = editTextContent.getText().toString().trim();
                RequestParams params = new RequestParams();
                params.put("user_name",user_name);
                params.put("user_pwd",user_pwd);
                params.put("email",email);
                params.put("subject",subject);
                params.put("content",content);
                client.get(URL,params,response);
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
