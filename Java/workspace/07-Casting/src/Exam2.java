
public class Exam2 {
	public static void main(String[] args) {
		//System.out.println의 단축키 : syso + ctrl + space
		//큰 데이터를 작은 변수에 저장할 때, 형변환을 시킨다.
		long ll = 128;
		int i = (int)ll;
		short s = (short)i;
		byte b = (byte)s; //byte: 1byte, -128~127까지 지정할 수 있음
		System.out.println("ll = " + ll);
		System.out.println("i = "+i);
		System.out.println("s = "+ s);
		System.out.println("b = "+b);
	}
}
