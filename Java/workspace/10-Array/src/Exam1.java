
public class Exam1 {
	public static void main(String[] args) {
		/* �迭�� ���� ���*/
		// 1. �迭�� ����� ũ�� ���� �� ���� �Ҵ翡 ���� ���� ó��
		int[] hong;		// �迭��, ���۷��� ����: �ּҸ� �����ϴ� ����
		hong = new int[3];	
		hong[0]=75;
		hong[1]=82;
		hong[2]=95;
		// 2. �迭�� ����� ũ�� ������ �ϰ� ó��
		int[] kim =new int[3];
		kim[0]=88;
		kim[1]=64;
		kim[2]=70;
		// 3. �迭 ������ �ϰ� ó��
		int[] lee = new int[] {100,95,90};
		//int[] lee = {100,95,90};			//new int[]�� ������ �� ����
		
		int[] sum = {0,0,0};
		String[] name= {"ȫ�浿","��ö��","�̿���"};
		// �� �迭 ����� ���� ���� �հ豸�ϱ�
		for(int x=0; x<hong.length; x++) {
			sum[0] += hong[x];
		}
		for(int x=0;x<3;x++) {
			sum[1]+=kim[x];
		}
		for(int x=0;x<lee.length;x++) {
			sum[2]+=lee[x];
		}
		// ����� ���
		for(int x=0; x<3; x++) {
			System.out.println(name[x]+" = " + (double)sum[x]/hong.length);
		}
	}
}
