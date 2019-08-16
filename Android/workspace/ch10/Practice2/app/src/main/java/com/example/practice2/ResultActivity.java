package com.example.practice2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.practice2.model.Image;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    Button button;
    ImageView imageView;
    Image item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        // 객체 초기화
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        // 인텐트에 저장된 데이터 꺼내기
        item = (Image) getIntent().getSerializableExtra("item");
        // 화면설정
        ImageLoader.getInstance().displayImage(item.getImage_url(), imageView);
        // 이벤트 설정
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // 웹브라우저 호출
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getDoc_url()));
        startActivity(intent);
    }
}
