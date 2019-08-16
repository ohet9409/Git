package com.example.practice3;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice3.adapter.LocalAdapter;
import com.example.practice3.model.Local;
import com.example.practice3.response.LocalResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AbsListView.OnScrollListener, LocationListener, AdapterView.OnItemClickListener {
    List<Local> list;
    LocalAdapter localAdapter;
    EditText editText;
    Button button1, button2, button3;
    ListView listView;
    LinearLayout footer;
    AsyncHttpClient client;
    LocalResponse response;
    LocationManager lm;
    double lat; // 위도
    double lng; //  경도

    public final int PAGE_SIZE = 15;
    public static int PAGE = 1;
    boolean lastItemVisibleFlag = false;
    String keyword = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        localAdapter = new LocalAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        listView = findViewById(R.id.listView);
        View footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
        footer = footerView.findViewById(R.id.footer);
        footer.setVisibility(View.GONE);

        client = new AsyncHttpClient();
        response = new LocalResponse(this, localAdapter, listView, footer);

        listView.addFooterView(footerView);
        listView.setAdapter(localAdapter);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);

        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                PAGE = 1;
                localAdapter.clear();
                getKakaoData1();

                break;
            case R.id.button2:
                keyword = editText.getText().toString().trim();
                if (keyword.equals("")) {
                    Toast.makeText(this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
                    return;

                }
                PAGE = 1;
                localAdapter.clear();
                getKakaoData(keyword);
                break;


        }
    }

    private void getKakaoData1() {
        RequestParams params = new RequestParams();

        params.put("category_group_code", "FD6");
        params.put("size", String.valueOf(PAGE_SIZE));
        params.put("page", String.valueOf(PAGE));
        params.put("x", String.valueOf(lng));
        params.put("y", String.valueOf(lat));
        Log.d("[in]",""+lat);
        Log.d("[in]",""+lng);
        params.put("radius", "200");


        //  헤더파일에 api키 추가
        client.addHeader("Authorization", "KakaoAK c268174c65ef7a778933c1aa876494cf");
        //  네트워크 접속, 요청
        client.get("https://dapi.kakao.com/v2/local/search/category.json?", params, response);
    }

    private void getKakaoData(String keyword) {
        RequestParams params = new RequestParams();
        params.put("query", keyword);

        params.put("size", String.valueOf(PAGE_SIZE));
        params.put("page", String.valueOf(PAGE));


        //  헤더파일에 api키 추가
        client.addHeader("Authorization", "KakaoAK c268174c65ef7a778933c1aa876494cf");
        //  네트워크 접속, 요청
        client.get("https://dapi.kakao.com/v2/local/search/address.json", params, response);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag) {
            //  현재 페이지가 전체페이지보다 작을 경우,
            //  페이지 수를 1증가 시키고 다시 통신을 시도한다.
            if (PAGE < Local.pageable_count) {
                PAGE++;
                getKakaoData1();
                //getKakaoData(keyword);
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        /*
        String test = "첫번째 항목의 번호 : " + firstVisibleItem + ", " + "화면 아이템의 갯수 : " + visibleItemCount + ", " + "전체 갯수 : " + totalItemCount;
        Log.d("[INFO]", test);
        */
        // firstVisibleItem + visibleItemCount 의 값이 totalItemCount보다 크거나 같을 때,
        //  => 스크롤이 맨 끝에 도착함을 나타냄
        lastItemVisibleFlag = (totalItemCount > 0) && (firstVisibleItem + visibleItemCount >= totalItemCount);
    }

    @Override
    public void onLocationChanged(Location location) {
        // 현재 위치 얻기
        lat = location.getLatitude();    // 위도
        lng = location.getLongitude();   // 경도


    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Local item = localAdapter.getItem(position);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 현재 사용 가능한 하드웨어 이름 얻기
        // LocationManager.GPS_PROVIDER / LocationManager.NETWORK_PROVIDER
        // true : 켜져서 사용가능한 장치만 알려줌 (on되어 있는 장치)
        String provider = lm.getBestProvider(new Criteria(), true);
        Toast.makeText(this, "BestProvider = " + provider, Toast.LENGTH_SHORT).show();

        if (provider == null) {
            Toast.makeText(this, "위치정보를 사용할 상태가 아닙니다.",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        // 해당 장치가 마지막으로 수신한 위치 얻기
        Location location = lm.getLastKnownLocation(provider);
        if(location != null) {
            onLocationChanged(location);    // 이벤트 강제 호출
        }
        // GPS 구동
        // requestLocationUpdates(하드웨어 이름, 갱신시간주기(ms), 갱신거리주기(m), 이벤트 핸들러)
        // 정해진 시간, 정해진 거리를 벗어날 때마다, onLocationChanged(Location location)를 호출함.
        lm.requestLocationUpdates(provider, 400, 1, this);
    }
}
