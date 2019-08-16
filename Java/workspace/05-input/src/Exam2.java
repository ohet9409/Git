import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Integer.parseInt(br.readLine()) : 문자열 한줄을 읽어와서 정수형으로 변경한다.
// readLine() : 한줄을 읽는다. "\n", "\r"을 만날때 까지 읽어온다.

public class Exam2 {
	public static void main(String[] args) throws IOException{
		//선언
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		// 문자열을 br객체에 입력받아서 저장한다.
		String name;
		int kor, eng, mat, tot;
		//입력
		System.out.print("이름? ");
		name = br.readLine();
		System.out.print("국어? ");
		kor = Integer.parseInt(br.readLine()); //readLine:모든 데이터를 문자열로 읽어옴  // Integer.~: 문자열을 정수로 변환
		System.out.print("영어? ");
		eng = Integer.parseInt(br.readLine());
		System.out.print("수학? ");
		mat = Integer.parseInt(br.readLine());
		//연산
		tot = kor + eng + mat;
		//출력
		System.out.println("이름: "+ name);
		System.out.println("총점: "+ tot);
	}

}
