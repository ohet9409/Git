
public class Exam4 {
	public static void main(String[] args) {
		int sum=0;
		int x=1;
		while(true) {//���ǽ� �ڸ��� true�� ����ϸ�, ���ǽ��� ���ȿ� ��ġ�� �����Ӱ� ��ġ�Ҽ� ����
			
			
			sum+=x;
			x++;
			if(x>10) break;
		}
		System.out.println("sum = " +sum);
	}
}
