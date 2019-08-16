package com.example.community2;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
import android.widget.EditText;
import android.widget.Toast;

import com.example.community2.helper.FileUtils;
import com.example.community2.helper.PhotoHelper;
import com.example.community2.helper.RegexHelper;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;

import cz.msebera.android.httpclient.Header;

public class WriteActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editText1, editText2, editText3, editText4, editText5;
    Button button1, button2, button3;
    AsyncHttpClient client;
    HttpResponse response;
    String filePath;
    String URL ="http://192.168.0.61:8080/miniboard/community/community_insert.jsp";
    Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        setTitle("글쓰기");
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        client = new AsyncHttpClient();
        response = new HttpResponse(this);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }


    class HttpResponse extends AsyncHttpResponseHandler{
        Activity activity;
        ProgressDialog dialog;

        public HttpResponse(Activity activity) {
            this.activity = activity;
        }

        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog = null;
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String strJson = new String(responseBody);
            try {
                JSONObject jsonObject = new JSONObject(strJson);
                String rt = jsonObject.getString("rt");
                if (rt.equals("OK")) {
                    Toast.makeText(activity, "저장 성공", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(activity, "저장 실패", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(WriteActivity.this, "통신실패", Toast.LENGTH_SHORT).show();
            Log.e("[ERROR]",statusCode+"");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100){
            if (resultCode == RESULT_OK){
                //  사용자가 선택한 결과값 얻기
                Uri photoUri = data.getData();
                // photoUri = content://com.android.externalstorage.documents/document/primary%3ADCIM%2Fp2019-07-16%2004-19-58.jpg
                //Log.d("[INFO]","photoUri = " + photoUri);
                //imageView.setImageURI(photoUri);
                //  파일의 절대경로 얻기
                filePath = FileUtils.getPath(this, photoUri);
                //  filePath = /storage/emulated/0/DCIM/p2019-07-16 04-13-41.jpg
                Log.e("[INFO]","filePath = " + filePath);

            }
        }
        if (requestCode == 200){
            // if (resultCode == RESULT_OK){
            //  촬영 결과물을 갤러리에 등록한다.
            Intent photoIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + filePath));
            sendBroadcast(photoIntent);

            /* ImageView에 사진 출력 */
            //  기존에 표시되던 이미지 제거

            //  그림이 저장된 Bitmap객체가 존재한다면, 메모리 해제
            //  Bitmap은 gc의 수집 대상이 아니므로, 반드시 메모리 해제를 위해서 recycle()을 호출해야 한다.
            if (bmp != null){
                bmp.recycle();
                bmp = null;
            }
            //  썸네일 이미지 얻기
            bmp = PhotoHelper.getInstance().getThumb(this, filePath);

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                showListDialog();
                break;
            case R.id.button2:
                String user_name = editText1.getText().toString().trim();
                String user_pwd = editText2.getText().toString().trim();
                String email = editText3.getText().toString().trim();
                String subject = editText4.getText().toString().trim();
                String content = editText5.getText().toString().trim();

                RegexHelper regexHelper = RegexHelper.getInstance();
                String msg = null;
                //  입력값 검사
                if (msg == null && !regexHelper.isValue(user_name)){
                    msg = "이름을 입력하세요";
                } else if (msg == null && !regexHelper.isValue(user_pwd)){
                    msg = "비밀번호를 입력하세요";
                } else if (msg == null && !regexHelper.isValue(email)){
                    msg = "이메일을 입력하세요";
                } else if (msg == null && !regexHelper.isEmail(email)){
                    msg = "이메일이 형식에 맞지 않습니다.";
                } else if (msg == null && !regexHelper.isValue(subject)){
                    msg = "제목을 입력하세요";
                } else if (msg == null && !regexHelper.isValue(content)){
                    msg = "내용을 입력하세요";
                }
                //  에러가 검출되면 메시지 출력후, 실행 종료
                if (msg != null){
                    Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
                    return;
                }
                // 입력값이 있으면, 서버로 데이터 전송 및 요청
                RequestParams params = new RequestParams();
                params.put("user_name",user_name);
                params.put("user_pwd",user_pwd);
                params.put("email",email);
                params.put("subject",subject);
                params.put("content",content);
                try {
                    params.put("photo",new File(filePath));
                    Log.e("[info]",filePath);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                client.post(URL,params,response);
                break;
            case R.id.button3:
                finish();
                break;
        }
    }
    private void showListDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        final String[] items ={"새로 촬영하기", "갤러리에서 가져오기"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which ==0){
                    Log.e("[info] which",which+"");
                    filePath = PhotoHelper.getInstance().getNewPhotoPath();
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File file = new File(filePath);
                    Uri uri = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                        uri = FileProvider.getUriForFile(WriteActivity.this,getApplicationContext().getPackageName()+
                                ".fileprovider",file);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    } else {
                        uri = Uri.fromFile(file);
                    }
                    Log.e("[INFO]", "uri = " + uri);
                    //  저장될 경로를 파라미터로 설정
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    intent.putExtra(AUDIO_SERVICE, false);  // 소리는 저장하지 않음
                    //  카메라 앱 호출
                    startActivityForResult(intent, 200);
                } else {
                    Log.e("[info] which",which+"");
                    Intent intent = null;
                    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
                        intent = new Intent(Intent.ACTION_GET_CONTENT);
                    } else {
                        intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                        intent.addCategory(Intent.CATEGORY_OPENABLE);
                    }
                    intent.setType("image/*");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB){
                        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
                    }
                    startActivityForResult(intent,100);
                }
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
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
