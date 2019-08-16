package com.example.practice2;

import android.app.AlertDialog;
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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AbsListView.OnScrollListener , AdapterView.OnItemClickListener {
    List<Image> list;
    ImageAdapter adapter;
    EditText editText;
    Button button;
    ListView listView;
    LinearLayout footer;
    AsyncHttpClient client;
    ImageResponse response;
    public final int PAGE_SIZE =20;     // 최대 80개까지 가능
    public static int PAGE = 1;
    boolean lastItemVisibleFlag = false;
    String keyword = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, R.layout.list_item,list);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);
        View footerView = getLayoutInflater().inflate(R.layout.list_footer,null);
        footer = footerView.findViewById(R.id.footer);
        footer.setVisibility(View.GONE);

        client = new AsyncHttpClient();
        response = new ImageResponse(this, adapter,listView,footer);

        listView.addFooterView(footerView);
        listView.setAdapter(adapter);

        button.setOnClickListener(this);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }

    @Override
    public void onClick(View v) {
        keyword = editText.getText().toString().trim();
        if (keyword.equals("")){
            Toast.makeText(this,"검색어를 입력하세요",Toast.LENGTH_SHORT).show();
            return;
        }
        PAGE =1;
        adapter.clear();
        getKakaoData(keyword);
    }

    private void getKakaoData(String keyword) {
        RequestParams params = new RequestParams();
        params.put("query",keyword);
        params.put("size",String.valueOf(PAGE_SIZE));
        params.put("page",String.valueOf(PAGE));
        // 헤더 파일에 api 키 추가
        client.addHeader("Authorization", "KakaoAK c268174c65ef7a778933c1aa876494cf");
        client.get("https://dapi.kakao.com/v2/search/image", params,response);
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == SCROLL_STATE_IDLE && lastItemVisibleFlag){
            if (PAGE < Image.pageable_count){
                PAGE++;
                getKakaoData(keyword);
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        lastItemVisibleFlag = (totalItemCount >0)&&(firstVisibleItem + visibleItemCount >= totalItemCount);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Image item = adapter.getItem(position);
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
