import java.io.IOException;

public class Prac2 {
	public static void main(String[] args) throws IOException {
		/*
		 * int a=0, b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0; for(int x=1; x<=100; x++) {
		 * if(x<11) { a += x; }else if(x<21) { b += x; }else if(x<31) { c += x; }else
		 * if(x<41) { d += x; }else if(x<51) { e += x; }else if(x<61) { f += x; }else
		 * if(x<71) { g += x; }else if(x<81) { h += x; }else if(x<91) { i += x; }else
		 * if(x<101) { j += x; } } System.out.println(" 1 ~  10 = "+ a);
		 * System.out.println("11 ~  20 = "+ b); System.out.println("21 ~  30 = "+ c);
		 * System.out.println("31 ~  40 = "+ d); System.out.println("41 ~  50 = "+ e);
		 * System.out.println("51 ~  60 = "+ f); System.out.println("61 ~  70 = "+ g);
		 * System.out.println("71 ~  80 = "+ h); System.out.println("81 ~  90 = "+ i);
		 * System.out.println("91 ~ 100 = "+ j);
		 */
		/*
		 * switch로 int num1 = 0; for (int x = 1; x <= 100; x++) { num1 += x; switch(x) {
		 * case 10: System.out.println(" 1 ~  10 = " + num1); num1 = 0; break;
		 * 
		 * case 20: System.out.println("11 ~  20 = " + num1); num1 = 0; break;
		 * 
		 * case 30: System.out.println("21 ~  30 = " + num1); num1 = 0; break;
		 * 
		 * case 40: System.out.println("31 ~  40 = " + num1); num1 = 0; break;
		 * 
		 * case 50: System.out.println("41 ~  50 = " + num1); num1 = 0; break;
		 * 
		 * case 60: System.out.println("51 ~  60 = " + num1); num1 = 0; break;
		 * 
		 * case 70: System.out.println("61 ~  70 = " + num1); num1 = 0; break;
		 * 
		 * case 80: System.out.println("71 ~  80 = " + num1); num1 = 0; break;
		 * 
		 * case 90: System.out.println("81 ~  90 = " + num1); num1 = 0; break;
		 * 
		 * case 100: System.out.println("91 ~ 100 = " + num1); num1 = 0; break;
		 * 
		 * } }
		 */
		int sum = 0;
		for (int x = 1; x <= 100; x++) {
			sum += x;
			if (x % 10 == 1)
				System.out.printf("%2d ~ ", x); //2자리 수
			if (x % 10 == 0) {
				System.out.printf("%3d = %3d\n", x, sum); //3자리 수
				sum = 0;
			}

//			System.out.println();
//			System.out.println("x = " + x + ", sum = " + sum);
//			/*!!! Enter 입력 처리 (두개의 문자(\r\r)이므로 read()함수를 두 번 호출하여 문자들을 버퍼에서 제거!!!!!!!!*/
//			System.in.read(); System.in.read(); -- 테스트 용

		}
	}
}
