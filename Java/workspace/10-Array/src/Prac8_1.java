
public class Prac8_1 {

	public static void main(String[] args) {
		// ����
		// �Է�
		int[][] a= {{1,2,3,0},
				    {4,5,6,0},
				    {7,8,9,0},
				    {0,0,0,0}};
		// ����
		for(int x=0; x<3;x++) {				//���ȣ: 0~2����
			for(int y=0; y<3;y++) { 		//����ȣ: �� 0~2 ������ �� ���ϱ�
				 a[x][3] += a[x][y];
				 a[3][x] += a[y][x];
				 a[3][3] += a[x][y];
			}
		}
		// ���
		for(int x=0; x<a.length;x++) { 				// a.length: ���� ���� =>4
			for(int y=0; y<a[0].length;y++) { 		//a[0].length: ���� ���� =>4
				System.out.printf("%2d ",a[x][y]);
			}
			System.out.println();
		}

	}

}
