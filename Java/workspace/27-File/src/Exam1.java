import java.io.File;

public class Exam1 {

	public static void main(String[] args) {
		// ���� ��γ� ��� ��θ� ������ �Ķ����(=�Ű�����)�� �����Ѵ�.
		// ��Ŭ�������� ����θ� ����� ���, ���� ������Ʈ�� ������ �ȴ�.
		File f1 = new File("src/Main01.java"); // ���� or ���丮���� �˻�
		System.out.println("f1 = " + f1.toString());
		// ���޵� ��ΰ� �������� �˻�
		// �������� �ʴ� ���Ϸ� �˻��� ���, ������ false
		boolean is_file = f1.isFile();
		System.out.println("is_file = " + is_file);
		// ���޵� ��ΰ� ���丮(=����)���� �˻�
		// �������� �ʴ� ���丮�� �˻��� ���, ������ false
		boolean is_dir = f1.isDirectory();
		System.out.println("is_dir = " + is_dir);
		// ���޵� ��ΰ� ������������ �˻�
		// �������� �ʴ� ���Ϸ� �˻��� ���, ������ false
		boolean is_hidden = f1.isHidden();
		System.out.println("is_hidden = " + is_hidden);
		// ���� ��ΰ� ���
		String abs = f1.getAbsolutePath();
		System.out.println("���� ��� : " + abs);
		// �����̳� ���丮�� ���������� �����ϴ� �� �˻�
		boolean is_exist = f1.exists();
		System.out.println("is_exist = " + is_exist);
		// ���� �����
		try {
			f1.createNewFile();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		is_file = f1.isFile();
		System.out.println("is_file = " + is_file);
	
		is_dir = f1.isDirectory();
		System.out.println("is_dir = " + is_dir);
		
		is_hidden = f1.isHidden();
		System.out.println("is_hidden = " + is_hidden);

		abs = f1.getAbsolutePath();
		System.out.println("���� ��� : " + abs);
		
		is_exist = f1.exists();
		System.out.println("is_exist = " + is_exist);
		System.out.println("-------------------------------");
		// ���丮 ���� ��ü ����
		File f2 = new File("a/b/c/target");
		System.out.println("isFile = " + f2.isFile());
		System.out.println("isDirectory = " + f2.isDirectory());
		System.out.println("isHidden = " + f2.isHidden());
		System.out.println("������ = " + f2.getAbsolutePath());
		System.out.println("���翩�� = " + f2.exists());
		System.out.println("------------------------------");
		// ���丮����� 1
		f2.mkdir();
		System.out.println("���翩�� = " + f2.exists());
		System.out.println("------------------------------");
		// ���丮����� 2
		f2.mkdirs();
		System.out.println("���翩�� = " + f2.exists());
		System.out.println("------------------------------");
		
		// ������ "/" ���� �ܾ ����
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		// ó������ ������ "/" �������� ����
		System.out.println(f1.getParent());
		System.out.println(f2.getParent());
		// ����, ������ true, ���н� false
		boolean del_ok = f2.delete();
		System.out.println("���� ���� ���� : " + del_ok);
		del_ok = f1.delete();
		System.out.println("���� ���� ���� : " + del_ok);
	}

}
