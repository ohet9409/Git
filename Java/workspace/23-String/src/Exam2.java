
public class Exam2 {

	public static void main(String[] args) {
		String str = "student@java.com";
		int pos = str.indexOf("@");	// "@"��ġ�� ���ϱ�
		String id= str.substring(0, pos); //"@"�� ���ڱ��� �ڸ���
		String domain= str.substring(pos+1); // "@" ���� ���ڸ� �ڸ���
		System.out.println("id : "+id);
		System.out.println("domain : "+domain);
	}

}
