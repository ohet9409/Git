package com.example.a2_parametersenderexam;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    Button button1, button2;
    EditText editText1, editText2;
    TextView textView;

    //  요청 객체
    AsyncHttpClient client;
    //  응답 객체
    HttpResponse response;
    // URL
    String URL_GET = "http://192.168.0.61:8080/server_data/send_get.jsp";
    String URL_Post = "http://192.168.0.61:8080/server_data/send_post.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView = findViewById(R.id.textView1);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);

        //  이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String user_id = editText1.getText().toString().trim();
        String user_pw = editText2.getText().toString().trim();
        //  서버에 전달할 파라미터 값을 저장하는 객체
        RequestParams params = new RequestParams();
        params.put("user_id",user_id);
        params.put("user_pw",user_pw);

        switch (v.getId()){
            case R.id.button1:
                client.get(URL_GET,params,response);
                break;
            case R.id.button2:
                client.post(URL_Post,params,response);
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
            textView.setText(content);
        }
        //  서버의 200코드 이외의 응답을 수신한 경우 실행된다
        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            if (responseBody != null){
                String content = new String(responseBody);
                String result = "결과코드 : " + statusCode + "\n" + "에러내용 : " + content;
                textView.setText(result);
            } else {
                textView.setText("사이트를 찾을 수가 없습니다.");
            }
        }
    }
}
