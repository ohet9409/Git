package com.example.practice2;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 객체 선언
    Button buttonInput, buttonList, buttonModify;
    Button buttonInput2, buttonBack2, buttonBack3;
    Button buttonModify2, buttonBack4;
    EditText editTextName, editTextKor, editTextEng, editTextMat;
    EditText editTextModifyName, editTextModifyKor, editTextModifyEng, editTextModifyMat;
    TextView textViewList;
    LinearLayout layoutMain, layoutInput, layoutList, layoutModify;
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
        buttonModify = findViewById(R.id.buttonModify);
        buttonModify2 = findViewById(R.id.buttonModify2);
        buttonBack2 = findViewById(R.id.buttonBack2);
        buttonBack3 = findViewById(R.id.buttonBack3);
        buttonBack4 = findViewById(R.id.buttonBack4);
        editTextName = findViewById(R.id.editTextName);
        editTextKor = findViewById(R.id.editTextKor);
        editTextEng = findViewById(R.id.editTextEng);
        editTextMat = findViewById(R.id.editTextMat);
        editTextModifyName = findViewById(R.id.editTextModifyName);
        editTextModifyKor = findViewById(R.id.editTextModifyKor);
        editTextModifyEng = findViewById(R.id.editTextModifyEng);
        editTextModifyMat = findViewById(R.id.editTextModifyMat);
        textViewList = findViewById(R.id.textViewList);
        layoutMain = findViewById(R.id.layoutMain);
        layoutInput = findViewById(R.id.layoutInput);
        layoutList = findViewById(R.id.layoutList);
        layoutModify = findViewById(R.id.layoutModify);
        // 이벤트 설정
        buttonInput.setOnClickListener(this);
        buttonList.setOnClickListener(this);
        buttonModify.setOnClickListener(this);
        buttonModify2.setOnClickListener(this);
        buttonInput2.setOnClickListener(this);
        buttonBack2.setOnClickListener(this);
        buttonBack3.setOnClickListener(this);
        buttonBack4.setOnClickListener(this);
        // 화면 설정
        layoutMain.setVisibility(View.VISIBLE);
        layoutInput.setVisibility(View.GONE);
        layoutList.setVisibility(View.GONE);
        layoutModify.setVisibility(View.GONE);
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
        try {
            if(database != null) {
                String sql = "SELECT name, kor, eng, mat, tot, avg FROM " + tableName + ";";
                Cursor cursor = database.rawQuery(sql, null);
                // 제목 출력
                String result = String.format("%4s%9s%7s%7s%7s%7s%7s\n",
                        "no", "name", "kor", "eng", "mat", "tot", "avg");
                for(int i=0; i<cursor.getCount(); i++) {
                    cursor.moveToNext();
                    String name = cursor.getString(0);
                    int kor = cursor.getInt(1);
                    int eng = cursor.getInt(2);
                    int mat = cursor.getInt(3);
                    int tot = cursor.getInt(4);
                    float avg = cursor.getFloat(5);
                    result += String.format("%4d%9s%7d%7d%7d%7d%7.1f\n",
                            i+1, name, kor, eng, mat, tot, avg);
                }
                cursor.close();

                textViewList.setText(result);
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
    // 5. 레코드 수정하기
    /*
        UPDATE tableName SET kor=kor, eng=eng, mat=mat, tot=tot, avg=avg
        WHERE name='name';
     */
    public void modifyData() {
        try {
            String name = editTextModifyName.getText().toString().trim();
            String strKor = editTextModifyKor.getText().toString().trim();
            String strEng = editTextModifyEng.getText().toString().trim();
            String strMat = editTextModifyMat.getText().toString().trim();
            int kor = Integer.parseInt(strKor);
            int eng = Integer.parseInt(strEng);
            int mat = Integer.parseInt(strMat);
            int tot = kor + eng + mat;
            float avg = (float)tot / 3;

            if(database != null) {
                ContentValues values = new ContentValues();
                values.put("kor", kor);
                values.put("eng", eng);
                values.put("mat", mat);
                values.put("tot", tot);
                values.put("avg", avg);
                int result = database.update(tableName, values,
                        "name='" + name + "'", null);

//                String sql = "UPDATE " + tableName + " SET kor=" + kor + ", eng=" + eng
//                           + ", mat=" + mat + ", tot=" + tot + ", avg=" + avg
//                           + " WHERE name='" + name + "';";
//                database.execSQL(sql);
                if(result > 0) {
                    Toast.makeText(this, "데이터를 수정했습니다. result=" +result,
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "데이터를 수정하지 못했습니다. result=" +result,
                            Toast.LENGTH_SHORT).show();
                }
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
            case R.id.buttonInput:  // 입력화면 이동
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.VISIBLE);
                layoutList.setVisibility(View.GONE);
                break;
            case R.id.buttonList:   // 목록 화면 이동 + 데이터 목록 출력
                listData();     // SQLite에서 데이터 읽어오기
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonInput2: // 데이터 저장
                insertData();   // SQLite에 저장하기
                editTextName.setText("");
                editTextKor.setText("");
                editTextEng.setText("");
                editTextMat.setText("");
                break;
            case R.id.buttonModify: // 수정 화면 이동
                layoutMain.setVisibility(View.GONE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                layoutModify.setVisibility(View.VISIBLE);
                break;
            case R.id.buttonModify2:    // 수정된 데이터 저장
                modifyData();
                editTextModifyName.setText("");
                editTextModifyKor.setText("");
                editTextModifyEng.setText("");
                editTextModifyMat.setText("");
                break;
            case R.id.buttonBack2:
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                layoutModify.setVisibility(View.GONE);
                break;
            case R.id.buttonBack3:
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                layoutModify.setVisibility(View.GONE);
                break;
            case R.id.buttonBack4:
                layoutMain.setVisibility(View.VISIBLE);
                layoutInput.setVisibility(View.GONE);
                layoutList.setVisibility(View.GONE);
                layoutModify.setVisibility(View.GONE);
                break;
        }
    }
}
