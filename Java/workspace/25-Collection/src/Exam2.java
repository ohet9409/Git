import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Exam2 {

	public static void main(String[] args) {
		// List : 순서가 있고, 데이터 중복 허용함
		// 배열과 비슷한 기능
		List<Integer> list = new ArrayList<Integer>();
		// 데이터 추가
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.add(60);
		list.add(70);
		// 데이터의 갯수 구하기
		System.out.println("데이터 갯수 : " + list.size());
		// 5번째 값 얻기
		System.out.println("5번째 값 : " + list.get(4));
		// 5번째 값 삭제
		list.remove(4);
		// 데이터의 갯수 구하기
		System.out.println("데이터 갯수 : " + list.size());
		// 5번째 값 얻기
		System.out.println("5번째 값 : " + list.get(4));
		// 3번째 위치에 값 추가하기
		list.add(2, 123);
		// 데이터의 갯수 구하기
		System.out.println("데이터 갯수 : " + list.size());
		// 5번째 값 얻기
		System.out.println("5번째 값 : " + list.get(4));
		// 5번째 값 수정하기
		list.set(4, 500);
		// 데이터의 갯수 구하기
		System.out.println("데이터 갯수 : " + list.size());
		// 5번째 값 얻기
		System.out.println("5번째 값 : " + list.get(4));
		
		// 1. 전체 데이터 확인하기
		System.out.println("1. 전체 데이터 확인하기");
		for(int x=0; x<list.size();x++) {
			System.out.print(x+"번째 값 : "+list.get(x)+" ");
		}
		System.out.println();
		// 2. 전체 데이터 확인하기
		// Collection 클래스만 사용 가능
		System.out.println("2. 전체 데이터 확인하기");
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		// 3. 전체 데이터 확인하기
		// 확장 for문 사용 : 배열과 Collection 클래스만 사용 가능, 그 중에서 클래스는 일반적으로 List를 많이 사용
		// for(변수 : 배열 or 클래스)
		System.out.println();
		System.out.println("3. 전체 데이터 확인하기");
		for(Integer i : list) {
			System.out.print(i+" ");
		}
		System.out.println();
		// 전체 데이터 삭제
		list.clear();
		// 데이터의 갯수 구하기
		System.out.println("데이터 갯수 : " + list.size());
		// 5번째 값 얻기
//		System.out.println("5번째 값 : " + list.get(4));	-- 없는 데이터를 불러오면 에러가 난다.
	}

}
