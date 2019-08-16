package com.example.uiexam1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



import com.example.uiexam1.helper.ObjectInOut;
import com.example.uiexam1.model.Member;


import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, button4;
    ArrayList<Member> list;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);

        member= (Member) getIntent().getSerializableExtra("member");
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        list = (ArrayList<Member>) getIntent().getSerializableExtra("list");
        if (list == null){
            list = new ArrayList<>();
        }
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
        String fname = Environment.getExternalStorageDirectory().getAbsolutePath() + "/abc.txt";
        Intent intent = null;
        switch (v.getId()){
            case R.id.button1:
                intent = new Intent(this,WriteActivity.class);
                intent.putExtra("list",list);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
            case R.id.button2:
                intent = new Intent(this,ListActivity.class);
                intent.putExtra("member",member);
                intent.putExtra("list",list);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
            case R.id.button3:
                //list.add(member);
                list = (ArrayList<Member>) getIntent().getSerializableExtra("list");
                boolean result = ObjectInOut.getInstance().write(fname, list);
                String msg = "";
                if(result) msg = "저장 성공";
                else msg = "저장 실패";
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                break;
            case R.id.button4:
                if (list != null) {
                    list.clear();
                }
                list = ObjectInOut.getInstance().read(fname);
                String msg1 = "";
                if(list.size() > 0) msg1 = "읽기 성공";
                else msg1 = "읽기 실패";
                Toast.makeText(this, msg1, Toast.LENGTH_SHORT).show();
                //Toast.makeText(this,member.getAddr(),Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
