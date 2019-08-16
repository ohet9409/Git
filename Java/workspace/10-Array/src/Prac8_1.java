
public class Prac8_1 {

	public static void main(String[] args) {
		// 선언
		// 입력
		int[][] a= {{1,2,3,0},
				    {4,5,6,0},
				    {7,8,9,0},
				    {0,0,0,0}};
		// 연산
		for(int x=0; x<3;x++) {				//행번호: 0~2까지
			for(int y=0; y<3;y++) { 		//열번호: 열 0~2 까지의 합 구하기
				 a[x][3] += a[x][y];
				 a[3][x] += a[y][x];
				 a[3][3] += a[x][y];
			}
		}
		// 출력
		for(int x=0; x<a.length;x++) { 				// a.length: 행의 개수 =>4
			for(int y=0; y<a[0].length;y++) { 		//a[0].length: 열의 개수 =>4
				System.out.printf("%2d ",a[x][y]);
			}
			System.out.println();
		}

	}

}
