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
	// 파일 저장:  file -> list -> vo -> oos ->file
	public void write(String fileName, List<ScoreVO> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			// 파일 출력 : 데이터의 갯수(fileName에 저장할 공간 갯수를 마련하기 위해)
			oos.writeInt(list.size()); // --> 저장된 갯수 만큼 읽어 올 때 해당 갯수만큼 불러올 수 있도록 갯수 저장
			// 파일 출력 : 객체 출력 
			for (int x = 0; x < list.size(); x++) {
				ScoreVO vo = list.get(x);
				oos.writeObject(vo); // fileName에 객체 저장
				oos.flush(); // 출력 버퍼를 비우라는 명령어

			}
			System.out.println("[INFO] 저장 성공 >> " + fileName);
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

	// 파일 읽기 : file -> ois -> vo -> list
	//         리턴값                                         파일이름
	public List<ScoreVO> read(String fileName) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();	// 리스트에 값을 저장하기위해 선언
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);	// 해당파일을 찾아서 그 데이터를 fis에 저장
			ois = new ObjectInputStream(fis);		// fis에 있는 데이터를 ois로 전달해서 역직렬화시킨다.
			// 저장된 데이터의 갯수 읽어오기
			int num = ois.readInt();				// 저장된 갯수만큼 읽어오기 위해서
			// 저장된 객체를 읽어와서, List에 저장하기
			for (int x = 0; x < num; x++) {
				ScoreVO vo = (ScoreVO) ois.readObject();	// ois에서 역직렬화한 값을 vo에게 전달
				list.add(vo);						// vo의 데이터 주소를 list에 저장
			}
			System.out.println("[INFO] 파일 읽기 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + fileName);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
//			e.printStackTrace();
		} finally {
			try {
				if (ois != null)
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
