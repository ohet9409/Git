package testgame;

public class random {
	public static void main(String[] args) {
		int[] ran = new int[24];
		for(int i=0;i<ran.length;i++) {
			ran[i] = (int)((Math.random() * 25) + 1);
			for(int j=0;j<i;j++) {
				if(ran[i] == ran[j]) {
					i--;
					break;
				}
			}
		}
		
		for(int x=0;x<ran.length;x++) {
			System.out.println(ran[x]);
		}
	}
}
