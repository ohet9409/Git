package com.example.a4_listitemcheckexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a4_listitemcheckexam.adapter.FlowerAdapter;
import com.example.a4_listitemcheckexam.model.Flower;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    // 객체선언
    List<Flower> list;
    FlowerAdapter adapter;
    Button button;
    ListView listView;
    LinearLayout layout1, layout2;
    TextView textView1, textView2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        list = new ArrayList<>();
        adapter = new FlowerAdapter(this,R.layout.list_item,list);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        imageView = findViewById(R.id.imageView);

        // listView 설정
        listView.setAdapter(adapter);
        // 화면 초기화
        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);
        // 데이터 저장
        addData();
        // 이벤트 설정
        listView.setOnItemClickListener(this);
        button.setOnClickListener(this);
        layout2.setOnClickListener(this);
    }

    private void addData() {
        //adapter.add(new Flower("제목", "내용", R.drawable.flower01, false));
        adapter.add(new Flower("고구마꽃",
                "행운", R.drawable.flower01, false));
        adapter.add(new Flower("국화꽃",
                "성실, 청초, 고상함 [빨강,자홍색]사랑, [흰색]순결 [황색]질투", R.drawable.flower02, false));
        adapter.add(new Flower("대나무꽃",
                "지조, 인내, 절개, 절정", R.drawable.flower03, false));
        adapter.add(new Flower("동자꽃",
                "기다림", R.drawable.flower04, false));
        adapter.add(new Flower("백합꽃",
                "[빨간색] 열정, 깨끗함, [주황색] 명랑한 사랑, [노란색] 유쾌, [분홍색] 사랑의 맹세, [흰색] 순수한 사랑, 순결",
                R.drawable.flower05, false));
        adapter.add(new Flower("소나무꽃",
                "불로장수, 불로장생, 용감", R.drawable.flower06, false));
        adapter.add(new Flower("솔체꽃",
                "이루어 질 수없는 사랑", R.drawable.flower07, false));
        adapter.add(new Flower("양귀비꽃",
                "[빨강]위로, [흰색]망각", R.drawable.flower08, false));
        adapter.add(new Flower("은방울꽃",
                "섬세함", R.drawable.flower09, false));
        adapter.add(new Flower("장미",
                "[노랑색]질투, 완벽한 성취, [흰색] 순결, 순진, 매력, [빨강색] 욕망, 열정, 기쁨, [파랑색] 기적, [핑크색] 맹세, 행복한 사랑",
                R.drawable.flower10, false));
        adapter.add(new Flower("찔레꽃",
                "고독, 신중한 사랑, 가족에 대한 그리움", R.drawable.flower11, false));
        adapter.add(new Flower("투구꽃",
                "밤의 열림", R.drawable.flower12, false));
        adapter.add(new Flower("해바라기",
                "애모, 아름다운 빛, 그리움, 기다림, 숭배", R.drawable.flower13, false));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                String result = "";     //  결과값 생성용 변수
                //  List 클래스 안의 모든 객체를 스캔하여 체크 상태의 값을 확인한다.
                for (int i=0; i<adapter.getCount(); i++){
                    Flower item = adapter.getItem(i);
                    //isCheck() : 체크박스의 getter
                    if (item.isCheck()){
                        result += item.getTitle() + "\n";
                    }

                }
                //  결과 출력
                Toast.makeText(this, result,Toast.LENGTH_LONG).show();
                break;
            case R.id.layout2:
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Flower item = adapter.getItem(position);
        textView1.setText(item.getTitle());
        textView2.setText(item.getDescription());
        imageView.setImageResource(item.getImage());

        layout1.setVisibility(View.GONE);
        layout2.setVisibility(View.VISIBLE);
  //      String  result = item.getTitle() + "\n" + item.getDescription();
   //     Toast.makeText(this,result,Toast.LENGTH_LONG).show();
    }
}
