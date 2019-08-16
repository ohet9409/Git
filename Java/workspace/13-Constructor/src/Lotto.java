import java.util.Random;
import java.util.Scanner;
/* �ζ�  6-45
 * 1~45 ������ ���� 6���� ����
 * 1. �ζ� ��ȣ 1��Ʈ �����
 * 2. �������� ���� ��Ű��
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
		System.out.print("���� Ƚ���� �Է��ϼ��� : ");
		buyNum = sc.nextInt();
		System.out.println();
	}
	// 1��Ʈ ��ȣ �����
	public void selectLotto() {
		boolean check= false;
		Random random = new Random();
		
		for(int i=0; i<buyNum; i++) {
			// random.nextInt(45) : 0~44 ������ ������ ������ 1�� ����
			m[0] = random.nextInt(45)+1;	//(0~44) + 1 => (1~45)
			// ������ ���� 5�� �����
			for(int a=1; a<6; ) {
				m[a] = random.nextInt(45)+1;
				check = false;
				// ���� ������� ���ڿ� �̹� ������� ���ڰ� ������ �˻�
				for(int b=0; b<a; b++) {
					if(m[a] == m[b]) {
						check = true;
					break;
					}
				}
				if(!check) a++; 	//for�� a���� ������
			}
			sort();
			outputResult();
		}
	}
	private void sort() {
		for(int x=0; x<5; x++) {		// ���ذ�
			for(int y=x+1; y<6; y++) {	// �񱳰�
				if(m[x] > m[y]) {
					int temp=m[x];
					m[x]=m[y];
					m[y]=temp;
				}
			}
		}
	}
	// ���
	private void outputResult() {
		for(int x=0; x<m.length;x++) {
		System.out.printf("%2d ", m[x]);
		}
		System.out.println();
	}
}
