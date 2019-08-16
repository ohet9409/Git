package com.example.miniboard2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.miniboard2.helper.RegexHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2;
    // 통신 객체 선언
    AsyncHttpClient client;
    HttpResponse response;
    // URL
    String URL ="http://192.168.0.61:8080/miniboard/community/community_modify.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        // 객체 초기화
        editText1= findViewById(R.id.editText1);
        editText2= findViewById(R.id.editText2);
        editText3= findViewById(R.id.editText3);
        editText4= findViewById(R.id.editText4);
        editText5= findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);

        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        // 화면 초기화
        editText1.setText(getIntent().getStringExtra("user_name"));
        editText3.setText(getIntent().getStringExtra("email"));
        editText4.setText(getIntent().getStringExtra("subject"));
        editText5.setText(getIntent().getStringExtra("content"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:      // 저장하기
                String user_name = editText1.getText().toString().trim();
                String user_pwd = editText2.getText().toString().trim();
                String email = editText3.getText().toString().trim();
                String subject = editText4.getText().toString().trim();
                String content = editText5.getText().toString().trim();
                RegexHelper regexHelper = RegexHelper.getInstance();
                String msg = null;
                //  입력값 검사
                if (msg == null && !regexHelper.isValue(user_name)){
                    msg = "이름을 입력하세요";
                } else if (msg == null && !regexHelper.isValue(user_pwd)){
                    msg = "비밀번호를 입력하세요";
                } else if (msg == null && !regexHelper.isValue(email)){
                    msg = "이메일을 입력하세요";
                } else if (msg == null && !regexHelper.isEmail(email)){
                    msg = "이메일이 형식에 맞지 않습니다.";
                } else if (msg == null && !regexHelper.isValue(subject)){
                    msg = "제목을 입력하세요";
                } else if (msg == null && !regexHelper.isValue(content)){
                    msg = "내용을 입력하세요";
                }
                //  에러가 검출되면 메시지 출력후, 실행 종료
                if (msg != null){
                    Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
                    return;
                }
                // 입력값이 있으면, 서버로 데이터 전송 및 요청
                RequestParams params = new RequestParams();
                params.put("user_name",user_name);
                params.put("user_pwd",user_pwd);
                params.put("email",email);
                params.put("subject",subject);
                params.put("content",content);
                params.put("seq",getIntent().getIntExtra("seq",0));
                client.post(URL,params,response);
                break;
            case R.id.button2:      // 취소하기
                finish();   // 전 화면으로 돌아가기
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
                if (rt.equals("OK")){
                  Toast.makeText(activity,"수정 성공",Toast.LENGTH_SHORT).show();
                  finish(); // 전 화면으로 돌아가기
                } else {
                    Toast.makeText(activity,"수정 실패",Toast.LENGTH_SHORT).show();
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
