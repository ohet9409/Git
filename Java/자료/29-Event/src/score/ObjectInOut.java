package score;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
	// 파일 저장
	public void write(String fileName, List<ScoreVO> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			// 저장될 데이터의 갯수
			oos.writeInt(list.size());
			// 객체 저장
			for(int x=0; x<list.size(); x++) {
				ScoreVO vo = list.get(x);				
				oos.writeObject(vo);
				oos.flush();  	// 출력버퍼를 비우라는 명령어
			}
			System.out.println("[INFO] 파일 저장 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + fileName);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
			//e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	// 파일 읽기
	public List<ScoreVO> read(String fileName) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			// 저장된 데이터의 갯수 읽어오기
			int num = ois.readInt();
			// 저장된 객체를 읽어와서, List에 저장하기
			for(int x=0; x<num; x++) {
				ScoreVO vo = (ScoreVO) ois.readObject();
				list.add(vo);
			}
			System.out.println("[INFO] 파일 읽기 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >> " + fileName);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
			//e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}





