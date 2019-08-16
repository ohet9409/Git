package com.example.a4_databaseexam;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    Button buttonInput, buttonList;
    Button buttonInput2, buttonBack2, buttonBack3;
    EditText editTextName, editTextKor, editTextEng, editTextMat;
    //TextView textViewList;
    LinearLayout layoutMain, layoutInput, layoutList;
    // SQLite용 변수 선언
    String dbName = "student.db";
    String tableName = "score";
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 객체 초기화
        buttonInput = findViewById(R.id.buttonInput);
        buttonList = findViewById(R.id.buttonList);
        buttonInput2 = findViewById(R.id.buttonInput2);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonBack3 = findViewById(R.id.buttonBack3);
        editTextName = findViewById(R.id.editTextName);
        editTextKor = findViewById(R.id.editTextKor);
        editTextEng = findViewById(R.id.editTextEng);
        editTextMat = findViewById(R.id.editTextMat);
        //textViewList = findViewById(R.id.textViewList);
        layoutMain = findViewById(R.id.layoutMain);
        layoutInput = findViewById(R.id.layoutInput);
        layoutList = findViewById(R.id.layoutList);
        // 이벤트 설정
        buttonInput.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonInput2.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);
        // 화면 설정
        layoutMain.setVisibility(View.VISIBLE);
        layoutInput.setVisibility(View.GONE);
        layoutList.setVisibility(View.GONE);
        // SQLite 설정
        // 1. 데이터베이스 만들기
        createDatabase();
        // 2. 테이블 만들기
        createTable();
    }
    // 1. 데이터베이스 만들기
    private void createDatabase() {
        try {
            database = openOrCreateDatabase(dbName, MODE_PRIVATE, null);
            Toast.makeText(this, "데이터베이스를 열었습니다. : " + dbName,
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 2. 테이블 만들기
    /* CREATE TABLE if not exists tableName (
            _id integer PRIMARY KEY autoincrement,
            name text,
            kor integer,
            eng integer,
            mat integer,
            tot integer,
            avg float
       );
     */
    private void createTable() {
        try {
            if (database != null) {
                String sql = "CREATE TABLE if not exists " + tableName + " ("
                        + "            _id integer PRIMARY KEY autoincrement,"
                        + "            name text, "
                        + "            kor integer,"
                        + "            eng integer,"
                        + "            mat integer,"
                        + "            tot integer,"
                        + "            avg float"
                        + "       );";
                database.execSQL(sql);
                Toast.makeText(this, "테이블을 만들었습니다. : " + tableName,
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. 레코드 추가하기
    /* INSERT INTO tableName (name, kor, eng, mat, tot, avg)
       VALUES ('name', kor, eng, mat, tot, avg);
     */
    private void insertData() {
        try {
            String name = editTextName.getText().toString().trim();
            String strKor = editTextKor.getText().toString().trim();
            String strEng = editTextEng.getText().toString().trim();
            String strMat = editTextMat.getText().toString().trim();
            int kor = Integer.parseInt(strKor);
            int eng = Integer.parseInt(strEng);
            int mat = Integer.parseInt(strMat);
            int tot = kor + eng + mat;
            float avg = (float)tot / 3;

            if(database != null) {
                String sql = "INSERT INTO " + tableName + " (name, kor, eng, mat, tot, avg) "
                        + " VALUES ('" + name + "', " + kor + ", " + eng + ", " + mat
                        + ", " + tot + ", " + avg + ");";
                database.execSQL(sql);
                Toast.makeText(this, "데이터를 추가했습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 4. 데이터 조회하기
    /*
        SELECT name, kor, eng, mat, tot, avg FROM tableName;
     */
    private void listData() {
        TableLayout tableLayout = findViewById(R.id.tableLayout);
        tableLayout.removeAllViews();   // 기존 데이터 삭제
        TableRow row;
        TextView textViewNo, textViewName, textViewKor, textViewEng, textViewMat;
        TextView textViewTot, textViewAvg;

        try {
            if(database != null) {
                String sql = "SELECT name, kor, eng, mat, tot, avg FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);

                for(int i=0; i<cursor.getCount(); i++) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getFloat(5);

                    row = (TableRow) getLayoutInflater().inflate(R.layout.table_row, null);
                    textViewNo = row.findViewById(R.id.textViewNo);
                    textViewName = row.findViewById(R.id.textViewName);
                    textViewKor = row.findViewById(R.id.textViewKor);
                    textViewEng = row.findViewById(R.id.textViewEng);
                    textViewMat = row.findViewById(R.id.textViewMat);
                    textViewTot = row.findViewById(R.id.textViewTot);
                    textViewAvg = row.findViewById(R.id.textViewAvg);

                    textViewNo.setText(String.valueOf(i+1));
                    textViewName.setText(name);
                    textViewKor.setText(String.valueOf(kor));
                    textViewEng.setText(String.valueOf(eng));
                    textViewMat.setText(String.valueOf(mat));
                    textViewTot.setText(String.valueOf(tot));
                    textViewAvg.setText(String.format("%4.1f",avg));

                    tableLayout.addView(row);
                }
                cursor.close();

                //textViewList.setText(result);
                Toast.makeText(this, "데이터를 조회하였습니다.",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "데이터베이스를 먼저 열어야합니다.",
                        Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonInput:
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.VISIBLE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.buttonList:
                listData();     // SQLite에서 데이터 읽어오기
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonInput2:
                insertData();   // SQLite에 저장하기
                editTextName.setText("");
                editTextKor.setText("");
                editTextEng.setText("");
                editTextMat.setText("");
                break;
            case R.id.buttonBack2:
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.buttonBack3:
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                break;
        }
    }
}
