package com.example.a3_cameraexam;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a3_cameraexam.helper.PhotoHelper;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    ImageView imageView;
    String photoPath = null;  // 촬영 결과물이 저장될 경로
    Button button;
    Bitmap bmp;          // 메모리에 로드한 이미지를 저장할 객체
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  객체 초기화
        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        //  이벤트 설정
        button.setOnClickListener(this);
        //  퍼미션 체크
        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)){

                }else{
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
                }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //  저장될 사진 경로
                //  photoPath = /storage/emulated/0/DCIM/p2019-07-16 03-35-11.jpg
                photoPath = PhotoHelper.getInstance().getNewPhotoPath();
                /* 카메라 내장 앱 사용 */
                //  액션 + Uri
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = new File(photoPath);
                Uri uri = null;

                // 안드로이드 버전 관리
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    uri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName()+
                            ".fileprovider",file);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                    intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                } else {
                    uri = Uri.fromFile(file);
                }
                Log.d("[INFO]", "uri = " + uri);
                //  저장될 경로를 파라미터로 설정
                intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                intent.putExtra(AUDIO_SERVICE, false);  // 소리는 저장하지 않음
                //  카메라 앱 호출
                startActivityForResult(intent, 100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
           // if (resultCode == RESULT_OK){
                //  촬영 결과물을 갤러리에 등록한다.
                Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + photoPath));
                sendBroadcast(photoIntent);

                /* ImageView에 사진 출력 */
                //  기존에 표시되던 이미지 제거
                imageView.setImageBitmap(null);
                //  그림이 저장된 Bitmap객체가 존재한다면, 메모리 해제
                //  Bitmap은 gc의 수집 대상이 아니므로, 반드시 메모리 해제를 위해서 recycle()을 호출해야 한다.
                if (bmp != null){
                    bmp.recycle();
                    bmp = null;
                }
                //  썸네일 이미지 얻기
                bmp = PhotoHelper.getInstance().getThumb(this, photoPath);
                //  ImageView 출력
                imageView.setImageBitmap(bmp);
     //       }
        }
    }
    //  bmp 객체는 App이 종료되어도 메모리에 여전히 남아 있기 때문에,
    //  App 종료시에 강제로 메모리에서 해제시켜야 한다.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bmp != null){
            bmp.recycle();
            bmp = null;
        }
    }
}
