package exam5;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
	// 파일 저장                                    저장할파일이름           자바빈즈 파일
	public void write(String fileName, List<Student> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);	// 파일(fileName)에 데이터 저장 
			oos = new ObjectOutputStream(fos);		// 데이터 직렬화
			// 데이터의 갯수를 파일로 출력
			oos.writeInt(list.size());				
			// 객체를 파일로 출력
			for (int x = 0; x < list.size(); x++) {
				Student student = list.get(x);
				oos.writeObject(student);
			}
			System.out.println("[INFO] 파일 저장 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + fileName);
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
//			e.printStackTrace();
		} finally {

			try {
				if (oos != null)
					oos.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 파일 읽기
	public List<Student> read(String fileName) {
		List<Student> list = new ArrayList<Student>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);		// 데이터 직렬화
			// 데이터의 갯수 읽어 오기
			int num = ois.readInt(); // 갯수
			// 객체 수 만큼 읽어와서, List에 저장하기
			for (int x = 0; x < num; x++) {
				Student student = (Student) ois.readObject();
				list.add(student);
			}
			System.out.println("[INFO] 파일 읽기 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + fileName);
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
//			e.printStackTrace();
		} finally {
			try {
				if (ois != null) // 나중에 실행한 것을 먼저 닫아 준다
					ois.close();
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
