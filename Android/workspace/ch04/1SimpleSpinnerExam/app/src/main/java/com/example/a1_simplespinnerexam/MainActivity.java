package com.example.a1_simplespinnerexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//  1. 리스너 설정
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    //  2. 객체 선언
    Spinner spinner;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  3. 객체 초기화
        spinner = findViewById(R.id.spinner);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        // 특정 항목을 선택하도록 설정
        spinner.setSelection(1);

        //  4. 이벤트 설정
        spinner.setOnItemSelectedListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // spinner의 선택된 위치 가져오기
        //int selectedIndex = spinner.getSelectedItemPosition();
        // 리소스 배열 가져오기
        //String[] data = getResources().getStringArray(R.array.spinner_data);
        //Toast.makeText(this,data[selectedIndex],Toast.LENGTH_SHORT).show();
        String item = (String) spinner.getSelectedItem();
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show();
    }

    /**
     * Spinner의 항목이 선택되었을 경우 호출된다.
     * @param parent    : spinner 객체
     * @param view      : 선택된 위치를 구성하는 View : 한줄 표시하는 객체
     * @param position  : 선택된 위치에 대한 인덱스
     * @param id        : 선택된 위치에 대한 인덱스
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spinner:
                String selected = (String) parent.getSelectedItem();
                //String result = position + "번째 항목 >> " + selected;
                String result = id + "번째 항목 >> " + selected;
                textView.setText(result);
                break;
        }
        //Toast.makeText(this,"onItemSelected",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this,"onNothingSelected",Toast.LENGTH_SHORT).show();
    }
}
