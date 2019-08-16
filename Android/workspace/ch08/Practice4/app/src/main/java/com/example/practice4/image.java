package com.example.practice4;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class image extends AppCompatActivity implements View.OnClickListener {

    // 객체 선언
    ImageView imageView;
    Button buttonBack;
    Bitmap bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        // 객체 초기화
        imageView = findViewById(R.id.imageView);
        buttonBack = findViewById(R.id.buttonBack);
        // 이벤트 설정
        buttonBack.setOnClickListener(this);
        // 인텐트에서 데이터 추출
        //String filePath = getIntent().getStringExtra("filePath");
        Uri uri = getIntent().getData();
        // 화면 설정
        //bmp = PhotoHelper.getInstance().getThumb(this, filePath);
        //imageView.setImageBitmap(bmp);
        imageView.setImageURI(uri);
    }
    @Override
    public void onClick(View v) {
        finish();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bmp != null) {
            bmp.recycle();
            bmp = null;
        }
    }
}
