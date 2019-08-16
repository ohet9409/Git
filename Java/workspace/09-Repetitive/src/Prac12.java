
public class Prac12 {
	public static void main(String[] args) {
		for(int x=1; x<=100; x++) {
			for(int y=1; y<=100; y++) {
				if((4*x)+(5*y)==60) {
					System.out.printf("(%2d, %2d)",x,y);
					System.out.println();
				}
			}
		}
	}
}
