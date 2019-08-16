import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Exam2 {
	public static void main(String[] args) {
		// 저장할 파일의 경로
		String path = "./test.txt"; 	// ./ => 프로젝트 폴더
		// 파일에 저장될 내용
		String write_string = "가나다라마바사abcdefg";
		/* 특정 인코딩 방식 적용 */
		byte[] buffer = null;		//=> 스트림을 사용하기위해 byte단위로 변경
		try {
			buffer = write_string.getBytes("utf-8"); // 문자열을 "UTF-8" 로 인코딩해서 저장 /한글 -3byte 영어-1byte
			//buffer = write_string.getBytes();	// 유니코드
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
		/* 파일 저장 시작 */
		// finally 블럭에서 인식시키기 위해서 선언부를 위로 옮긴 것임
		OutputStream out = null;	// 부모클래스
		try {
			// 파일을 만들면서, 오픈시킴(쓸 준비)
			out = new FileOutputStream(path);	// 자식클래스
			// 파일에 데이터 쓰기
			out.write(buffer);
			System.out.println("[INFO] 파일 저장됨 >> " + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다. >>" + path);

		} catch (IOException e) {
			System.out.println("[ERROR] 저장에 실패했습니다. >>" + path);

		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러가 발생했습니다. >>" + path);
		} finally {
			try {
				if (out != null)	
					out.close(); // 파일 스트림 닫기(반드시)
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
