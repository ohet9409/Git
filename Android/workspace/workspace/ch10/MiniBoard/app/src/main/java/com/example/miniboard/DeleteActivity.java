package com.example.miniboard;

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

import com.example.miniboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.Locale;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HeaderIterator;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.ProtocolVersion;
import cz.msebera.android.httpclient.StatusLine;
import cz.msebera.android.httpclient.params.HttpParams;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    AsyncHttpClient client;
    HttpResponse response;
    String URL ="http://192.168.0.61:8080/miniboard/community/community_delete.jsp";
    TextView textView;
    EditText editText2;
    Button buttonDel, buttonCan;
    Community item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);
        textView = findViewById(R.id.textView);
        editText2 = findViewById(R.id.editText2);
        buttonDel = findViewById(R.id.buttonDel);
        buttonCan = findViewById(R.id.buttonCan);
        buttonCan.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        item = (Community) getIntent().getSerializableExtra("item");
        textView.setText(item.getSeq()+"번 글을 삭제하시려면 비밀번호를 입력하세요.");

    }
    @Override
    public void onBackPressed() {
        Log.e("[INFO]","뒤로가기");
        Intent intent = new Intent(this, ReadActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.buttonCan:
                intent = new Intent(this, ReadActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonDel:
                RequestParams params = new RequestParams();
                params.put("seq",item.getSeq());
                params.put("user_pwd",editText2.getText().toString().trim());
                client.get(URL,params,response);
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    class HttpResponse extends AsyncHttpResponseHandler{
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
            Toast.makeText(DeleteActivity.this,"삭제성공",Toast.LENGTH_SHORT).show();
        }
        //  서버의 200코드 이외의 응답을 수신한 경우 실행된다
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            if (responseBody != null){
                String content = new String(responseBody);
                String result = "결과코드 : " + statusCode + "\n" + "에러내용 : " + content;
                Toast.makeText(DeleteActivity.this,result,Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(DeleteActivity.this,"사이트를 찾을 수가 없습니다.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
