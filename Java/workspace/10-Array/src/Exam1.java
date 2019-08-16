
public class Exam1 {
	public static void main(String[] args) {
		/* 배열의 생성 방법*/
		// 1. 배열의 선언과 크기 지정 및 값의 할당에 대한 개별 처리
		int[] hong;		// 배열명, 래퍼런스 변수: 주소를 저장하는 변수
		hong = new int[3];	
		hong[0]=75;
		hong[1]=82;
		hong[2]=95;
		// 2. 배열의 선언과 크기 지정의 일괄 처리
		int[] kim =new int[3];
		kim[0]=88;
		kim[1]=64;
		kim[2]=70;
		// 3. 배열 생성의 일괄 처리
		int[] lee = new int[] {100,95,90};
		//int[] lee = {100,95,90};			//new int[]는 생략할 수 있음
		
		int[] sum = {0,0,0};
		String[] name= {"홍길동","김철수","이영희"};
		// 각 배열 요소의 값에 대한 합계구하기
		for(int x=0; x<hong.length; x++) {
			sum[0] += hong[x];
		}
		for(int x=0;x<3;x++) {
			sum[1]+=kim[x];
		}
		for(int x=0;x<lee.length;x++) {
			sum[2]+=lee[x];
		}
		// 평균을 출력
		for(int x=0; x<3; x++) {
			System.out.println(name[x]+" = " + (double)sum[x]/hong.length);
		}
	}
}
