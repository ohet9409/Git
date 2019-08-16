import java.io.IOException;
import java.util.Random;

public class Exam4 {

	public static void main(String[] args) throws IOException {
		// 5자리 인증번호 생성하기
		String authNum = "";
		Random random = new Random();
		
		for(int i =0; i<5; i++) {
			authNum += random.nextInt(10);	// 0~9 사이의 임의의 정수 만들기 
//			System.out.println(authNum);
//			System.in.read(); System.in.read();
		}
			System.out.println("인증번호 : " + authNum);
	}

}
