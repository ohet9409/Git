package com.example.practice1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practice1.helper.ObjectInOut;
import com.example.practice1.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4, button5, button6, button7;
    EditText editText1, editText2, editText3, editText4;
    TextView textView7;
    LinearLayout layout1, layout2, layout3;
    List<Student> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        textView7 = findViewById(R.id.textView7);
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        list = new ArrayList<>();

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);
        layout3.setVisibility(View.GONE);

        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        String fname = Environment.getExternalStorageDirectory().getAbsolutePath()+"/student1.txt";
        switch (v.getId()){
            case R.id.button1:
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.GONE);
                break;
            case R.id.button2:
                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.GONE);
                layout3.setVisibility(View.VISIBLE);
                String result = "";
                for (int i=0; i<list.size(); i++){
                    Student student = list.get(i);
                    result += student.toString() + "\n";
                }
                textView7.setText(result);
                break;
            case R.id.button3:
                boolean result1 = ObjectInOut.getInstance().write(fname, list);
                String msg ="";
                if (result1) msg = "저장 성공";
                else msg = "저장 실패";
                Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                list.clear();
                list = ObjectInOut.getInstance().read(fname);
                break;
            case R.id.button5:
                String name = editText1.getText().toString().trim();
                String email = editText2.getText().toString().trim();
                String tel = editText3.getText().toString().trim();
                String addr = editText4.getText().toString().trim();
                list.add(new Student(name, email, tel, addr));

                break;
            case R.id.button6:
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                layout3.setVisibility(View.GONE);

                break;
            case R.id.button7:
                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                layout3.setVisibility(View.GONE);
                break;
        }
    }
}
