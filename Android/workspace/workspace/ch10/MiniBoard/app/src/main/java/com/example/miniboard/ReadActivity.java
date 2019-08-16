package com.example.miniboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miniboard.model.Community;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button buttonDel, buttonMod;
    Community item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        textView = findViewById(R.id.textView);
        buttonDel = findViewById(R.id.buttonDel);
        buttonMod = findViewById(R.id.buttonMod);

        buttonDel.setOnClickListener(this);
        buttonMod.setOnClickListener(this);

        item = (Community)getIntent().getSerializableExtra("item");
        String result = item.getSubject()+"\n"+item.getUser_name()+"\n"+item.getEmail()+"\n"+item.getContent();
        Log.d("[INFO]",item.getContent());
        textView.setText(result);
    }
    @Override
    public void onBackPressed() {
        Log.e("[INFO]","뒤로가기");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()){
            case R.id.buttonDel:
                intent = new Intent(this,DeleteActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
                finish();
                break;
            case R.id.buttonMod:
                intent = new Intent(this, EditActivity.class);
                intent.putExtra("item",item);
                startActivity(intent);
                finish();
                break;
        }
    }
}
