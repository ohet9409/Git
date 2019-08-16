package com.example.a1_simplehttpclientexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    Button button;
    TextView textView;
    //  요청 통신 객체 선언
    AsyncHttpClient client;
    //  응답 처리 객체 선언 : inner 클래스로 만들어서 사용
    HttpResponse response;
    //  URL
    String  URL ="http://192.168.0.61:8080/server_data/simple_text.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        client = new AsyncHttpClient();
        response = new HttpResponse();
        //  이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //  주어진 URL로 통신을 시도한다.
                //  Client객체는 웹 서버에게 요청을 하고,
                //  HttpResponse객체는 응답을 기다렸다가 명령을 수행한다.
                client.get(URL, response);
                break;
        }
    }

    /////////////////////////////////////////
    //  통신 결과를 받아서 처리할 클래스
    public class HttpResponse extends AsyncHttpResponseHandler{
        /**
         * 서버로부터 200코드가 오면 자동호출
         * @param statusCode    : 200 이 전달됨
         * @param headers       : response header 정보
         * @param responseBody  : 응답 데이터 (http문서 or 텍스트 or XML or JSON)
         */
        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String content = new String(responseBody);
            textView.setText(content);
        }

        //  서버로부터 200코드가 아닌 값이 오면 자동 호출출
        @Override
       public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            if (responseBody != null) {
                String content = new String(responseBody);
                content = String.valueOf(Html.fromHtml(content));
                String result = "결과코드 : " + statusCode + "\n" + "에러내용 : " + content;
                textView.setText(result);
            } else {
                textView.setText("사이트에 접속을 할 수가 없습니다.");
                //Toast.makeText(MainActivity.this, "사이트에 접속을 할 수가 없습니다.",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
