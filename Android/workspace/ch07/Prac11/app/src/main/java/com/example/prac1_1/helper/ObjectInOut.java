package com.example.prac1_1.helper;


import android.util.Log;

import com.example.prac1_1.model.Member;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
    //  싱글톤 시작
    private static ObjectInOut instance = null;

    public static ObjectInOut getInstance() {
        if (instance == null) instance = new ObjectInOut();

        return instance;
    }

    public static void freeInstance() {
        instance = null;
    }

    private ObjectInOut() {
    }
    //  싱글톤 끝

    public boolean write(String fname, List<Member> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean result = false;
        try {
            fos = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fos);
            // 데이터 총 갯수 출력
            oos.writeInt(list.size());
            //  list에 저장된 객체 출력
            for (int i = 0; i < list.size(); i++) {
                oos.writeObject(list.get(i));
                oos.flush();        // 출력 버퍼 비우기
            }
            result = true;
            Log.d("[INFO]", "파일 저장 성공 >> " + fname);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "저장 경로를 찾을 수 없습니다. >> " + fname);
        } catch (IOException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "파일 저장 실패 >> " + fname);
        } catch (Exception e) {
            Log.d("[ERROR]", "알 수 없는 에러 >> " + fname);
            //e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public List<Member> read(String fname) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Member> list = new ArrayList<>();
        try {
            fis = new FileInputStream(fname);
            ois = new ObjectInputStream(fis);
            //  총 데이터 갯수 읽어오기
            int totalSize = ois.readInt(); //  oos.writeInt(list.size()); 와 쌍으로 적용
            //  객체 읽어와서 List에 저장하기
            for (int i = 0; i < totalSize; i++) {
                Member member = (Member) ois.readObject();
                list.add(member);
            }
            Log.d("[INFO]", "파일 읽기 성공 >> " + fname);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "파일 경로를 찾을 수 없습니다. >> " + fname);
        } catch (IOException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "파일 읽기 실패 >> " + fname);
        } catch (Exception e) {
            Log.d("[ERROR]", "알 수 없는 에러 >> " + fname);
            //e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
