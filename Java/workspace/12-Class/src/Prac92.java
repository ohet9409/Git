class Sum{
	// ����
	int tot;
	// �Է�
	// ����
	void sum() {
		for(int i=1; i<=100; i++) {
			tot += i;
			if(i%10 == 0) {		// 10�ǹ�� �� ���
				System.out.printf("%2d ~ %3d = %3d\n",i-9,i,tot);
				tot=0;
			}
		}
	}
	// ���
}
public class Prac92 {
	public static void main(String[] args) {
		Sum sum = new Sum();
		sum.sum();
	}
}
