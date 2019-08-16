package com.example.uiexam1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.uiexam1.adapter.MemberAdapter;
import com.example.uiexam1.helper.RegexHelper;
import com.example.uiexam1.model.Member;

import java.util.ArrayList;
import java.util.List;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2;
    EditText editText1,editText2,editText3,editText4;
    ArrayList<Member> list;
    MemberAdapter adapter;
    Member member = new Member();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        //list = new ArrayList<>();
        //adapter = new MemberAdapter(this,R.layout.list_item,list);

        list = (ArrayList<Member>) getIntent().getSerializableExtra("list");
        if (list == null){
            list = new ArrayList<>();
        }
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button1:
                RegexHelper regexHelper = RegexHelper.getInstance();
                String msg = null;
                //  입력값 검사
                if (msg == null && !regexHelper.isValue(editText1.getText().toString())){
                    msg = "이름을 입력하세요";
                } else if (msg == null && !regexHelper.isValue(editText2.getText().toString())){
                    msg = "이메일을 입력하세요";
                } else if (msg == null && !regexHelper.isEmail(editText2.getText().toString().trim())) {
                    msg = "이메일이 형식에 맞지 않습니다.";
                }else if (msg == null && !regexHelper.isValue(editText3.getText().toString())){
                    msg = "전화번호를 입력하세요";
                }  else if (msg == null && !regexHelper.isValue(editText4.getText().toString())) {
                    msg = "주소를 입력하세요.";
                }//  에러가 검출되면 메시지 출력후, 실행 종료
                if (msg != null){
                    Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
                    return;
                }

                String name = editText1.getText().toString().trim();
                String email = editText2.getText().toString().trim();
                String phone = editText3.getText().toString().trim();
                String addr = editText4.getText().toString().trim();
                list.add(new Member(name, email, phone, addr));

                Toast.makeText(this,"입력완료",Toast.LENGTH_SHORT).show();

            break;
            case R.id.button2:
                Intent intent = new Intent(this,MainActivity.class);
                //intent.putExtra("member",member);
                intent.putExtra("list",list);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
                break;
        }
    }
}
