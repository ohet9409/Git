package com.example.prca2;

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
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.prca2.helper.FileHelper;
import com.example.prca2.helper.FileUtils;
import com.example.prca2.helper.PhotoHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonImage, buttonVideo, buttonText, buttonBack2, buttonBack3,buttonBack4;
    LinearLayout layoutMain, layoutImage, layoutVideo, layoutText;
    ImageView imageView;
    TextView textView;
    VideoView videoView;
    // 이미지 사용
    Bitmap bmp;
    // 동영상 사용
    MediaController mc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonImage = findViewById(R.id.buttonImage);
        buttonVideo = findViewById(R.id.buttonVideo);
        buttonText = findViewById(R.id.buttonText);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonBack3 = findViewById(R.id.buttonBack3);
        buttonBack4 = findViewById(R.id.buttonBack4);

        layoutMain = findViewById(R.id.layoutMain);
        layoutImage = findViewById(R.id.layoutImage);
        layoutVideo = findViewById(R.id.layoutVideo);
        layoutText = findViewById(R.id.layoutText);

        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        videoView = findViewById(R.id.videoView);

        buttonImage.setOnClickListener(this);
        buttonVideo.setOnClickListener(this);
        buttonText.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);
        buttonBack4.setOnClickListener(this);

        layoutMain.setVisibility(View.VISIBLE);
        layoutText.setVisibility(View.GONE);;
        layoutVideo.setVisibility(View.GONE);
        layoutImage.setVisibility(View.GONE);

        //  읽어올때는 퍼미션 체크를 해주어야한다.
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        //  갤러리 앱 호출
        Intent intent = null;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);

        switch (v.getId()){
            case R.id.buttonImage:
                intent.setType("image/*");
                startActivityForResult(intent,100);


                break;
            case R.id.buttonVideo:
                intent.setType("video/*");
                startActivityForResult(intent,101);

                break;
            case R.id.buttonText:
                intent.setType("text/*");
                startActivityForResult(intent,102);

                break;
            case R.id.buttonBack2:
                layoutMain.setVisibility(View.VISIBLE);
                layoutText.setVisibility(View.GONE);;
                layoutVideo.setVisibility(View.GONE);
                layoutImage.setVisibility(View.GONE);
                break;
            case R.id.buttonBack3:
                layoutMain.setVisibility(View.VISIBLE);
                layoutText.setVisibility(View.GONE);;
                layoutVideo.setVisibility(View.GONE);
                layoutImage.setVisibility(View.GONE);
                break;
            case R.id.buttonBack4:
                layoutMain.setVisibility(View.VISIBLE);
                layoutText.setVisibility(View.GONE);;
                layoutVideo.setVisibility(View.GONE);
                layoutImage.setVisibility(View.GONE);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            Uri uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);
            switch (requestCode){
                case 100:       // 이미지 파일
                    showImage(filePath);
                    break;
                case 101:       // 동영상 파일
                    showVideo(filePath);
                    break;
                case 102:       // 텍스트 파일
                    showText(filePath);
                    break;
            }
        }
    }

    //  갤러리 앱이 먼저 호출되고 layout을 그 다음에 보여준다.
    private void showImage(String filePath) {
        imageView.setImageBitmap(null);
        if (bmp != null){
            bmp.recycle();
            bmp = null;
        }
        bmp = PhotoHelper.getInstance().getThumb(this, filePath);
        imageView.setImageBitmap(bmp);

        layoutMain.setVisibility(View.GONE);
        layoutText.setVisibility(View.GONE);;
        layoutVideo.setVisibility(View.GONE);
        layoutImage.setVisibility(View.VISIBLE);
    }

    private void showVideo(String filePath) {
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.setVideoPath(filePath);
        videoView.start();

        layoutMain.setVisibility(View.GONE);
        layoutText.setVisibility(View.GONE);;
        layoutVideo.setVisibility(View.VISIBLE);
        layoutImage.setVisibility(View.GONE);
    }

    private void showText(String filePath) {
        String result = FileHelper.getInstance().readString(filePath, "utf-8");
        textView.setText(result);
        layoutMain.setVisibility(View.GONE);
        layoutText.setVisibility(View.VISIBLE);;
        layoutVideo.setVisibility(View.GONE);
        layoutImage.setVisibility(View.GONE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (bmp != null){
            bmp.recycle();
            bmp = null;
        }
    }
}
