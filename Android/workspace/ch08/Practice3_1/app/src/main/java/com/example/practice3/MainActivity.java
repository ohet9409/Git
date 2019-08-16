package com.example.practice3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.practice3.helper.FileUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //객체 선언
    Button buttonImage, buttonVideo, buttonText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        buttonImage = findViewById(R.id.buttonImage);
        buttonVideo = findViewById(R.id.buttonVideo);
        buttonText = findViewById(R.id.buttonText);
        // 이벤트 설정
        buttonImage.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);
        buttonText.setOnClickListener(this);
        // 퍼미션 체크
        permissionCheck();
    }
    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        if(Build.VERSION.SDK_INT < 19) {
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        switch (v.getId()) {
            case R.id.buttonImage:
                intent.setType("image/*");
                startActivityForResult(intent, 100);
            break;
            case R.id.buttonVideo:
                intent.setType("video/*");
                startActivityForResult(intent, 101);
                break;
            case R.id.buttonText:
                intent.setType("text/*");
                startActivityForResult(intent, 102);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK) {
            Uri uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);
            Log.d("[INFO]", "uri = " + uri);
            Log.d("[INFO]", "filePath = " + filePath);

            Intent intent = null;
            switch (requestCode) {
                case 100:
                    intent = new Intent(this, ImageActivity.class);
                    //intent.putExtra("filePath", filePath);
                    intent.setData(uri);
                    startActivity(intent);
                    break;
                case 101:
                    intent = new Intent(this, VideoActivity.class);
                    intent.putExtra("filePath", filePath);
                    startActivity(intent);
                    break;
                case 102:
                    intent = new Intent(this, TextActivity.class);
                    intent.putExtra("filePath", filePath);
                    startActivity(intent);
                    break;
            }
        }
    }
}
