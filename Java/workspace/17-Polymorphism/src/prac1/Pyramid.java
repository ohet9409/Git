package prac1;

public class Pyramid extends DrawData{
	@Override
	public void draw() {
		for(int i=1; i<=getHeight();i++) {
			for(int j=1; j<=getHeight()-i; j++) {	// ���� ���� ���
				System.out.print(' ');
			}
			for(int k=1; k<=2*i-1; k++) {	// ����� ���� ���
				System.out.print(getOutchar());
			}
			System.out.println();
		}
		
	}
}
