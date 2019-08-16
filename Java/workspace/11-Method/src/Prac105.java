
public class Prac105 {
	static void input(char[] ch) {
		int startNum = 65, endNum = 90; // 65~90: 'A'~'Z'
		for (int x = 0; x < ch.length; x++) {
			ch[x] = (char) ((int) (Math.random() * (endNum - startNum + 1) + startNum));
		}
	}

	static void countChar(int[] cnt, char[] ch) {
		for (int x = 0; x < cnt.length; x++) { // 기준: 알파벳 'A' ~'Z' => 65~90
			for (int y = 0; y < ch.length; y++) { // 모든 문자
				if (x + 65 == (int) ch[y]) {
					cnt[x]++;
				}
			}
		}
	}

	static void output(int[] cnt, char[] ch) {
		for (int x = 0; x < ch.length; x++) {
			if (x % 10 == 0)
				System.out.println();
			System.out.print(ch[x] + " ");
		}
		System.out.println();
		System.out.println();
		for (int x = 0; x < cnt.length; x++) {
			System.out.println((char) (65 + x) + " : " + cnt[x]);
		}
	}

	public static void main(String[] args) {
		// 선언
		char[] ch = new char[50]; // 랜덤 값
		int[] cnt = new int[26]; // A ~ Z 비교

		// 입력
		input(ch);
		// 연산
		countChar(cnt, ch);
		// 출력
		output(cnt, ch);
	}
}
