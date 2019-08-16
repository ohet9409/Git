package com.example.a1_textviewexam;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 1. 사용할 컴포넌트에 대한 객체 선언
    // 변수이름을 해당 id와 같게
    TextView textView3;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 2. 메모리에 만들어져 있는 객체 찾아오기
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);

        // 3. 글자 수정하기
        textView3.setText("안녕하세요. 안드로이드");
        textView4.setText("string.xml 파일에 내용을 기록합니다.");

        // 4. 글자 색 지정하기
        int color = Color.rgb(255,0,0);
        textView3.setTextColor(color);

        // 저장된 xml값을 받아오기 위한 준비: res에 있는 값을 사용할 수 있다.
        Resources resources = getResources();
        int color2 = resources.getColor(R.color.my_blue);
        textView4.setTextColor(color2);

        // 5. 배경 색 지정하기
        textView3.setBackgroundColor(Color.rgb(255,255,0));
        textView4.setBackgroundColor(resources.getColor(R.color.my_orange));

        // 6. 글자 크기 속성
        textView3.setTextSize(30);
        float size = resources.getDimension(R.dimen.my_size);
        // textView4.setText(String.valueOf(size));
        // textView4.setText(size + "");
        textView4.setTextSize(size/2.5f);

        // 7. single line 속성
        textView4.setSingleLine(true);
        textView4.setEllipsize(TextUtils.TruncateAt.MIDDLE);
    }
}
