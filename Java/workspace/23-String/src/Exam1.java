
public class Exam1 {

	public static void main(String[] args) {
		// String ��ü�� ���� ���
		String str1 = "�ڹ� Programming";
		String str2 = new String("java");
		System.out.println("str1 : " + str1);
		System.out.println("str2 : " + str2);
		System.out.println("------------------");
		// 1) ���ڿ��� ���̸� ��ȸ
		int str1_len = str1.length();
		System.out.println("str1_len : " + str1_len);	// ���鵵 ���ڼ��� ����
		// 2) Ư�� ���ڿ��� ó������ ��Ÿ���� ��ġ�� ��ȸ
		int str1_pos = str1.indexOf("Pro");				// ���ڿ��� ���ʿ��� ���������� ã�ư� (0���� ����)
		System.out.println("str1_pos : " + str1_pos);
		// 3) Ư�� ���ڿ��� ��Ÿ���� ������ ��ġ�� ��ȸ
		int str1_last_pos = str1.lastIndexOf("g");		// ���ڿ���  �����ʿ��� �������� ã�ư� (0���� ����)
		System.out.println("str1_last_pos : " +str1_last_pos);
		// 4) A�� B�� �����ϱ�
		String new_str1 = str1.replace(" ", "_");
		System.out.println("new_str1 : " + new_str1);
		System.out.println("str1 : " + str1);			// ������ �ٲ��� �ʴ´�
		// 5) ��ҹ��� ����
		String upper = str2.toUpperCase();
		System.out.println("upper : "+ upper);
		System.out.println("str2 : "+ str2);			// ������ �ٲ��� �ʴ´�
		String lower = str2.toLowerCase();
		System.out.println("lower : "+ lower);
		System.out.println("str2 : "+ str2);
		// 6) ���ڿ��� �յ� ���� ����
		String input = "     enjoy java programming     ";
		String output = input.trim();
		System.out.println(input + "test");
		System.out.println(output + "test");
		// 7) ���ڿ���  ���ϱ�
		boolean isSame = str1.equals(str2);			// ������ true  �ٸ��� false
		if(isSame) System.err.println("����!!");
		else System.out.println("�ٸ���!!");
		// 8) ���ڿ��� �ڸ���
		// ù��° �Ű����� : ������ġ
		// �ι�° �Ű����� : ����ġ
		String sub_str1 = str1.substring(0,2);
		String sub_str2 = str1.substring(3);
		int pos = str1.indexOf("P");
		String sub_str3 = str1.substring(pos, pos+3);
		System.out.println("str1 : " + str1);
		System.out.println("sub_str1 : " + sub_str1);
		System.out.println("sub_str2 : " + sub_str2);
		System.out.println("sub_str3 : " + sub_str3);
		// 9) ���Ŀ� ���� ���ڿ� ����� ���� static �޼ҵ� ���
		int yy = 2019;
		int mm = 4;
		int dd = 4;
		String gender = "����";
		String result = String.format("%d��%d��%d��%s", yy,mm,dd,gender);
		System.out.println("result : " + result);
		// 10) �־��� ���ڸ� �������� �߶󳻾 �迭�� ��ȯ 
		String src = "C++/Java/C#/Javascript/Spring/Android";
		String[] data = src.split("/");
		for(int x=0; x<data.length;x++) {
			System.out.println(data[x]);
		}	}}
