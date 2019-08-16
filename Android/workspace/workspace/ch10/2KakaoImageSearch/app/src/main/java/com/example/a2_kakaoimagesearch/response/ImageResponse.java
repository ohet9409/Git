package com.example.a2_kakaoimagesearch.response;

import android.app.Activity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.a2_kakaoimagesearch.adapter.ImageAdapter;
import com.example.a2_kakaoimagesearch.model.Image;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ImageResponse extends AsyncHttpResponseHandler {
    // 객체 선언
    Activity activity;      // Toast를 표시하는데 사용하기 위한 Context
    ImageAdapter adapter;   // 데이터를 List에 저장
    ListView listView;      // 로딩중임을 표시하기 위한 포커스 조절을 위해 사용
    View footerView;        // 로딩중임을 표시하기 위해서 사용

    public ImageResponse(Activity activity, ImageAdapter adapter, ListView listView, View footerView) {
        this.activity = activity;
        this.adapter = adapter;
        this.listView = listView;
        this.footerView = footerView;
    }
    //  통신 시작
    @Override
    public void onStart() {
        // 다이얼로그 대신, 숨겨진 listView의 footer를 표시해준다.
        footerView.setVisibility(View.VISIBLE);
        // 맨 마지막요소(footer)에 대한 강제선택 (화면에 표시하기 위해)
        listView.setSelection(adapter.getCount()-1);

    }
    // 통신 종료
    @Override
    public void onFinish() {
       footerView.setVisibility(View.GONE);
    }
    // 통신 성공
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        // 통신 데이터 처리
        String content = new String(responseBody);
        try {
            JSONObject json = new JSONObject(content);
            JSONObject meta = json.getJSONObject("meta");
            //  공통변수 저장
            Image.total_count = meta.getInt("total_count");
            Image.pageable_count = meta.getInt("pageable_count");
            Image.is_end = meta.getBoolean("is_end");
            //  검색 결과 처리
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
                //  list에 저장
                adapter.add(image);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    // 통신 실패
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity,"통신실패",Toast.LENGTH_SHORT).show();
    }
}
