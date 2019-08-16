package com.example.community2;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.community2.model.Community;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ReadActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2, textView3, textView4;
    Button button1, button2, button3;
    ImageLoader imageLoader;
    ImageView imageView;
    DisplayImageOptions options;
    AsyncHttpClient client;
    HttpRespons respons;
    String URL="http://192.168.0.61:8080/miniboard/community/community_select.jsp";
    Community item;
    int seq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        setTitle("상세보기");
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        imageView = findViewById(R.id.imageView);
        client = new AsyncHttpClient();
        respons = new HttpRespons(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        seq = getIntent().getIntExtra("seq",seq);
        item = (Community) getIntent().getSerializableExtra("item");
    }

    @Override
    protected void onResume() {
        super.onResume();
        RequestParams params = new RequestParams();
        params.put("seq",seq);
        client.post(URL,params,respons);
        imageLoderInit();
    }

    class HttpRespons extends AsyncHttpResponseHandler{
        Activity activity;
        ProgressDialog dialog;

        public HttpRespons(Activity activity) {
            this.activity = activity;
        }

        //  통신 시작
        @Override
        public void onStart() {
            dialog = new ProgressDialog(activity);
            dialog.setMessage("잠시만 기다려 주세요.");
            dialog.setCancelable(false);
            dialog.show();
        }

        //  통신 종료
        @Override
        public void onFinish() {
            dialog.dismiss();
            dialog = null;
        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            String strJson = new String(responseBody);
            try {
                JSONObject json = new JSONObject(strJson);
                String rt = json.getString("rt");
                JSONArray item = json.getJSONArray("item");
                if (item.length()>0){
                    JSONObject temp = item.getJSONObject(0);

                    textView1.setText("제목 : " + temp.getString("subject"));
                    textView2.setText("작성자 : " + temp.getString("user_name"));
                    textView3.setText("이메일 : " + temp.getString("email"));
                    textView4.setText("내용 : " + temp.getString("content"));
                    Log.e("[info]",temp.getString("filename"));
                    String filename = temp.getString("filename");
                    imageLoader.displayImage(filename,imageView,options);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            Toast.makeText(activity, "통신실패", Toast.LENGTH_SHORT).show();
            Log.e("[ERROR]",statusCode+"");
        }
    }
    private void imageLoderInit(){
        imageLoader = imageLoader.getInstance();
        if (!imageLoader.isInited()){
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
            imageLoader.init(configuration);
        }
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        builder.showImageOnLoading(R.drawable.ic_stub);                             //  다운로드 할 동안 보여줄 그림
        builder.showImageForEmptyUri(R.drawable.ic_empty);                          //  이미지가 지정되지 않은 경우
        builder.showImageOnFail(R.drawable.ic_error);                               //  다운로드 실패시 보여줄 그림
        //  한번 다운받은 파일을 메모리에 보관할 지 여부
        builder.cacheInMemory(true);
        //  한번 다운받은 파일을 Disk에 보관할 지 여부
        builder.cacheOnDisk(true);
        //  Exif 정보를 유지할 지 여부
        builder.considerExifParams(true);
        options = builder.build();
    }
    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()){
            case R.id.button1:  // 삭제하기
                intent= new Intent(this, DeleteActivity.class);
                intent.putExtra("seq", seq);
                startActivity(intent);
                break;
            case R.id.button2:  // 수정하기
                intent = new Intent(this,EditActivity.class);
                intent.putExtra("subject",textView1.getText().toString());
                intent.putExtra("user_name",textView2.getText().toString());
                intent.putExtra("email",textView3.getText().toString());
                intent.putExtra("content",textView4.getText().toString());
                intent.putExtra("seq",seq);
                intent.putExtra("item",item);
                startActivity(intent);
                break;
            case R.id.button3:
                finish();
                break;
        }
    }
}
