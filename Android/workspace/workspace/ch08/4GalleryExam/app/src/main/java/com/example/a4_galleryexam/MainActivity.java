package com.example.a4_galleryexam;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.a4_galleryexam.helper.FileUtils;
import com.example.a4_galleryexam.helper.PhotoHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //  객체 선언
    ImageView imageView;
    Button button;
    Bitmap bmp;  //  메모리로 로드한 이미지가 저장될 객체

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
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){

            }else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                //  갤러리를 호출하기 위한 암묵적 임텐트
                Intent intent = null;
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
                    intent = new Intent(Intent.ACTION_GET_CONTENT);
                } else {
                    intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                }
                //  이미지 파일만 필터링 => MIME 형태 (KITKAT 이상 버전용)
                // intent.setType("image/*");
                intent.setType("*/*");  // 모든 파일 선택 가능
                //  구글 클라우드에 싱크된 파일 제외
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                    intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                }
                //  갤러리 실행 요청
                startActivityForResult(intent, 100);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
            if (resultCode == RESULT_OK){
                //  사용자가 선택한 결과값 얻기
                Uri photoUri = data.getData();
                // photoUri = content://com.android.externalstorage.documents/document/primary%3ADCIM%2Fp2019-07-16%2004-19-58.jpg
                Log.d("[INFO]","photoUri = " + photoUri);
                //imageView.setImageURI(photoUri);
                //  파일의 절대경로 얻기
                String filePath = FileUtils.getPath(this, photoUri);
                //  filePath = /storage/emulated/0/DCIM/p2019-07-16 04-13-41.jpg
                Log.d("[INFO]","filePath = " + filePath);
                imageView.setImageBitmap(null);
                if (bmp != null){
                    bmp.recycle();
                    bmp = null;
                }
                bmp = PhotoHelper.getInstance().getThumb(this, filePath);
                imageView.setImageBitmap(bmp);
            }
        }
    }
}
