import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// Integer.parseInt(br.readLine()) : ���ڿ� ������ �о�ͼ� ���������� �����Ѵ�.
// readLine() : ������ �д´�. "\n", "\r"�� ������ ���� �о�´�.

public class Exam2 {
	public static void main(String[] args) throws IOException{
		//����
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		// ���ڿ��� br��ü�� �Է¹޾Ƽ� �����Ѵ�.
		String name;
		int kor, eng, mat, tot;
		//�Է�
		System.out.print("�̸�? ");
		name = br.readLine();
		System.out.print("����? ");
		kor = Integer.parseInt(br.readLine()); //readLine:��� �����͸� ���ڿ��� �о��  // Integer.~: ���ڿ��� ������ ��ȯ
		System.out.print("����? ");
		eng = Integer.parseInt(br.readLine());
		System.out.print("����? ");
		mat = Integer.parseInt(br.readLine());
		//����
		tot = kor + eng + mat;
		//���
		System.out.println("�̸�: "+ name);
		System.out.println("����: "+ tot);
	}

}
