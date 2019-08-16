package com.example.myapplication4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication4.model.Inform;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    TextView textView1, textView2, textView3;
    Button button;
    Inform item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //  객체 초기화
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);

        //  이벤트 설정
        button.setOnClickListener(this);
        //  화면 설정
        //  인텐트에서 데이터 꺼내기
        item = (Inform) getIntent().getSerializableExtra("item");
        textView1.setText(item.getPlace_name());
        textView2.setText(item.getPhone());
        textView3.setText(item.getRoad_address_name());
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getPlace_url()));
        startActivity(intent);
    }
}
