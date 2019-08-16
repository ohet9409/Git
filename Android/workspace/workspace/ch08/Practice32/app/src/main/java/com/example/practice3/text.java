package com.example.practice3;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.practice3.helper.FileHelper;
import com.example.practice3.helper.FileUtils;

public class text extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        button = findViewById(R.id.buttonBack4);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(this);
        Intent intent = null;
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
            intent = new Intent(Intent.ACTION_GET_CONTENT);
        } else {
            intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
            intent.addCategory(Intent.CATEGORY_OPENABLE);
        }
        intent.putExtra(Intent.EXTRA_LOCAL_ONLY, true);
        intent.setType("text/*");
        startActivityForResult(intent, 102);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK){
            Uri uri = data.getData();
            String filePath = FileUtils.getPath(this, uri);
            showText(filePath);
        }
    }

    private void showText(String filePath) {
        String result = FileHelper.getInstance().readString(filePath,"utf-8");
        textView.setText(result);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonBack4:
                finish();

                break;
        }
    }
}
