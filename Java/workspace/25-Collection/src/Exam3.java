import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Exam3 {
	public static void main(String[] args) {
		// ���ʸ�<����� ������ �ڷ���>
		// Ư¡ : ������ ����, ������ �ߺ���� ����
		Set<String> set = new HashSet<String>();
		// ������ ����
		set.add("ȣ����");
		set.add("����");
		set.add("ȣ����"); // �ߺ� ��� x
		set.add("�ڳ���");
		set.add("�⸰");
		// ���� Ȯ��
		System.out.println("���� : " + set.size());
		// ������ Ȯ��
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// ������ ����
		it = set.iterator();
		while (it.hasNext()) {
			if (it.next().equals("�ڳ���")) {
				it.remove();
			}
		}
		// ���� Ȯ��
		System.out.println("���� : " + set.size());
		// ������ Ȯ��
		it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
