import java.util.Scanner;

public class Prac5 {

	public static void main(String[] args) {
		// 선언: 변수 만들기
		Scanner sc = new Scanner(System.in);
		String name=" ";
		char gen=0;
		int age=0;
		double height=0;
		// 입력: 변수에 데이터 저장하기
		System.out.print("Input name: ");
		name=sc.next();
		System.out.print("Input gender: ");
		gen=sc.next().charAt(0);
		System.out.print("Input age: ");
		age=sc.nextInt();
		System.out.print("Input height: ");
		height=sc.nextDouble();
		System.out.println();
		// 연산: 저장된 데이터 가공하기
		// 출력: 결과값 확인하기
		System.out.println("이름: "+name);
		System.out.println("성별: "+ ((gen == 'M')? "남자":"여자" ));
		// M : 남자 / 나머지 : 여자
		System.out.println("나이: "+age+"세");
		System.out.println("신장: " + height+"cm");
		

	}

}
