import java.util.Scanner;

public class Prac4 {
	// �ҹ��ڸ� �빮�ڷ� / �빮�ڸ� �ҹ��ڷ� ��ȯ
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		char ch=0, result=0;
		// �Է�
		System.out.print("���� �Է�: ");
		ch=sc.next().charAt(0);// ���� �Ѱ� �Է�
		// ����
		//          �빮������ �˻�                                                            �ҹ��� ���� �˻�
		result=(ch>='A' && ch<='Z')? (char)(ch+32) : (ch>='a' && ch<='z')? (char)(ch-32):0; 
		System.out.println((result != 0)?(ch + "->"+ result):"���ڰ� �ƴմϴ�");
		System.out.printf("%s -> %s", ch,result);

	}

}
