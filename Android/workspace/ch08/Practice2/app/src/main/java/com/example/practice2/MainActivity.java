package com.example.practice2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.practice2.helper.FileUtils;
import com.example.practice2.helper.PhotoHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1, button2, button3, buttonBack;
    ImageView imageView;
    VideoView videoView;
    MediaController mediaController;
    final  int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE =100;
    boolean permissionCK = false;
    TextView textView;
    LinearLayout mainLayout, imageLayout, videoLayout, textLayout;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        buttonBack = findViewById(R.id.buttonBack);


        imageView = findViewById(R.id.imageView);
        videoView = findViewById(R.id.videoView);
        textView = findViewById(R.id.textView);

        mainLayout = findViewById(R.id.mainLayout);
        imageLayout = findViewById(R.id.imageLayout);
        videoLayout = findViewById(R.id.videoLayout);
        textLayout = findViewById(R.id.textLayout);

        mainLayout.setVisibility(View.VISIBLE);
        imageLayout.setVisibility(View.GONE);
        videoLayout.setVisibility(View.GONE);
        textLayout.setVisibility(View.GONE);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        
        mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        
        permissionCheck();
        if (permissionCK) startVideo();
    }

    private void startVideo() {
    }


    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.button1 :
                
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                } else {
                    intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                }
                intent.setType("image/*");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                }
                startActivityForResult(intent, 100);
                mainLayout.setVisibility(View.GONE);
                imageLayout.setVisibility(View.VISIBLE);
                videoLayout.setVisibility(View.GONE);
                textLayout.setVisibility(View.GONE);
                break;
            case R.id.button2 :
                
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                } else {
                    intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                }
                intent.setType("video/*");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                }
                startActivityForResult(intent, 100);
                videoView.start();
                mainLayout.setVisibility(View.GONE);
                imageLayout.setVisibility(View.GONE);
                videoLayout.setVisibility(View.VISIBLE);
                textLayout.setVisibility(View.GONE);
                break;
            case R.id.button3 :
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                } else {
                    intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                }
                intent.setType("text/*");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
                }
                startActivityForResult(intent, 100);
                mainLayout.setVisibility(View.GONE);
                imageLayout.setVisibility(View.GONE);
                videoLayout.setVisibility(View.GONE);
                textLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonBack :
                mainLayout.setVisibility(View.VISIBLE);
                imageLayout.setVisibility(View.GONE);
                videoLayout.setVisibility(View.GONE);
                textLayout.setVisibility(View.GONE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
            if (resultCode == RESULT_OK){
                Uri photoUri = data.getData();
                String filePath = FileUtils.getPath(this, photoUri);
                imageView.setImageBitmap(null);
                videoView.setVideoPath(filePath);
                if(bmp != null){
                    bmp.recycle();
                    bmp = null;
                }
                bmp = PhotoHelper.getInstance().getThumb(this, filePath);
                imageView.setImageBitmap(bmp);
            }
        }
    }
    
}
