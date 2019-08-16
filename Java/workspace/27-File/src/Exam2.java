import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Exam2 {
	public static void main(String[] args) {
		// ������ ������ ���
		String path = "./test.txt"; 	// ./ => ������Ʈ ����
		// ���Ͽ� ����� ����
		String write_string = "�����ٶ󸶹ٻ�abcdefg";
		/* Ư�� ���ڵ� ��� ���� */
		byte[] buffer = null;		//=> ��Ʈ���� ����ϱ����� byte������ ����
		try {
			buffer = write_string.getBytes("utf-8"); // ���ڿ��� "UTF-8" �� ���ڵ��ؼ� ���� /�ѱ� -3byte ����-1byte
			//buffer = write_string.getBytes();	// �����ڵ�
		} catch (Exception e) {

			e.printStackTrace();
		}
		System.out.println(buffer.length);
//		 for(int x=0; x<buffer.length;x++) {
//			 System.out.print(buffer[x]+" ");
//			 if(x%10 ==0) {
//				 System.out.println();
//			 }
//		 }
		/* ���� ���� ���� */
		// finally ������ �νĽ�Ű�� ���ؼ� ����θ� ���� �ű� ����
		OutputStream out = null;	// �θ�Ŭ����
		try {
			// ������ ����鼭, ���½�Ŵ(�� �غ�)
			out = new FileOutputStream(path);	// �ڽ�Ŭ����
			// ���Ͽ� ������ ����
			out.write(buffer);
			System.out.println("[INFO] ���� ����� >> " + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� �����ϴ�. >>" + path);

		} catch (IOException e) {
			System.out.println("[ERROR] ���忡 �����߽��ϴ�. >>" + path);

		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ������ �߻��߽��ϴ�. >>" + path);
		} finally {
			try {
				if (out != null)	
					out.close(); // ���� ��Ʈ�� �ݱ�(�ݵ��)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
