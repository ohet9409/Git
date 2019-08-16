package com.example.uiexam1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.uiexam1.adapter.MemberAdapter;
import com.example.uiexam1.model.Member;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Member> list;
    Button button;
    ListView listView;
    MemberAdapter adapter;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        button = findViewById(R.id.button);
        member = (Member) getIntent().getSerializableExtra("member");


        listView = findViewById(R.id.listView);

        list=(ArrayList<Member>) getIntent().getSerializableExtra("list");
        if (list==null){
            list=new ArrayList<>();
        }

        adapter = new MemberAdapter(this, R.layout.list_item, list);
        listView.setAdapter(adapter);

        //list.add(member);


        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this,list.get(0).getAddr(),Toast.LENGTH_SHORT).show();
        finish();
    }
}
