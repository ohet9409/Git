package com.example.jsonimagelisttest.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.jsonimagelisttest.adapter.JobAdapter;
import com.example.jsonimagelisttest.model.Job;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class JobResponse extends AsyncHttpResponseHandler {

    Activity activity;
    JobAdapter adapter;
    ProgressDialog dialog;

    public JobResponse(Activity activity, JobAdapter adapter) {
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
        String strJson = new String(responseBody);
        try {
            JSONObject json = new JSONObject(strJson);
            JSONObject job = json.getJSONObject("job");
            JSONArray item = job.getJSONArray("item");
            for (int i = 0; i<item.length(); i++){
                JSONObject jsonObject = item.getJSONObject(i);
                int num = jsonObject.getInt("num");
                String img = jsonObject.getString("img");
                String subject = jsonObject.getString("subject");
                String content = jsonObject.getString("content");
                String imgOrigin = jsonObject.getString("imgOrigin");
                Job job1 = new Job(num,img,subject,content,imgOrigin);
                adapter.add(job1);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity,"통신실패",Toast.LENGTH_SHORT).show();
    }
}
