package exam1;

public class Exam1 {
	public static void main(String[] args) {
		Character character = new Character("주인공");
		character.walk();
		character.run();
		character.attack();
		character.shield();
		character.pickup();
		System.out.println("-------------");
		Monster monster = new Monster("악당");
		monster.walk();
		monster.run();
		monster.attack();
		monster.shield();
		System.out.println("-----------------");
		Action action = new Character("테스트");	// 에러는 발생하지 않지만, Action에 있는 것만 사용할 수 있다.
												// 만일 나머지 함수를 사용하고 싶으면, Character 변수를 만들어 사용해야함
		Character ch = (Character)action;
		ch.walk();
		ch.run();
		ch.attack();
		ch.shield();
	}
}
