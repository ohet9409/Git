package com.example.practice3;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.practice3.helper.FileUtils;
import com.example.practice3.helper.PhotoHelper;

public class Image extends AppCompatActivity implements View.OnClickListener {
    Button buttonBack2;
    ImageView imageView;
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        buttonBack2 = findViewById(R.id.buttonBack2);
        imageView = findViewById(R.id.imageView);

        buttonBack2.setOnClickListener(this);


        Intent intent = null;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        intent.setType("image/*");
        startActivityForResult(intent, 100);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            Uri uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);

            imageView.setImageBitmap(null);
            if (bmp != null){
                bmp.recycle();
                bmp = null;
            }
            bmp = PhotoHelper.getInstance().getThumb(this, filePath);
            imageView.setImageBitmap(bmp);

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if(bmp != null){
            bmp.recycle();
            bmp=null;
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.buttonBack2:
                finish();
                break;
        }
    }
}
