package com.example.practice3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice3.model.Local;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2, textView3;
    Button button;
    String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        button = findViewById(R.id.button);
        Local item = (Local) getIntent().getSerializableExtra("item");
        URL = item.getPlace_url();
        textView1.setText(item.getPlace_name());
        textView2.setText(item.getPhone());
        textView3.setText(item.getAddress_name());
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        startActivity(intent);
    }
}
