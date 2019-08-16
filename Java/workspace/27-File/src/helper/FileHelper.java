package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.security.auth.login.FailedLoginException;

/* 파일 입출력 기능 구현 */
public class FileHelper {
	// 싱글톤 객체 생성 시작
	private static FileHelper instance = null;
	
	public static FileHelper getInstance(){
		if(instance == null) instance = new FileHelper();
		return instance;
	}
	public static void  freeInstance() {
		instance  = null;
	}
	// 생성자가 private이기 때문에, new로 객체 생성을 할 수 없음
	private FileHelper() {}
	// 싱글톤 객체 생성 끝
	/**	=> 도움말
	 * 주어진 경로에 data 값을 기록하고 저장한다.
	 * @param filepat 	: 저장할 파일 경로
	 * @param date 		: 저장할 내용을 담을 스트림 (byte 배열)
	 * @return boolean	: 파일저장 성공시 true, 실패시 false
	 */
	
	public boolean write(String filepath, byte[] data) {
		boolean result = false;	
		
		/* 파일 저장 절차 시작 */
		// finally 블록에서 인식시키기 위해서 선언부를 위에 위치시킨다. 
		OutputStream out = null;
		try {
		out = new FileOutputStream(filepath);
		//파일 쓰기
		out.write(data);
		// 파일 저장 성공
		result = true;
		System.out.println("[INFO] 파일 저장됨 >> " + filepath);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + filepath);
			//e.printStackTrace();
		}catch (IOException e) {
			System.out.println("[ERROR] 파일 저장 실패 >> " + filepath);
			//e.printStackTrace();
		}catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filepath);
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
	 * 주어진 경로의 파일을 읽고, 내용을 스트림으로 리턴한다.
	 * @param filePath	: 읽어야 할 파일의 경로
	 * @return	byte[]	: 읽혀진 내용이 저장된 것을 돌려줌 
	 */
	public byte[] read(String filePath) {
		byte[] data = null;
		/* 파일 읽기 */
		InputStream in = null;
		try {
			in= new FileInputStream(filePath);
			// 파일 크기만큼 배열 만들기
			data = new byte[in.available()];
			// 파일 읽어서, 배열의 저장하기
			in.read(data);
			System.out.println("[INFO] 파일 읽기 성공 >> " + filePath);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + filePath);
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >> " + filePath);
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + filePath);
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
	 * 문자열을 byte[]로 변환한 뒤, 파일에 저장한다.
	 * @param filPath	: 저장할 파일 경로
	 * @param content	: 저장할 내용
	 * @param encType	: 인코딩 형식
	 * @return boolean	: 저장 성공시 true, 실패시 false
	 */
	public boolean writeString(String filePath, String content, String encType) {
		boolean result = false; // 파일 저장 성공 여부 저장
		byte[] data = null;
		try {
			// 문자열을 byte[]로 변환
			data = content.getBytes(encType);
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] 인코딩 지정 에러");
			//e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러");
			//e.printStackTrace();
		}
		// byte[]을 파일에 저장, 성공시 true, 실패시 false가 돌아옴
		result = write(filePath, data);
		return result;
		
	}
	/**
	 * 파일의 내용을 문자열로 리턴한다.
	 * @param filePath	: 읽어야 할 파일의 경로
	 * @param encType	: 인코딩 형식
	 * @return String	: 읽은 내용에 대한 문자열
	 */
	public String  readString(String filePath, String encType) {
		String content = null;
		// 파일을 읽어서 byte[]에 저장 후, 돌려 줌
		byte[] data = read(filePath);
		// byte[]에 저장된 데이터를 문자열로 변환
		try {
			content = new String(data, encType);	//byte 단위를 String 으로 변환해서 저장
		} catch (UnsupportedEncodingException e) {
			System.out.println("[ERROR] 인코딩 지정 에러");
			// e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러");
			// e.printStackTrace();
		}
		return content;
	}
}
