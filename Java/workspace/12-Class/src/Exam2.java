// Ŭ���� ������ ��� ����
class Charactor {
	// �Ϲ������� ��������� ���� �Ѵ�.
	String name;	// �ʱⰪ = null
	int age;		// �ʱⰪ = 0 (����,�Ǽ�,����) ,  boolean �ʱⰪ  = false 
}
public class Exam2 {
	public static void main(String[] args) {
		// �ϳ��� Ŭ������ ���ǵǸ�, �� Ŭ������ ������ ������� �ϴ� 
		// �������� ������ ���(=��ü)�� ������ �� �ִ�.
		Charactor d = new Charactor();		// d��� ��ü ����
		System.out.println("�̸� : " + d.name + ", ���� : " + d.age );
		d.name = "�Ѹ�";
		d.age = 19;
		
		Charactor h = new Charactor();		// h��� ��ü ����
		h.name = "��";
		h.age = 3;
		
		System.out.println("�̸� : " + d.name + ", ���� : " + d.age );
		System.out.println("�̸� : " + h.name + ", ���� : " + h.age );
		
	}
}
