import java.util.Random;
import java.util.Scanner;
/* 로또  6-45
 * 1~45 사이의 숫자 6개로 구성
 * 1. 로또 번호 1세트 만들기
 * 2. 오름차순 정렬 시키기
 * 
 *  */
public class Lotto {
	int[] m;
	int buyNum;
	
	Lotto(){
		m = new int[6];
	}
	public void inputBuyNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("구매 횟수를 입력하세요 : ");
		buyNum = sc.nextInt();
		System.out.println();
	}
	// 1세트 번호 만들기
	public void selectLotto() {
		boolean check= false;
		Random random = new Random();
		
		for(int i=0; i<buyNum; i++) {
			// random.nextInt(45) : 0~44 사이의 임의의 정수를 1개 만듬
			m[0] = random.nextInt(45)+1;	//(0~44) + 1 => (1~45)
			// 나머지 숫자 5개 만들기
			for(int a=1; a<6; ) {
				m[a] = random.nextInt(45)+1;
				check = false;
				// 새로 만들어진 숫자와 이미 만들어진 숫자가 같은지 검사
				for(int b=0; b<a; b++) {
					if(m[a] == m[b]) {
						check = true;
					break;
					}
				}
				if(!check) a++; 	//for문 a증감 연산자
			}
			sort();
			outputResult();
		}
	}
	private void sort() {
		for(int x=0; x<5; x++) {		// 기준값
			for(int y=x+1; y<6; y++) {	// 비교값
				if(m[x] > m[y]) {
					int temp=m[x];
					m[x]=m[y];
					m[y]=temp;
				}
			}
		}
	}
	// 출력
	private void outputResult() {
		for(int x=0; x<m.length;x++) {
		System.out.printf("%2d ", m[x]);
		}
		System.out.println();
	}
}
