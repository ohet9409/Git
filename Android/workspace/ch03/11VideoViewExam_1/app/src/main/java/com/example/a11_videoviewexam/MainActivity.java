package com.example.a11_videoviewexam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    // 변수 선언
    VideoView videoView;
    // 재생버튼, 뒤로, 다음, 슬라이더바 등을 가지고 있는 콘트롤로
    MediaController mediaController;
    // 퍼미션 체크 확인용
    final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100;
    boolean permissionCK = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 타이틀바 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        setContentView(R.layout.activity_main);
        // 객체 초기화
        videoView = findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        // 비디오뷰에 컨트롤러를 연결한다.
        videoView.setMediaController(mediaController);
        // 퍼미션 체크를 먼저 해야한다.
        permissionCheck();
        // 퍼미션이 등록되었는 지 확인
        if(permissionCK) startVideo();
    }
    // 퍼미션 체크 : 사용자에게 하드웨어 기능을 사용할 지 허락을 얻는 것
    private void permissionCheck() {
        // 퍼미션이 시스템에 등록되어 있는 지 확인
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 퍼미션을 등록할 것인지 확인, 다이얼로그 창으로 물어봄
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                // 퍼미션을 시스템에 등록할 지 여부를 확인한다. (마시멜로 버전 이상)
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        } else {    // 퍼미션이 시스템에 이미 등록되어 있다.
            permissionCK = true;
        }
    }

    private void startVideo() {}
}
