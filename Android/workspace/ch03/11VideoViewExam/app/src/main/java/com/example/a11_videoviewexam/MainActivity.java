package com.example.a11_videoviewexam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

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
        // 퍼미션이 등록되었는지 확인
        if (permissionCK) startVideo();
    }


    // 퍼미션 체크 : 사용자에게 하드웨어 기능을 사용할 지 허락을 얻는 것
    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED) {
            // 퍼미션을 등록할 것인지 확인, 다이얼로그 창으로 물어봄
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                Toast.makeText(this,"test1",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"test2",Toast.LENGTH_SHORT).show();
                // 퍼미션을 시스템에 등록할 지 여부를 확인한다. (마시멜로우 버전 이상)
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
            }
        } else {
            // 퍼미션이 시스템에 이미 등록되어 있다.
            permissionCK = true;
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case  MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startVideo();;
                } else {
                    Toast.makeText(this, " 동영상을 실행할 수가 없습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void  startVideo() {
        // SD카드의 경로를 문자열로 얻는다. (내부저장소)
        File sdcard = Environment.getExternalStorageDirectory();
        // SD카드의 절대경로에 동영상 파일 경로를 덧붙인다.
        //  sdcard.getAbsolutePath() : 절대경로
        //String video_path = sdcard.getAbsolutePath() + "/BigBuck.mp4";
        String video_path = sdcard.getAbsolutePath() + "/BigBuck.mp4";
        //  비디오뷰에 재생할 파일의 경로를 지정한다.
        videoView.setVideoPath(video_path);

        //  온라인 상의 동영상 재생하기
        //videoView.setVideoURI(Uri.parse("http://media.w3.org/2010/05/bunny/movie.mp4"));

        // 재생 시작
        videoView.start();
    }
}
