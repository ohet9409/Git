package com.example.gradelistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.gradelistexam.MainActivity;
import com.example.gradelistexam.adapter.GradeAdapter;
import com.example.gradelistexam.model.Grade;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class GradeResponse extends AsyncHttpResponseHandler {
    Activity activity;
    GradeAdapter adapter;
    ProgressDialog dialog;

    public GradeResponse(Activity activity, GradeAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }
    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려주세요...");
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
        String content = new String(responseBody);
        try {
            JSONObject json = new JSONObject(content);
            JSONObject grade = json.getJSONObject("grade");
            JSONArray member = grade.getJSONArray("member");
            for (int i=0; i<member.length(); i++) {
                JSONObject item = member.getJSONObject(i);
                String name = item.getString("name");
                int kor = item.getInt("kor");
                int eng = item.getInt("eng");
                int math = item.getInt("math");
                Grade grade1 = new Grade(name, kor, eng, math);
                adapter.add(grade1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity, "통신 실패", Toast.LENGTH_SHORT).show();
    }
}
