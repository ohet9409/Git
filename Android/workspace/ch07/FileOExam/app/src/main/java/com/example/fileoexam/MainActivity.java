package com.example.fileoexam;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fileoexam.helper.ObjectInOut;
import com.example.fileoexam.model.Student;

import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    EditText editText1, editText2, editText3;
    Button button1, button2, button3, button4;
    TextView textView4;
    List<Student> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  객체 초기화
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        textView4 = findViewById(R.id.textView4);
        list = new ArrayList<>();

        // 이벤트 설정
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        // 퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        String fname = Environment.getExternalStorageDirectory().getAbsolutePath() + "/student.txt";

        switch (v.getId()){
            case R.id.button1:  //  list에 저장
                String name = editText1.getText().toString().trim();
                int age = Integer.parseInt(editText2.getText().toString().trim());
                String addr = editText3.getText().toString().trim();
                list.add(new Student(name,age,addr));

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                break;
            case R.id.button2:  //  list에 저장된 값을 textView로 출력
                String result = "";
                for (int i=0; i<list.size(); i++){
                    Student student = list.get(i);
                    result += student.toString() + "\n";
                }
                textView4.setText(result);
                break;
            case R.id.button3:  //  파일 저장
                boolean result1 = ObjectInOut.getInstance().write(fname, list);
                String msg = "";
                if (result1) msg="저장 성공";
                else msg = "저장 실패";
                Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:  //  파일 읽기
                list.clear();
                list = ObjectInOut.getInstance().read(fname);
                break;
        }
    }
}
