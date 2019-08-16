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
	// ���� ����
	public void write(String fileName, List<ScoreVO> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			// ����� �������� ����
			oos.writeInt(list.size());
			// ��ü ����
			for(int x=0; x<list.size(); x++) {
				ScoreVO vo = list.get(x);				
				oos.writeObject(vo);
				oos.flush();  	// ��¹��۸� ����� ��ɾ�
			}
			System.out.println("[INFO] ���� ���� ���� >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >> " + fileName);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] ���� ���� ���� >> " + fileName);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + fileName);
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
	// ���� �б�
	public List<ScoreVO> read(String fileName) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			// ����� �������� ���� �о����
			int num = ois.readInt();
			// ����� ��ü�� �о�ͼ�, List�� �����ϱ�
			for(int x=0; x<num; x++) {
				ScoreVO vo = (ScoreVO) ois.readObject();
				list.add(vo);
			}
			System.out.println("[INFO] ���� �б� ���� >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >> " + fileName);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] ���� �б� ���� >> " + fileName);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + fileName);
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





