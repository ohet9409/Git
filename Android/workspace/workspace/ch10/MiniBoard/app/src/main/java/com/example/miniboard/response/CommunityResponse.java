package com.example.miniboard.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.miniboard.adapter.CommunityAdapter;
import com.example.miniboard.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class CommunityResponse extends AsyncHttpResponseHandler {
    Activity activity;
    CommunityAdapter adapter;
    ProgressDialog dialog;

    public CommunityResponse(Activity activity, CommunityAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려주세요");
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void onFinish() {
        dialog.dismiss();
        dialog=null;
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        Log.d("[INFO]","TEST1");
        String content1 = new String(responseBody);
        try {
            JSONObject json = new JSONObject(content1);
            String rt = json.getString("rt");
            Log.d("[INFO]","TEST2");
            int total = json.getInt("total");
            JSONArray item = json.getJSONArray("item");
            for (int i=0; i<item.length();i++){
                Log.e("[INFO]","TEST3");
                JSONObject temp = item.getJSONObject(i);
                int seq = temp.getInt("seq");
                String user_name = temp.getString("user_name");
                String user_pwd = temp.getString("user_pwd");
                String email = temp.getString("email");
                String subject = temp.getString("subject");
                String content = temp.getString("content");
                String reg_date = temp.getString("reg_date");
                String edit_date = temp.getString("edit_date");

                Log.d("[INFO]",""+edit_date);
                Community community1 = new Community(seq,user_name,user_pwd,email,subject,content,reg_date,edit_date);
                adapter.add(community1);
            }
            Log.d("[INFO]","TEST4");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("[INFO]","TEST5");
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity,"통신실패",Toast.LENGTH_SHORT).show();
    }
}
