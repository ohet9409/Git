import helper.FileHelper;

public class Exam4 {

	public static void main(String[] args) {
		String encType = "utf-8";
		String filePath = "myfile.txt";	// 27������Ʈ�� ���������
		String content = "�ȳ��ϼ���. �ڹ� ���α׷���";
		// ���� ����
		boolean result = FileHelper.getInstance().writeString(filePath, content, encType);
	
		if(!result) {
			System.out.println("���� ���忡 �����߽��ϴ�.");
			return; // ���� ��Ŵ
		}
		// ���� �б�
		String str = FileHelper.getInstance().readString(filePath, encType);
		System.out.println(str);
	}

}
