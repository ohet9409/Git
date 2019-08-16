package com.example.myapplication4;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication4.adapter.InformAdapter;
import com.example.myapplication4.model.Inform;
import com.example.myapplication4.response.InformResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, LocationListener {
    //  객체 선언
    List<Inform> list;
    InformAdapter adapter;
    EditText editText;
    Button button1, button2, button3;
    ListView listView;
    LinearLayout footer;
    AsyncHttpClient client;
    InformResponse response;
    //  카카오용 변수
    final int PAGE_SIZE = 15;                 // 요청 데이터 개수
    int PAGE = 1;                            //  요청 페이지
    boolean lastItemVisibleFlag = false;    //  ListView 끝에 도착 여부 저장
    String keyword = "";                     //  검색어
    //  위도, 경도
    double latitude = 37.56, longitude = 126.98;
    int radius = 500;
    int index = 1;
    //  GPS 관리 객체
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        list = new ArrayList<>();
        adapter = new InformAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        listView = findViewById(R.id.listView);
        //  list_footer.xml 설정 객체 생성
        View footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
        footer = footerView.findViewById(R.id.footer);
        footer.setVisibility(View.GONE);
        //  listView 설정
        listView.addFooterView(footerView);
        listView.setAdapter(adapter);
        //  통신 객체 초기화
        client = new AsyncHttpClient();
        response = new InformResponse(this, adapter, listView, footer);
        //  GPS 관리 객체 초기화
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);      //  시스템에 있는 기능을 불러와서 사용
        //  이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);

        //  퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        }
    }

    //  화면 뜨기 직전 자동호출 : GPS 설정
    @Override
    protected void onResume() {
        super.onResume();
        String provider = lm.getBestProvider(new Criteria(), true);
        Toast.makeText(this, "BestProvider : " + provider, Toast.LENGTH_SHORT).show();
        if (provider == null) {
            Toast.makeText(this, "위치정보가 사용가능한 상태가 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        //  GPS 마지막 수신 위치값 얻기
        Location location = lm.getLastKnownLocation(provider);
        if (location != null){
            onLocationChanged(location);
        }
        //  GPS 설정
        lm.requestLocationUpdates(provider,1000,1,this);

        // 처음 앱이 시작될 때, 근처 식당 보여주기
        getKakaoData(null, 1);
    }

    //  화면이 가려지기 직전 자동호출 : GPS 설정 해제
    @Override
    protected void onPause() {
        super.onPause();
        lm.removeUpdates(this);
    }

    @Override
    public void onClick(View v) {
        //  버튼 클릭은 신규 검색이므로 기존 데이터 삭제하기
        adapter.clear();

        switch (v.getId()){
            case R.id.button1:      // GPS 위치 기준 반경 500m 음식점 정보 갱신
                index = 1;          //  요청 명령이 다르기 때문에 index 사용해서 구분
                getKakaoData(keyword, index);
                break;
            case R.id.button2:      // 지역명으로 음식점 정보 요청
                index = 2;
                keyword = editText.getText().toString().trim();
                if (keyword.equals("")){
                    Toast.makeText(this, "검색어를 입력하세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                getKakaoData(keyword,index);
                break;
            case R.id.button3:      // 앞으로 추가할 기능능
               break;
        }
    }

    private void getKakaoData(String keyword, int index) {
        //  파라미터 설정 (요청 변수 설정)
        RequestParams params = new RequestParams();
        //  헤더파일에 api키 추가
        client.addHeader("Authorization", "KakaoAK c268174c65ef7a778933c1aa876494cf");
        switch (index){
            case 1:
                params.put("category_group_code","FD6");        // 음식점
                params.put("x",String.valueOf(longitude));
                params.put("y",String.valueOf(latitude));
                params.put("radius",radius);
                params.put("page",String.valueOf(PAGE));
                params.put("size",String.valueOf(PAGE_SIZE));
                client.get("https://dapi.kakao.com/v2/local/search/category.json",params,response);
                break;
            case 2:
                params.put("query",keyword);
                params.put("category_group_code","FD6");
                params.put("page",String.valueOf(PAGE));
                params.put("size",String.valueOf(PAGE_SIZE));
                client.get("https://dapi.kakao.com/v2/local/search/keyword.json",params,response);
                break;
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //  목록 끝에 도착하면 다음 데이터 요청
        if(scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag){
            PAGE++;
            getKakaoData(keyword, index);
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //  목록 끝에 왔는 지 판단
        lastItemVisibleFlag = (totalItemCount > 0) && (firstVisibleItem + visibleItemCount >= totalItemCount );

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Inform item = adapter.getItem(position);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("item",item);
        startActivity(intent);
    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();      //  위도
        longitude = location.getLongitude();    //  경도
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
}
