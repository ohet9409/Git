import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Exam3 {
	public static void main(String[] args) {
		// 제너릭<저장될 데이터 자료형>
		// 특징 : 순서가 없음, 데이터 중복허용 안함
		Set<String> set = new HashSet<String>();
		// 데이터 저장
		set.add("호랑이");
		set.add("사자");
		set.add("호랑이"); // 중복 허용 x
		set.add("코끼리");
		set.add("기린");
		// 갯수 확인
		System.out.println("갯수 : " + set.size());
		// 데이터 확인
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// 데이터 삭제
		it = set.iterator();
		while (it.hasNext()) {
			if (it.next().equals("코끼리")) {
				it.remove();
			}
		}
		// 갯수 확인
		System.out.println("갯수 : " + set.size());
		// 데이터 확인
		it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
