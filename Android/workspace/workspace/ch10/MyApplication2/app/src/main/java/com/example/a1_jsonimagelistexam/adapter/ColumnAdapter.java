package com.example.a1_jsonimagelistexam.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1_jsonimagelistexam.R;
import com.example.a1_jsonimagelistexam.model.Column;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

import java.util.List;

public class ColumnAdapter extends ArrayAdapter<Column> {
    //  객체 선언
    Activity activity;              // inflater 객체 얻어오기 위해서
    int resource;                   // list_item.xml 파일의 id를 저장
    ImageLoader imageLoader;        // 서버에 이미지를 요청, 응답 처리를 함께함
    DisplayImageOptions options;    // 이미지로더 옵션 객체

    public ColumnAdapter( Context context, int resource,  List<Column> objects) {
        super(context, resource, objects);
        activity = (Activity) context;
        this.resource = resource;
        //  imageLoader 초기화
        imageLoaderInit();
    }

    //  imageLoader 초기화
    private void imageLoaderInit() {
        imageLoader = imageLoader.getInstance();    // 싱글톤

        if (!imageLoader.isInited()){   // 초기화되어있지 않으면
            ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(activity);
            imageLoader.init(configuration);
        }
        // 이미지로더 옵션 설정
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder();
        //  다운로드될 동안 표시할 임시 이미지
        builder.showImageOnLoading(R.drawable.ic_stub);
        //  이미지가 지정되지 않은 경우 사용될 이미지
        builder.showImageForEmptyUri(R.drawable.ic_empty);
        //  다운로드 실패시에 사용할 이미지
        builder.showImageOnFail(R.drawable.ic_error);
        //  option 만들기
        options = builder.build();

    }


    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
       if (convertView == null){
           convertView = activity.getLayoutInflater().inflate(resource,null);
       }
       Column item = getItem(position);
       if (item != null){
           ImageView imageView = convertView.findViewById(R.id.imageView);
           TextView textView1 = convertView.findViewById(R.id.textView1);
           TextView textView2 = convertView.findViewById(R.id.textView2);

           //   imageView.setImageResource(item.getimg()); // 프로젝트안에 그림이 있을 때
           //   이미지로더로 처리
           //   displayImage(이미지 URL, 이미지뷰 객체, 옵션 설정값)
           //   1. 서버에 이미지 요청
           //   2. 서버에서 온 이미지를 받음
           //   3. 그 이미지를 이미지뷰에 넣어줌
           imageLoader.displayImage(item.getimg(), imageView, options);
           textView1.setText(item.getSubject());
           textView2.setText(item.getContent());
        }
       return convertView;
    }
}
