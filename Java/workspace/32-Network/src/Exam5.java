import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam5 {

	public static void main(String[] args) {
		InetAddress inetAddress = null;		// ���ͳ� �ּҿ� ���� ������ �ٷ�� Ŭ����
		Socket socket = null;	// ���μ������� ����� ���, InputStream�� OutputStream�� ������ �ִ�. �� �� ��Ʈ���� ���� ���μ������� ���(�����)�� �̷������.
		PrintWriter out = null;	// �־��� �����͸� ���� ��� ��Ʈ���� ����ϰ� �ȴ�.
		
		try {
			inetAddress = InetAddress.getLocalHost();
			socket = new Socket(inetAddress,12345);
			out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // ��Ʈ��ũ������ ��������
//			out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));	// ����ͷ� ��������
		} catch (UnknownHostException e) {
			System.out.println("IP �ּҸ� �о�� ���� �����ϴ�.");
			System.exit(-1);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���� ���� : " + e.toString());
			System.exit(-1);
//			e.printStackTrace();
		}
		// "\n"�� Ư�� ������ ������ ���� ��Ÿ���� �����̴�.
		out.println("ȫ�浿"+"\n");
		out.flush();	// ���� ����
		out.close();

	}

}
