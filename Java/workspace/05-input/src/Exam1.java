import java.io.IOException;
import java.lang.System;
// ���� �� �� �Է� ��ɾ�
// �ڵ� �ϼ� ����Ű: main + ctrl + space
// enter: \r\n
public class Exam1 {
	public static void main(String[] args) throws IOException{ // ���� ó��
		//����
		char aa =0;
		int bb =0;
		//�Է�
		System.out.print("���� = ");
		aa = (char)System.in.read(); //�������� ���ڷ� �����ؼ� ���� a\r\n
		//System.in.read();            // \r �б⸸ �ϰ� ���� ����
		//System.in.read();			//\n �б⸸ �ϰ� ���� ���Ѵ�
		
		bb = System.in.read() -48; //0�� ���� �ƽ�Ű �ڵ尪 1\r\n
		System.out.print("���� = "+bb+"\n"); //System.in.read(); �����ϸ� /r ���� �о�ͼ� ���
		
		//����
		//���
		System.out.println("aa="+ aa);
		System.out.println("bb="+ bb);
	}
}
