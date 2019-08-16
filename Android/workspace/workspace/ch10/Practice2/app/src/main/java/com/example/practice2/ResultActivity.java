package com.example.practice2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.practice2.model.Image;
import com.nostra13.universalimageloader.core.ImageLoader;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    ImageView imageView;
    String URL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        Image item = (Image) getIntent().getSerializableExtra("item");
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.displayImage(item.getImage_url(),imageView);
        URL = item.getDoc_url();
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
        startActivity(intent);
    }
}
