import java.util.Scanner;

public class Prac5 {

	public static void main(String[] args) {
		// ����: ���� �����
		Scanner sc = new Scanner(System.in);
		String name=" ";
		char gen=0;
		int age=0;
		double height=0;
		// �Է�: ������ ������ �����ϱ�
		System.out.print("Input name: ");
		name=sc.next();
		System.out.print("Input gender: ");
		gen=sc.next().charAt(0);
		System.out.print("Input age: ");
		age=sc.nextInt();
		System.out.print("Input height: ");
		height=sc.nextDouble();
		System.out.println();
		// ����: ����� ������ �����ϱ�
		// ���: ����� Ȯ���ϱ�
		System.out.println("�̸�: "+name);
		System.out.println("����: "+ ((gen == 'M')? "����":"����" ));
		// M : ���� / ������ : ����
		System.out.println("����: "+age+"��");
		System.out.println("����: " + height+"cm");
		

	}

}
