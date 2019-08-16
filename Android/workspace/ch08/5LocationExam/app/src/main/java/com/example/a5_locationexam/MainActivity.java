package com.example.a5_locationexam;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {
    //  객체 선언
    TextView textView1, textView2, textView3;
    LocationManager Im;     // 위치 관리자 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        //  위치 관리자를 시스템으로부터 얻어오기
        Im = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        /* 참조
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         */
        // LayoutInflater inflater = getLayoutInflater();
        //  Im을 사용하기 전에 permission을 확인해야 한다.
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

    //  Activity 화면이 뜨기직전에 호출
    //  GPS 값 읽기 시작
    @Override
    protected void onResume() {
        super.onResume();
        //  현재 사용 가능한 하드웨어 이름 얻기
        //  LocationManager.GPS_PROVIDER / LocationManager.NETWORK_PROVIDER
        //  true : 켜져서 사용가능한 장치만 알려줌(on되어 있는 장치)
        String provider = Im.getBestProvider(new Criteria(), true);
        Toast.makeText(this, "BestProvider = " + provider, Toast.LENGTH_SHORT).show();

        if (provider == null) {
            Toast.makeText(this, "위치정보를 사용할 상태가 아닙니다.", Toast.LENGTH_SHORT).show();
            return;
        }

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
        //  해당 장치가 마지막으로 수신한 위치 얻기
        Location location = Im.getLastKnownLocation(provider);
        if (location != null){
            onLocationChanged(location);    // 이벤트 강제 호출
        }
        // GPS 구동
        //  requestLocationUpdates(하드웨어 이름, 갱신시간주기(ms), 갱신거리주기(m), 이벤트 핸들러)
        //  정해진 시간, 정해진 거리를 벗어날 때마다, onLocationChanged(Location location)를 호출함.
        Im.requestLocationUpdates(provider, 400, 1, this);
    }

    //  Activity 화면이 사라지기 직전에 호출
    //  GPS 값 읽기 기능 정지
    @Override
    protected void onPause() {
        super.onPause();
        //  GPS 사용 종료
        Im.removeUpdates(this);
    }

    public  String getAddress(double lat, double lng){
        String str_address = null;
        //  위치 정보를 활용하기 위한 구글 OpenAPI 객체
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        //  주소 목록을 담기 위한 List
        List<Address> list = null;
        try {
            //  getFromLocation(위도, 경도, 결과수);
            list = geocoder.getFromLocation(lat, lng, 1);
            if (list.size() > 0){
                Address address = list.get(0);
                str_address = address.getCountryName() + " "    // 국가
                            + address.getAdminArea() + " "      // 시
                            + address.getLocality() + " "       // 구
                            + address.getThoroughfare() + " "   // 동
                            + address.getFeatureName();         // 번지

                Log.d("[INFO]", "address = " + address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str_address;
    }

    //  설정된 값이 바뀌면 호출 ( 지정된 시간, 거리마다 한번씩 호출된다. )
    @Override
    public void onLocationChanged(Location location) {
        //  현재 위치 얻기
        double lat = location.getLatitude();    //  위도
        double lng = location.getLongitude();   //  경도

        textView1.setText("위도 : " + lat);
        textView2.setText("경도 : " + lng);
        textView3.setText("주소 : " + getAddress(lat, lng));
    }
    //  실내와 실외를 왔다갔다 할 때마다 호출
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }
    // GPS 기능이 On 되면 호출
    @Override
    public void onProviderEnabled(String provider) {

    }
    //  GPS 기능이 Off 되면 호출
    @Override
    public void onProviderDisabled(String provider) {

    }
}
