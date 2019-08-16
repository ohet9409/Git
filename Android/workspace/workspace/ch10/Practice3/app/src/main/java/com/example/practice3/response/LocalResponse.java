package com.example.practice3.response;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice3.adapter.LocalAdapter;
import com.example.practice3.model.Local;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class LocalResponse extends AsyncHttpResponseHandler {
    Activity activity;
    LocalAdapter adapter;
    ListView listView;
    View footerView;

    public LocalResponse(Activity activity, LocalAdapter adapter, ListView listView, View footerView) {
        this.activity = activity;
        this.adapter = adapter;
        this.listView = listView;
        this.footerView = footerView;
    }

    @Override
    public void onStart() {
        footerView.setVisibility(View.VISIBLE);
        listView.setSelection(adapter.getCount()-1);
    }

    @Override
    public void onFinish() {
        footerView.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        System.out.println(Local.is_end + ">>>>");
        String content = new String(responseBody);
        try {
            JSONObject json = new JSONObject(content);
            JSONObject meta = json.getJSONObject("meta");
            Local.pageable_count = meta.getInt("pageable_count");
            Local.total_count = meta.getInt("total_count");
            Local.is_end = meta.getBoolean("is_end");
            JSONArray documents = json.getJSONArray("documents");
            System.out.println(Local.is_end + ">>>>");
            for (int i=0; i<documents.length(); i++){

                JSONObject jsonObject = documents.getJSONObject(i);
                Local local = new Local();
                local.setPlace_name(jsonObject.getString("place_name"));
                local.setDistance(jsonObject.getString("distance"));
                local.setPlace_url(jsonObject.getString("place_url"));
                local.setCategory_name(jsonObject.getString("category_name"));
                local.setAddress_name(jsonObject.getString("address_name"));
                local.setRoad_address_name(jsonObject.getString("road_address_name"));
                local.setId(jsonObject.getString("id"));
                local.setPhone(jsonObject.getString("phone"));
                local.setCategory_group_code(jsonObject.getString("category_group_code"));
                local.setCategory_group_name(jsonObject.getString("category_group_name"));
                local.setX(jsonObject.getString("x"));
                local.setY(jsonObject.getString("y"));
                adapter.add(local);
                Log.d("[in]",""+local.getAddress_name());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity,"통신 실패", Toast.LENGTH_SHORT).show();
        Log.d("[in]",""+statusCode);
        Log.d("[in]",""+headers);
        Log.d("[in]",""+responseBody);
        Log.d("[in]",""+error);
    }
}
