import java.util.HashMap;
import java.util.Map;

public class Exam1 {

	public static void main(String[] args) {
		// ���ʸ� ==> <���� �̸�, ���� ����> => �ݵ�� Ŭ���� �̸��� �־�� �Ѵ�.
		Map<String, Integer> map = new HashMap<String, Integer>();
		// �������� �߰��� put�޼ҵ� ���
		// Ư¡ : ������ ����, �̸��� �ߺ��� ������� �ʴ´�.
		map.put("aaa", 111);
		map.put("bbb", 222);
		map.put("ccc", 444);
		map.put("aaa", 555);
		map.put("ddd", null); // ��ü�� �ִ� ���̹Ƿ� null ��� ����
		// ����� ������ ���� ���
		System.out.println("Map size : " + map.size());
		// ������ ������
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));

		System.out.println(map.get("ccc"));
		System.out.println(map.get("ddd"));
		// ������ ����
		map.remove("aaa");

		// ����� ������ ���� ���
		System.out.println("Map size : " + map.size());
		// ������ ������
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		System.out.println(map.get("ddd"));
		System.out.println(map.get("test")); // �̸��� ���� �����ʹ� null�� ���

		map.clear();

		// ����� ������ ���� ���
		System.out.println("Map size : " + map.size());
		// ������ ������
		System.out.println(map.get("aaa"));
		System.out.println(map.get("bbb"));
		System.out.println(map.get("ccc"));
		System.out.println(map.get("ddd"));
		System.out.println(map.get("test")); // �̸��� ���� �����ʹ� null�� ���
	}

}
