package com.example.practice3;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.practice3.helper.FileUtils;

public class video extends AppCompatActivity  {

    VideoView videoView;
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.videoView);



        Intent intent = null;
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.setType("video/*");
        startActivityForResult(intent,101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            Uri uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);
            showVideo(filePath);
        }
    }

    private void showVideo(String filePath) {
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoPath(filePath);
        videoView.start();
    }


}
