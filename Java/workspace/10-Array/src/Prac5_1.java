
public class Prac5_1 {
	public static void main(String[] args) {
		// 선언
		char[] ch = new char[50];
		int[] cnt = new int[26];
		int startNum = 65, endNum = 90; // 65~90: 'A'~'Z'
		// 입력
		for (int x = 0; x < ch.length; x++) {
			ch[x] = (char)((int) (Math.random() * (endNum - startNum + 1) + startNum));
		}
		// 연산
		for(int x=0; x<cnt.length;x++) {				//기준: 알파벳 'A' ~'Z' => 65~90
			for(int y=0; y<ch.length; y++) {	// 모든 문자
				if(x+65 == (int)ch[y]) {
					cnt[x]++;
				}
			}
		}
		//출력
		for (int x = 0; x < ch.length; x++) {
			if (x % 10 == 0)System.out.println();		
			System.out.print(ch[x] + " ");
		}
		System.out.println(); System.out.println();
		for(int x=0; x<cnt.length;x++) {
			System.out.println((char)(65+x)+" : " + cnt[x]);
		}
	}
}
