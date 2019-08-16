package com.example.myapplication4.response;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication4.adapter.InformAdapter;
import com.example.myapplication4.model.Inform;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class InformResponse extends AsyncHttpResponseHandler {
    //  객체 선언
    Activity activity;
    InformAdapter adapter;  //  List에 데이터 저장
    ListView listView;
    View footer;

    public InformResponse(Activity activity, InformAdapter adapter, ListView listView, View footer) {
        this.activity = activity;
        this.adapter = adapter;
        this.listView = listView;
        this.footer = footer;
    }

    //  통신 시작
    @Override
    public void onStart() {
        footer.setVisibility(View.VISIBLE);
        listView.setSelection(adapter.getCount()-1);
        Log.d("[Info]","URL = " + getRequestURI().toString());
    }

    //  통신 종료
    @Override
    public void onFinish() {
        footer.setVisibility(View.GONE);

    }

    //  통신 성공
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String content = new String(responseBody);
        try {
            JSONObject json = new JSONObject(content);
            //  공통 데이터
            JSONObject meta = json.getJSONObject("meta");
            Inform.pageable_count = meta.getInt("pageable_count");
            Inform.total_count = meta.getInt("total_count");
            Inform.is_end = meta.getBoolean("is_end");
            //  블럭 개별 데이터
            JSONArray documents =json.getJSONArray("documents");
            for (int i =0; i<documents.length(); i++) {
                JSONObject jsonObject = documents.getJSONObject(i);
                Inform inform = new Inform();
                inform.setPlace_name(jsonObject.getString("place_name"));
                inform.setDistance(jsonObject.getString("distance"));
                inform.setPlace_url(jsonObject.getString("place_url"));
                inform.setCategory_name(jsonObject.getString("category_name"));
                inform.setAddress_name(jsonObject.getString("address_name"));
                inform.setRoad_address_name(jsonObject.getString("road_address_name"));
                inform.setId(jsonObject.getString("id"));
                inform.setPhone(jsonObject.getString("phone"));
                inform.setCategory_group_code(jsonObject.getString("category_group_code"));
                inform.setCategory_group_name(jsonObject.getString("category_group_name"));
                inform.setX(jsonObject.getString("x"));
                inform.setY(jsonObject.getString("y"));
                //  저장하기 전에, 기존 데이터와 같은 지 검사해서, 다른면 저장하기
                if (adapter.getCount() > 0) {
                    Boolean isSameCheck = false;            //  같은 값이 있으면 : true
                    for (int x = 0; x < adapter.getCount(); x++) {
                        Inform inform1 = adapter.getItem(x);
                        if (inform1.getPlace_name().equals(inform.getPlace_name()))
                            isSameCheck = true;
                    }
                    if (!isSameCheck) {
                        adapter.add(inform);
                    }
                }
                else {
                    adapter.add(inform);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //  통신 실패
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity,"통신실패",Toast.LENGTH_SHORT).show();
        Log.d("[Info]"," " + statusCode);
    }
}
