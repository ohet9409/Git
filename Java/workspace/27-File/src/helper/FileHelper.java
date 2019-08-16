package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.security.auth.login.FailedLoginException;

/* ���� ����� ��� ���� */
public class FileHelper {
	// �̱��� ��ü ���� ����
	private static FileHelper instance = null;
	
	public static FileHelper getInstance(){
		if(instance == null) instance = new FileHelper();
		return instance;
	}
	public static void  freeInstance() {
		instance  = null;
	}
	// �����ڰ� private�̱� ������, new�� ��ü ������ �� �� ����
	private FileHelper() {}
	// �̱��� ��ü ���� ��
	/**	=> ����
	 * �־��� ��ο� data ���� ����ϰ� �����Ѵ�.
	 * @param filepat 	: ������ ���� ���
	 * @param date 		: ������ ������ ���� ��Ʈ�� (byte �迭)
	 * @return boolean	: �������� ������ true, ���н� false
	 */
	
	public boolean write(String filepath, byte[] data) {
		boolean result = false;	
		
		/* ���� ���� ���� ���� */
		// finally ��Ͽ��� �νĽ�Ű�� ���ؼ� ����θ� ���� ��ġ��Ų��. 
		OutputStream out = null;
		try {
		out = new FileOutputStream(filepath);
		//���� ����
		out.write(data);
		// ���� ���� ����
		result = true;
		System.out.println("[INFO] ���� ����� >> " + filepath);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >> " + filepath);
			//e.printStackTrace();
		}catch (IOException e) {
			System.out.println("[ERROR] ���� ���� ���� >> " + filepath);
			//e.printStackTrace();
		}catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + filepath);
			//e.printStackTrace();
		} finally {
			try {
				if(out != null) out.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	/**
	 * �־��� ����� ������ �а�, ������ ��Ʈ������ �����Ѵ�.
	 * @param filePath	: �о�� �� ������ ���
	 * @return	byte[]	: ������ ������ ����� ���� ������ 
	 */
	public byte[] read(String filePath) {
		byte[] data = null;
		/* ���� �б� */
		InputStream in = null;
		try {
			in= new FileInputStream(filePath);
			// ���� ũ�⸸ŭ �迭 �����
			data = new byte[in.available()];
			// ���� �о, �迭�� �����ϱ�
			in.read(data);
			System.out.println("[INFO] ���� �б� ���� >> " + filePath);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] ���� ��θ� ã�� �� ���� >> " + filePath);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] ���� �б� ���� >> " + filePath);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ���� >> " + filePath);
			//e.printStackTrace();
		}finally {
			try {
				if(in!=null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	/**
	 * ���ڿ��� byte[]�� ��ȯ�� ��, ���Ͽ� �����Ѵ�.
	 * @param filPath	: ������ ���� ���
	 * @param content	: ������ ����
	 * @param encType	: ���ڵ� ����
	 * @return boolean	: ���� ������ true, ���н� false
	 */
	public boolean writeString(String filePath, String content, String encType) {
		boolean result = false; // ���� ���� ���� ���� ����
		byte[] data = null;
		try {
			// ���ڿ��� byte[]�� ��ȯ
			data = content.getBytes(encType);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] ���ڵ� ���� ����");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ����");
			//e.printStackTrace();
		}
		// byte[]�� ���Ͽ� ����, ������ true, ���н� false�� ���ƿ�
		result = write(filePath, data);
		return result;
		
	}
	/**
	 * ������ ������ ���ڿ��� �����Ѵ�.
	 * @param filePath	: �о�� �� ������ ���
	 * @param encType	: ���ڵ� ����
	 * @return String	: ���� ���뿡 ���� ���ڿ�
	 */
	public String  readString(String filePath, String encType) {
		String content = null;
		// ������ �о byte[]�� ���� ��, ���� ��
		byte[] data = read(filePath);
		// byte[]�� ����� �����͸� ���ڿ��� ��ȯ
		try {
			content = new String(data, encType);	//byte ������ String ���� ��ȯ�ؼ� ����
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] ���ڵ� ���� ����");
			// e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] �� �� ���� ����");
			// e.printStackTrace();
		}
		return content;
	}
}
