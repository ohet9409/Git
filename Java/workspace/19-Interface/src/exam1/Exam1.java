package exam1;

public class Exam1 {
	public static void main(String[] args) {
		Character character = new Character("���ΰ�");
		character.walk();
		character.run();
		character.attack();
		character.shield();
		character.pickup();
		System.out.println("-------------");
		Monster monster = new Monster("�Ǵ�");
		monster.walk();
		monster.run();
		monster.attack();
		monster.shield();
		System.out.println("-----------------");
		Action action = new Character("�׽�Ʈ");	// ������ �߻����� ������, Action�� �ִ� �͸� ����� �� �ִ�.
												// ���� ������ �Լ��� ����ϰ� ������, Character ������ ����� ����ؾ���
		Character ch = (Character)action;
		ch.walk();
		ch.run();
		ch.attack();
		ch.shield();
	}
}
