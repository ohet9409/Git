package com.example.practice1.helper;

import android.util.Log;

import com.example.practice1.model.Student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {

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

    public boolean write(String fname, List<Student> list) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        boolean result = false;
        try {
            fos = new FileOutputStream(fname);
            oos = new ObjectOutputStream(fos);
            oos.writeInt(list.size());
            for (int i = 0; i < list.size(); i++) {
                Student student = list.get(i);
                oos.writeObject(student);
                oos.flush();
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

    public List<Student> read(String fname){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<Student> list = new ArrayList<>();
        try {
            fis = new FileInputStream(fname);
            ois = new ObjectInputStream(fis);
            int totalSize = ois.readInt();
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
