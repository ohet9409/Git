
public class Prac5_1 {
	public static void main(String[] args) {
		// ����
		char[] ch = new char[50];
		int[] cnt = new int[26];
		int startNum = 65, endNum = 90; // 65~90: 'A'~'Z'
		// �Է�
		for (int x = 0; x < ch.length; x++) {
			ch[x] = (char)((int) (Math.random() * (endNum - startNum + 1) + startNum));
		}
		// ����
		for(int x=0; x<cnt.length;x++) {				//����: ���ĺ� 'A' ~'Z' => 65~90
			for(int y=0; y<ch.length; y++) {	// ��� ����
				if(x+65 == (int)ch[y]) {
					cnt[x]++;
				}
			}
		}
		//���
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
