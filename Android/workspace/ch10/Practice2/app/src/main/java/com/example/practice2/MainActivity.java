package com.example.practice2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practice2.adapter.ImageAdapter;
import com.example.practice2.model.Image;
import com.example.practice2.response.ImageResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener {
    // 객체 선언
    List<Image> list;
    ImageAdapter adapter;
    EditText editText;
    Button button;
    ListView listView;
    LinearLayout footer;
    AsyncHttpClient client;
    ImageResponse response;
    // 페이징 처리
    final int PAGE_SIZE=20;
    int PAGE = 1;
    boolean lastItemVisibleFlag = false;
    String keyword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, R.layout.list_item, list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        // list_footer.xml 객체화
        View footerView = getLayoutInflater().inflate(R.layout.list_footer, null);
        footer = footerView.findViewById(R.id.footer);
        footer.setVisibility(View.GONE);
        // listView 설정
        listView.addFooterView(footerView);
        listView.setAdapter(adapter);

        client = new AsyncHttpClient();
        response = new ImageResponse(this, adapter, listView, footer);
        // 이벤트 설정
        button.setOnClickListener(this);
        listView.setOnScrollListener(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        keyword = editText.getText().toString().trim();
        if(keyword.equals("")) {
            Toast.makeText(this, "검색어를 입력하세요.", Toast.LENGTH_SHORT).show();
            return;
        }
        // 신규검색이므로, 설정 초기화
        PAGE = 1;
        adapter.clear();
        getKakaoData(keyword);
    }

    private void getKakaoData(String keyword) {
        RequestParams params = new RequestParams();
        params.put("query", keyword);
        params.put("size", String.valueOf(PAGE_SIZE));
        params.put("page", String.valueOf(PAGE));
        // 헤더 파일에 api 키 추가
        client.addHeader("Authorization", "KakaoAK 8b0faeef1aed07a70718edcc54096f29");
        // 요청
        client.get("https://dapi.kakao.com/v2/search/image", params, response);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag) {
            if(PAGE < Image.pageable_count) {
                PAGE++;
                getKakaoData(keyword);
            }
        }
    }
    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        lastItemVisibleFlag = (totalItemCount > 0) &&
                (firstVisibleItem + visibleItemCount >= totalItemCount);
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Image item = adapter.getItem(position);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
