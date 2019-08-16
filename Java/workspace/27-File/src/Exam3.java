import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.print.DocFlavor.INPUT_STREAM;

public class Exam3 {

	public static void main(String[] args) {
		// ���� ������ ���
		String path = "./test.txt";
		// ���� ������ ����� byte �迭
		byte[] data = null;
		// ���� ������ ��ȯ�� ���ڿ�
		String read_string = null;
		/* ���� �б�  */
		InputStream in =null;
		try {
			in = new FileInputStream(path);
			// ���Ͽ��� ���� �����͸� ������� �迭�� ������ �뷮��ŭ ����� �Ҵ��ϳ���.
			// in.available() : �����ִ� ������ ũ�⸦ �˷���
			data = new byte[in.available()];	// data �迭 ũ�� ����
			in.read(data);	// 1byte�� �б�
			System.out.println("[INFO] ���� �б� ���� >>" + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >>" + path);
			
		} catch (IOException e) {
			System.out.println("[ERROR] ���� �б� ���� >>" + path);
			
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + path);
		}finally {
			try {
				if(in != null) in.close(); // �����ִ� ���� �ݾ� �ֱ�
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*  data �迭�� ������ �о�� ��   */
		// data �迭�� ������ �ִٸ�, ���ڿ��� ��ȯ�Ͽ� ���
		if(data != null) {
			// ���ڿ��� ��ȯ�ÿ��� ����� ���ڵ����� ������ �ش�.
			try {
				read_string = new String(data, "utf-8"); // ����� ���ڵ��� �����ڵ�� ��ȯ�Ͽ� ����
				System.out.println(read_string);	// ����� ���� ���
			} catch (UnsupportedEncodingException e) {
				System.out.println("[ERROR] ���ڵ� ���� ����");
				
			}
		}

	}

}
