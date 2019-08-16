package com.example.practice3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonImage, buttonVideo, buttonText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonImage = findViewById(R.id.buttonImage);
        buttonVideo = findViewById(R.id.buttonVideo);
        buttonText = findViewById(R.id.buttonText);

        buttonImage.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);
        buttonText.setOnClickListener(this);

        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.buttonImage:
                intent = new Intent(this, Image.class);
                startActivity(intent);
                break;
            case R.id.buttonVideo:
                intent = new Intent(this, video.class);
                startActivity(intent);
                break;
            case R.id.buttonText:
                intent = new Intent(this, text.class);
                startActivity(intent);
                break;
        }
    }
}
