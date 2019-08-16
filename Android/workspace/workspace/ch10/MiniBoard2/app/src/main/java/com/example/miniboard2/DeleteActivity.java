package com.example.miniboard2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class DeleteActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    TextView textView;
    EditText editText;
    Button button1, button2;
    // 통신 객체 선언
    AsyncHttpClient client;
    HttpResponse response;
    // URL
    String URL="http://192.168.0.61:8080/miniboard/community/community_delete.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        // 객체 초기화
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);

        //  이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        // 화면 설정
        String strTextView = textView.getText().toString();
        strTextView = String.format(strTextView,getIntent().getIntExtra("seq",0));
        textView.setText(strTextView);
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
    // 통신 종료
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
                    Toast.makeText(activity, "삭제 성공", Toast.LENGTH_SHORT).show();
                    // MainActivity로 되돌아가기
                    Intent intent = new Intent(activity, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);    // 히스토리 스택 지우기
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);   // 새로 만들지 말고, 기존 화면 보여주기
                    startActivity(intent);
                } else {
                    Toast.makeText(activity, "삭제 실패", Toast.LENGTH_SHORT).show();
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
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:      // 삭제하기
                int seq = getIntent().getIntExtra("seq",0);
                String user_pwd = editText.getText().toString().trim();
                if (user_pwd.equals("")){
                    Toast.makeText(this,"비밀번호를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                RequestParams params = new RequestParams();
                params.put("seq",seq);
                params.put("user_pwd",user_pwd);
                client.post(URL,params,response);
                break;
            case R.id.button2:      // 취소하기
                finish();
                break;
        }
    }
}
