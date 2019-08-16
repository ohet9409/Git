package com.example.a6_dinamiclistitemexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.a6_dinamiclistitemexam.adapter.ItemAdapter;
import com.example.a6_dinamiclistitemexam.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    //  객체  선언
    EditText editText;
    Button button;
    ListView listView;
    List<Item> list;
    ItemAdapter adapter;
    //  일렬번호를 처리하기 위한 전역변수
    int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        list = new ArrayList<>();
        adapter = new ItemAdapter(this,R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        //  listView 설정
        listView.setAdapter(adapter);
        //  이벤트 설정
        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String input = editText.getText().toString().trim();
        num++;
        Item item = new Item(num, input);
        //  사용자가 최신 입력한 내용이 항상 ListView의 첫번째 항목에 출력
       // adapter.insert(item, 0);
        adapter.add(item);
        //  EditText에 입력된 내용 삭제
        editText.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
