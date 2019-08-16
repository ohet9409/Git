package com.example.practice4;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.practice4.helper.FileUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        permissionCheck();
    }

    private void permissionCheck() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 100);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Intent intent = null;
        if (Build.VERSION.SDK_INT < 19){
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        switch (item.getItemId()){
            case R.id.image:
                intent.setType("image/*");
                startActivityForResult(intent, 100);
                Toast.makeText(this,"이미지",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.video:
                intent.setType("video/*");
                startActivityForResult(intent, 101);
                Toast.makeText(this,"동영상",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.text:
                intent.setType("text/*");
                startActivityForResult(intent, 102);
                Toast.makeText(this,"텍스트",Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       // Toast.makeText(this,"dudd",Toast.LENGTH_SHORT).show();
        if (resultCode == RESULT_OK){
            Uri uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);
            Log.d("[INFO]", "uri = " + uri);
            Log.d("[INFO]", "filePath = " + filePath);
            Intent intent = null;
            Toast.makeText(this,"" + requestCode,Toast.LENGTH_SHORT).show();
            switch (requestCode) {
                case 100:
                    intent = new Intent(this, image.class);
                    //intent.putExtra("filePath", filePath);
                    intent.setData(uri);
                    startActivity(intent);

                    break;
                case 101:
                    intent = new Intent(this, video.class);
                    intent.putExtra("filePath", filePath);
                    startActivity(intent);
                    break;
                case 102:
                    intent = new Intent(this, text.class);
                    intent.putExtra("filePath", filePath);
                    startActivity(intent);
                    break;
            }
        }
    }
}
