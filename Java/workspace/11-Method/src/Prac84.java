import java.util.Scanner;
/** if�� �̿��ؼ� �Ʒ��� ����, �빮�ڴ� �ҹ��ڷ� �ҹ��ڴ� �빮�ڷ� ����� �������� �ۼ��ϼ��� */
public class Prac84 {
	static char input(){
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �Է� : ");
		char ch = sc.next().charAt(0);
		return ch;
	}
	static char changeChar(char ch){
		if(ch>='A' && ch<='Z')
			return (char) (ch+32);
		else if(ch>='a' && ch<='z')
			return (char)(ch-32);
		else
			return 0;
		
	}
	static void output(char ch, char result){
		if(result != 0)
		System.out.println(ch + " -> "+ result);
		else
			System.out.println("�߸� �Է��ϼ̽��ϴ�");
	}
	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		char ch, result;
		// �Է�
		ch= input();
		// ����
		result = changeChar(ch);
		// ���
		output(ch,result);
	}
}
