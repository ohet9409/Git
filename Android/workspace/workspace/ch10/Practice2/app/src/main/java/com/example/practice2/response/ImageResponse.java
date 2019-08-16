package com.example.practice2.response;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice2.adapter.ImageAdapter;
import com.example.practice2.model.Image;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ImageResponse extends AsyncHttpResponseHandler {
    Activity activity;
    ImageAdapter adapter;
    ListView listView;
    View footerView;

    public ImageResponse(Activity activity, ImageAdapter adapter, ListView listView, View footerView) {
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
        String content = new String(responseBody);
        try {
            JSONObject json = new JSONObject(content);
            JSONObject meta = json.getJSONObject("meta");
            Image.total_count = meta.getInt("total_count");
            Image.pageable_count = meta.getInt("pageable_count");
            Image.is_end = meta.getBoolean("is_end");
            JSONArray documents = json.getJSONArray("documents");
            for (int i =0; i<documents.length(); i++){
                JSONObject jsonObject = documents.getJSONObject(i);
                Image image = new Image();
                image.setCollection(jsonObject.getString("collection"));
                image.setThumbnail_url(jsonObject.getString("thumbnail_url"));
                image.setImage_url(jsonObject.getString("image_url"));
                image.setWidth(jsonObject.getInt("width"));
                image.setHeight(jsonObject.getInt("height"));
                image.setDisplay_sitename(jsonObject.getString("display_sitename"));
                image.setDoc_url(jsonObject.getString("doc_url"));
                image.setDatetime(jsonObject.getString("datetime"));
                adapter.add(image);
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
