package exam5;
public class Exam5 {

	public static void main(String[] args) {
		// �Խ����� ��� ����
		Mysite bbs = new Mysite() {
			@Override
			public void write() {
				System.out.println("�� �� ����");

			}

			@Override
			public void delete() {
				System.out.println("�� ����");

			}
		};
		bbs.write();
		bbs.delete();
		// ȸ�� ������ ��� ����
		Mysite member = new Mysite() {

			public void write() {
				System.out.println("ȸ�� ����");
			}

			public void delete() {
				System.out.println("ȸ�� Ż��");
			}
		};
		member.write();
		member.delete();
	}

}
