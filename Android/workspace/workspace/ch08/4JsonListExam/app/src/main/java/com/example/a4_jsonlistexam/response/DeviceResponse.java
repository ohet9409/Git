package com.example.a4_jsonlistexam.response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.widget.Toast;

import com.example.a4_jsonlistexam.MainActivity;
import com.example.a4_jsonlistexam.adapter.DeviceAdapter;
import com.example.a4_jsonlistexam.model.Device;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

//  통신 응답처리를 위한 클래스
public class DeviceResponse extends AsyncHttpResponseHandler {
    Activity activity;                  // ProgressDialog를 사용하기 위해서 필요
    DeviceAdapter adapter;              // 서버로부터 넘어온 Json 데이터를 List에 저장하기 위해서
    ProgressDialog dialog;              //  기다려 주세요


    public DeviceResponse(Activity activity, DeviceAdapter adapter) {
        this.activity = activity;
        this.adapter = adapter;
    }

    // 통신시작시, 자동호출
    @Override
    public void onStart() {
        dialog = new ProgressDialog(activity);
        dialog.setMessage("잠시만 기다려주세요...");
        dialog.setCancelable(false);
        dialog.show();
    }

    // 통신종료시, 자동호출
    @Override
    public void onFinish() {
        dialog.dismiss();
        dialog = null;

    }

    // 서버로부터, 200코드가 오면 자동호출
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
        String content = new String(responseBody);      // byte[]을 String으로 변환
        try {
            JSONObject json = new JSONObject(content);  // 문자열을 Json 객체로 만들기
            JSONArray device = json.getJSONArray("device");
            for (int i=0; i<device.length(); i++){
                JSONObject item = device.getJSONObject(i);
                String name = item.getString("name");
                String type = item.getString("type");
                Device device1 = new Device(name, type);
                adapter.add(device1);   //  어댑터 객체를 통해서 List에 데이터 저장
                                        //  어댑터 객체가 ListView에게 List에 저장된 데이터
                                        //  전체갯수를 알려줌,
                                        //  그러면, ListView는 어댑터 객체 안의 getView()를
                                        //  List에 저장된 데이터 갯수만큼 호출함
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // 서버로부터, 200코드가 아닌 코드가 오면 자동호출
    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
        Toast.makeText(activity, "통신실패", Toast.LENGTH_SHORT).show();
    }
}
