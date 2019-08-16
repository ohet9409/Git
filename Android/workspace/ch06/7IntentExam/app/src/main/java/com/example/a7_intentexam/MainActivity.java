package com.example.a7_intentexam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.File;
import java.time.Instant;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        listView = findViewById(R.id.listView);
        //  이벤트 설정
        listView.setOnItemClickListener(this);
        //  위험 권한 얻기
        permissionCheck1();

    }

    private void permissionCheck1() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)){

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 100);
            }
        }
    }
    private void permissionCheck2() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 101);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 100:
                permissionCheck2();
                break;
        }

    }

    //  이벤트 처리
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        // 암묵적 인텐트 : intent(액션, Uri)
        switch (position){
            case 0:     // 전화 다이얼러 호출
                intent = new Intent(intent.ACTION_DIAL, Uri.parse("tel: 01012345678"));
                startActivity(intent);
                break;
            case 1:     // 전화 걸기
                //  -> CALL_PHONE 퍼미션 추가 필요
                intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel: 01012345678"));
                startActivity(intent);
                break;
            case 2:     //  문자 발송 화면 호출
                intent = new Intent(intent.ACTION_SENDTO,Uri.parse("smsto: 01012345678"));
                startActivity(intent);
                break;
            case 3:     // 이메일 보내기 화면 호출
                intent = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:hong@naver.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "메일테스트");
                intent.putExtra(Intent.EXTRA_TEXT, "안드로이드에서 메일 발송 테스트");
                startActivity(intent);
            break;
            case 4:     // 웹 브라우저 호출
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://m.naver.com"));
                startActivity(intent);
                break;
            case 5:     // 주소록
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://contacts/people"));
                startActivity(intent);
                break;
            case 6:     // 특정 App 설치 화면 보기
                intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=mok.android"));
                startActivity(intent);
                break;
            case 7:     // 동영상 재생
                intent = new Intent(Intent.ACTION_VIEW);
                String video_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/BigBuck.mp4";
                File video_file = new File(video_path);
                Uri video_uri = null;
                //  안드로이드 버전 관리
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    video_uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName()+".fileprovider",video_file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }else {
                    video_uri = Uri.fromFile(video_file);
                }
                intent.setDataAndType(video_uri,"video/*");
                startActivity(intent);
                break;
            case 8:     // 음악 재생
                intent = new Intent(Intent.ACTION_VIEW);
                String audio_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/iu.mp3";
                File audio_file = new File(audio_path);
                Uri audio_uri = null;
                //  안드로이드 버전 관리
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    audio_uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName()+".fileprovider",audio_file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                }else {
                    audio_uri = Uri.fromFile(audio_file);
                }
                //  파일 위치
                System.out.println("[TEST] audio_file : " + audio_file);
                // 파일 위치를 변환해서 보여줌
                System.out.println("[TEST] audio_uri : " + audio_uri);
                // 버전 확인
                System.out.println("[TEST] Build.VERSION.SDK_INT : " + Build.VERSION.SDK_INT);
                intent.setDataAndType(audio_uri,"audio/*");
                startActivity(intent);
                break;

            case 9:     //  시스템 환경 설정 화면 보기
                intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            case 10:    // GPS 설정 화면 보기
                intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                break;
            case 11:    //  WIFI 설정 화면 보기
                intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                startActivity(intent);
                break;
            case 12:    // 카카오톡 실행 시키기
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                // 경고창 안뜨도록 설정
                intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                intent.putExtra(Intent.EXTRA_TEXT, "text");
                // data폴더 -> data폴더
                intent.setPackage("com.kakao.talk");
                startActivity(intent);
                break;
        }

    }
}
