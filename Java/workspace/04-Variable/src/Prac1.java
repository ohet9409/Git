
public class Prac1 {
	public static void main(String[] args) {
		int num1 = 256;
		double num2 = 126948.776;
		// 서식문자 자리수 지정: %5d -> 5자리 공간확보
		// %5.2f -> 5자리 공간확보, 소수점자리수 2자리
		System.out.println(num1);
		System.out.println(num2);
		System.out.printf("num1= %d\n", num1);
		System.out.printf("num2= %f\n", num2);
		System.out.printf("num1= %5d\n", num1);		// 앞자리 2자리를 공백으로 표시한다.
		System.out.printf("num2= %5.2f\n", num2);
		System.out.printf("num1= %05d\n", num1);	// 남은 소수점 앞자리는 0으로 표시됨
		System.out.printf("num2= %08.5f\n", num2);	// 남은 소수점 뒷자리는 0으로 표시됨 
	}
}
