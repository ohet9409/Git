package com.example.score;

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

public class InsertActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2;
    AsyncHttpClient client;
    HttpResponse response;
    String URL="http://192.168.0.61:8080/score/score/score_insert.jsp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }
/*
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }*/

    class HttpResponse extends AsyncHttpResponseHandler{
        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요");
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
            String str_json = new String(responseBody);
            try {
                JSONObject json = new JSONObject(str_json);
                String rt = json.getString("rt");
                if (rt.equals("OK")){
                    Toast.makeText(activity,"저장 성공",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity,ListActivity.class);
                    startActivity(intent);
                    finish();


                } else {
                    Toast.makeText(activity,"저장 실패",Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity,"통신 실패",Toast.LENGTH_SHORT).show();
            Log.e("[ERROR]",""+statusCode);
        }
    }
    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.button1:
            RequestParams params = new RequestParams();
            params.put("studNo",editText1.getText().toString());
            params.put("name",editText2.getText().toString());
            params.put("kor",editText3.getText().toString());
            params.put("eng",editText4.getText().toString());
            params.put("mat",editText5.getText().toString());
            client.post(URL,params,response);
            break;
        case R.id.button2:
            finish();
            break;
    }
    }
}
