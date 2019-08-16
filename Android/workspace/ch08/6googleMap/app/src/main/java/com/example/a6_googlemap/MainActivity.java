package com.example.a6_googlemap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

//  구글지도가 정밀 지도로 바뀌면서, 용량이 커져서 초기화과정이 오래 걸림
//  그래서, 백그라운드에서 초기화를 진행하고, 초기화가 완료되면 이벤트를 발생시킴
public class MainActivity extends AppCompatActivity implements LocationListener, OnMapReadyCallback {
    //  객체 선언
    GoogleMap googleMap;
    MapFragment fragment;
    LocationManager lm;             //  위치 관리자
    boolean permissionCK = false;   //  퍼미션 결과 저장
    Marker marker;                  //  지도에 표시할 마커 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        fragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragment);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //  구글맵 초기화(지도 띄우기)
        fragment.getMapAsync(this);
        //  퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
            }
        } else {
            permissionCK = true;
        }
    }
    // 지정된 시간, 거리마다 한번씩 호출된다.
    @Override
    public void onLocationChanged(Location location) {
        //  현재 위도와 경도 얻기
        double lat = location.getLatitude();    // 위도
        double lng = location.getLongitude();   // 경도
        /* 구글맵에 위치 설정하기 */
        //  현재 위치 관리 객체
        LatLng position = new LatLng(lat, lng);
        //  마커 표시
        if (marker == null){    // 마커가 없을 경우, 새로 생성하여 지도에 추가
            MarkerOptions options = new MarkerOptions();
            options.position(position);
            marker = googleMap.addMarker(options);
        } else {    // 이미 마커가 있을 경우, 위치만 갱신
            marker.setPosition(position);
        }
        //  지도 배율 설정 : zoom : 1~21(값이 커질수록 확대)
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 19);
        //  현재 위치로 맵 이동
        googleMap.animateCamera(cameraUpdate);
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
    public void onMapReady(GoogleMap googleMap) {
        //  초기화된 구글 맵 객체 저장
        this.googleMap = googleMap;
        if (permissionCK) readyMap();
    }

    //  위치 수신 준비
    private void readyMap() {
        //  현재 사용가능한 하드웨어 이름 얻기 : GPS, NETWORK
        String provider = lm.getBestProvider(new Criteria(), true);
        if (provider == null) {
            Toast.makeText(this, "위치정보가 사용한 상태가 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        //  해당 장치가 마지막으로 수신한 위치얻기
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        //  해당 장치가 마지막으로 수신한 위치얻기
        Location location = lm.getLastKnownLocation(provider);
        if (location != null){
            onLocationChanged(location);        // 이벤트 향수 강제 호출
        }
        //  위치 정보 취득시작
        //  (하드웨어 이름, 갱신시간주기, 갱신거리주기, 이벤트 핸들러)
        lm.requestLocationUpdates(provider, 1000, 1,this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        readyMap();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //  위치정보 수신 종료
        lm.removeUpdates(this);
    }
}
