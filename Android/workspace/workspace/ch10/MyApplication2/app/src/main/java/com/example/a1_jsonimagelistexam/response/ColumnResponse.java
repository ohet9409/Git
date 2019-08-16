package com.example.a1_jsonimagelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.a1_jsonimagelistexam.adapter.ColumnAdapter;
import com.example.a1_jsonimagelistexam.model.Column;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ColumnResponse extends AsyncHttpResponseHandler {
    Activity activity;          //  ProgressDialog에서 사용
    ColumnAdapter adapter;      //  List에 데이터 저장할 때 사용
    ProgressDialog dialog;      //  "잠시만 기다려주세요" 다이얼로그

    public ColumnResponse(Activity activity, ColumnAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }
    //  통신 시작시 자동호출
    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려주세요...");
        dialog.setCancelable(false);
        dialog.show();
    }
    // 통신 종료시 자동호출
    @Override
    public void onFinish() {
        dialog.dismiss();
        dialog = null;
    }
    //  200 코드가 오면, 자동호출
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String strJson = new String(responseBody);
        try {
            JSONObject json = new JSONObject(strJson);
            JSONObject column = json.getJSONObject("column");
            JSONArray item = column.getJSONArray("item");
            for (int i=0; i<item.length(); i++){
                JSONObject jsonObject = item.getJSONObject(i);
                int num = jsonObject.getInt("num");
                String img = jsonObject.getString("img");
                String subject = jsonObject.getString("subject");
                String content = jsonObject.getString("content");
                Column column1 = new Column(num,img,subject,content);
                adapter.add(column1);       // 리스트에 데이터 저장
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //  200 코드가 아닐 떄, 자동호출
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity,"통신실패",Toast.LENGTH_SHORT).show();
    }
}
