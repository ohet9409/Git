package com.example.miniboard3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2, button3;
    //  업로드할 사진파일의 경로
    String filePath = null;
    // 통신 객체 선언
    AsyncHttpClient client;
    HttpResponse response;

    // URL
    String URL = "http://192.168.0.61:8080/miniboard/community/community_insert.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
    }

    // 응답 클래스
    class HttpResponse extends AsyncHttpResponseHandler{
        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요.");
            dialog.setCancelable(false);
            dialog.show();
        }

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
                    Toast.makeText(activity,"저장 성공",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(activity,"저장 실패",Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity,"통신 실패",Toast.LENGTH_SHORT).show();
            Log.e("[info]",""+statusCode);
        }
    }
    @Override
    public void onClick(View v) {

    }
}
