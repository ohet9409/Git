package exam4;

import java.util.ArrayList;
import java.util.List;

import exam4.study.java.model.People;

public class Exam4 {

	public static void main(String[] args) {
		/*	List를 사용하는 가장 일반적인 방법은
		 * 	자바빈즈를 저장하는 것이다.
		 */
		List<People> list = new ArrayList<People>();
		// 10명 데이터를 저장
		for(int x=0; x<10; x++) {
			People people = new People("java 회원" + x, "010-1234-567"+x); //10개의 people객체 생성
			list.add(people);	// 생성된 객체를 list에 저장(주소가 저장) people 객체는 참조되는 곳이 있으면 값이 삭제되지 않는다
		}
		// 저장된 데이터 확인하기
		for(int x=0; x<list.size();x++) {
			People people = list.get(x);	//people 객체에 해당 list 주소를 받아온다
			System.out.println(people.toString());	// 주소에 해당하는 값을 찾아서 출력
		}
	}

}
