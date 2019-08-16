package com.example.practice4;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class video extends AppCompatActivity {

    // 객체 선언
    VideoView videoView;
    MediaController mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_video);
        // 객체 초기화
        videoView = findViewById(R.id.videoView);
        mc = new MediaController(this);
        // 인텐트 데이터 추출
        String filePath = getIntent().getStringExtra("filePath");
        // 동영상 설정
        videoView.setMediaController(mc);
        videoView.setVideoPath(filePath);
        videoView.start();
    }
}
