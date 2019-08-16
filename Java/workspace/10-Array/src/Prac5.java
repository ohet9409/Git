
public class Prac5 {
	public static void main(String[] args) {
		int[] ar = new int[50];
		int[] cnt = new int[26];
		int[] ch =new int[26];
		int count=0;
		int startNum = (int) 'A';
		int endNum = (int) 'Z';
		for (int i = 0; i < ch.length; i++) {
			ch[i] = 65 + i;
		}
		for (int x = 0; x < ar.length; x++) {
			ar[x] = (int) (Math.random() * (endNum - startNum + 1) + startNum);
			System.out.print((char) ar[x] + " ");

			if ((x + 1) % 10 == 0) {
				System.out.println();
			}
			
		}
		for(int i=0; i<ch.length;i++) {
			for(int x=0; x<ar.length; x++) {
			if(ch[i] == ar[x]) {
				cnt[i]+=1;
			}
		}
		}
		System.out.println(); System.out.println();
		for(int i=0;i<cnt.length;i++)
		System.out.println((char)(i+65) + " : " + cnt[i]);

	}
}
