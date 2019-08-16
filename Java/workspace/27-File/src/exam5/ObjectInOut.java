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
	// ���� ����                                    �����������̸�           �ڹٺ��� ����
	public void write(String fileName, List<Student> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(fileName);	// ����(fileName)�� ������ ���� 
			oos = new ObjectOutputStream(fos);		// ������ ����ȭ
			// �������� ������ ���Ϸ� ���
			oos.writeInt(list.size());				
			// ��ü�� ���Ϸ� ���
			for (int x = 0; x < list.size(); x++) {
				Student student = list.get(x);
				oos.writeObject(student);
			}
			System.out.println("[INFO] ���� ���� ���� >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >> " + fileName);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] ���� ���� ���� >> " + fileName);
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + fileName);
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

	// ���� �б�
	public List<Student> read(String fileName) {
		List<Student> list = new ArrayList<Student>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);		// ������ ����ȭ
			// �������� ���� �о� ����
			int num = ois.readInt(); // ����
			// ��ü �� ��ŭ �о�ͼ�, List�� �����ϱ�
			for (int x = 0; x < num; x++) {
				Student student = (Student) ois.readObject();
				list.add(student);
			}
			System.out.println("[INFO] ���� �б� ���� >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >> " + fileName);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] ���� ���� ���� >> " + fileName);
//			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + fileName);
//			e.printStackTrace();
		} finally {
			try {
				if (ois != null) // ���߿� ������ ���� ���� �ݾ� �ش�
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
