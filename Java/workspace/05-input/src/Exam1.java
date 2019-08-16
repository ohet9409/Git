import java.io.IOException;
import java.lang.System;
// 문자 한 개 입력 명령어
// 자동 완성 단축키: main + ctrl + space
// enter: \r\n
public class Exam1 {
	public static void main(String[] args) throws IOException{ // 예외 처리
		//선언
		char aa =0;
		int bb =0;
		//입력
		System.out.print("문자 = ");
		aa = (char)System.in.read(); //이진수를 문자로 변경해서 저장 a\r\n
		//System.in.read();            // \r 읽기만 하고 저장 안함
		//System.in.read();			//\n 읽기만 하고 저장 안한다
		
		bb = System.in.read() -48; //0에 대한 아스키 코드값 1\r\n
		System.out.print("숫자 = "+bb+"\n"); //System.in.read(); 사용안하면 /r 값을 읽어와서 사용
		
		//연산
		//출력
		System.out.println("aa="+ aa);
		System.out.println("bb="+ bb);
	}
}
