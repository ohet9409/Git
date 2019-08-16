import java.util.HashMap;
import java.util.Map;

public class Exam1 {

	public static void main(String[] args) {
		// 제너릭 ==> <값의 이름, 값의 종류> => 반드시 클래스 이름을 주어야 한다.
		Map<String, Integer> map = new HashMap<String, Integer>();
		// 데이터의 추가는 put메소드 사용
		// 특징 : 순서가 없고, 이름은 중복을 허용하지 않는다.
		map.put("aaa", 111);
		map.put("bbb", 222);
		map.put("ccc", 444);
		map.put("aaa", 555);
		map.put("ddd", null); // 객체를 넣는 것이므로 null 사용 가능
		// 저장된 데이터 갯수 얻기
		System.out.println("Map size : " + map.size());
		// 데이터 꺼내기
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));

		System.out.println(map.get("ccc"));
		System.out.println(map.get("ddd"));
		// 데이터 삭제
		map.remove("aaa");

		// 저장된 데이터 갯수 얻기
		System.out.println("Map size : " + map.size());
		// 데이터 꺼내기
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		System.out.println(map.get("ddd"));
		System.out.println(map.get("test")); // 이름이 없는 데이터는 null값 출력

		map.clear();

		// 저장된 데이터 갯수 얻기
		System.out.println("Map size : " + map.size());
		// 데이터 꺼내기
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		System.out.println(map.get("ddd"));
		System.out.println(map.get("test")); // 이름이 없는 데이터는 null값 출력
	}

}
