package com.example.fileoexam.helper;

import android.util.Log;

import com.example.fileoexam.model.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
    // 싱글톤 시작
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
    // 싱글톤 끝

    /**
     * List에 저장된 객체를 파일에 저장
     *
     * @param fname : 파일 이름
     * @param list  : List 객체
     * @return boolean : 성공 - true, 실패 - false
     */
    public boolean write(String fname, List<Student> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean result = false;
        try {
            fos = new FileOutputStream(fname);
            // ObjectOutputStream를 통해서 출력(편하게 작업)
            oos = new ObjectOutputStream(fos);
            //  총 데이터 갯수 저장
            oos.writeInt(list.size());
            //  객체 저장
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                oos.writeObject(student);
                oos.flush();    // 메모리에 남아있는 값 출력
            }
            result = true;
            Log.d("[INFO]", "저장성공 >> " + fname);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "저장 경로를 찾을 수 없음 >> " + fname);
        } catch (IOException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "파일 저장 실패 >> " + fname);
        } catch (Exception e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "알 수 없는 에러 >> " + fname);
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

    /**
     * 파일에서 데이터를 읽어와서, List에 저장후, 리턴
     * @param fname : 파일 이름
     * @return List : List 리턴
     */
    public List<Student> read(String fname){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Student> list = new ArrayList<>();

        try {
            fis = new FileInputStream(fname);
            ois = new ObjectInputStream(fis);
            //  총 데이터 갯수 읽어오기
            int totalSize = ois.readInt();
            //  객체 읽어와서 List에 저장
            for (int i=0; i<totalSize; i++){
                Student student = (Student) ois.readObject();
                list.add(student);
            }
            Log.d("[INFO]", "파일 읽기 성공 >> " + fname);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "저장 경로를 찾을 수 없음 >> " + fname);
        } catch (IOException e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "파일 읽기 실패 >> " + fname);
        } catch (Exception e) {
            //e.printStackTrace();
            Log.d("[ERROR]", "알 수 없는 에러 >> " + fname);
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



