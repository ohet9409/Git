import java.util.Scanner;
/** if�� �̿��ؼ� �Ʒ��� ����, �빮�ڴ� �ҹ��ڷ� �ҹ��ڴ� �빮�ڷ� ����� �������� �ۼ��ϼ��� */
public class Prac4 {
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		char i;
		// �Է�
		System.out.print("���� �Է�: ");
		i=sc.next().charAt(0);
		// ����
		// ���
		if(i>='A' && i<='Z')
			System.out.println(i + " -> "+ (char)(i+32));
		else if(i>='a' && i<='z')
			System.out.println(i + " -> "+ (char)(i-32));
		else
			System.out.println("���ڸ� �Է��ϼ���");
	}
}
