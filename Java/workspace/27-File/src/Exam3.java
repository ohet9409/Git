import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.print.DocFlavor.INPUT_STREAM;

public class Exam3 {

	public static void main(String[] args) {
		// 읽을 파일의 경로
		String path = "./test.txt";
		// 읽은 내용이 저장될 byte 배열
		byte[] data = null;
		// 읽은 내용이 변환될 문자열
		String read_string = null;
		/* 파일 읽기  */
		InputStream in =null;
		try {
			in = new FileInputStream(path);
			// 파일에서 읽은 데이터를 담기위한 배열은 파일의 용량만큼 사이즈를 할당하나다.
			// in.available() : 열려있는 파일의 크기를 알려줌
			data = new byte[in.available()];	// data 배열 크기 지정
			in.read(data);	// 1byte씩 읽기
			System.out.println("[INFO] 파일 읽기 성공 >>" + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >>" + path);
			
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >>" + path);
			
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + path);
		}finally {
			try {
				if(in != null) in.close(); // 열려있는 파일 닫아 주기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		/*  data 배열의 내용을 읽어온 후   */
		// data 배열에 내용이 있다면, 문자열로 변환하여 출력
		if(data != null) {
			// 문자열로 변환시에는 저장된 인코딩으로 지정해 준다.
			try {
				read_string = new String(data, "utf-8"); // 저장된 인코딩을 유니코드로 변환하여 저장
				System.out.println(read_string);	// 저장된 값을 출력
			} catch (UnsupportedEncodingException e) {
				System.out.println("[ERROR] 인코딩 지정 에러");
				
			}
		}

	}

}
