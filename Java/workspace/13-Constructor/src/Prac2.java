class Address{
	String name, phone, add;
	Address(String name, String phone, String add){	// ������ ����
		this.name = name;
		this.phone = phone;
		this.add = add;
	}
	void showAddress(){
		System.out.println("�̸� : " + name);
		System.out.println("��ȭ : " + phone);
		System.out.println("�ּ� : " + add);
	}
}
public class Prac2 {
	public static void main(String[] args) {
		Address a1;
		a1 = new Address("ȫ�浿", "010-1234-5678", "����� ������ ���ﵿ"); // �������� ������ ����
		a1.showAddress();	// AddressŬ�������� �Լ��� �����Ŵ
	}
}
