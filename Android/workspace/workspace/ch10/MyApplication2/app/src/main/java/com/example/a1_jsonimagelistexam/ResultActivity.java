package com.example.a1_jsonimagelistexam;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1_jsonimagelistexam.model.Column;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ResultActivity extends AppCompatActivity {
    TextView textView1, textView2;
    ImageView imageView;
    ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //  Intent에서 데이터 꺼내기
        Intent fromIntent = getIntent();
        Column item = (Column) fromIntent.getSerializableExtra("item");
        ImageLoader imageLoader = ImageLoader.getInstance();
        String subject = item.getSubject();
        String content = item.getContent();
        String img = item.getimg();
        //  객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);
        // 화면 설정
        textView1.setText("꽃 이름 : " + subject);
        textView2.setText("꽃 말 : " + content);
        //   imageView.setImageResource(item.getimg()); // 프로젝트안에 그림이 있을 때
        //   이미지로더로 처리
        //   displayImage(이미지 URL, 이미지뷰 객체, 옵션 설정값)
        //   1. 서버에 이미지 요청
        //   2. 서버에서 온 이미지를 받음
        //   3. 그 이미지를 이미지뷰에 넣어줌
        imageLoader.displayImage(img,imageView);
    }
}
