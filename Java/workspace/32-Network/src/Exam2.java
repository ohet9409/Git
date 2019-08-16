import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam2 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;		// ���������
		Socket socket = null;					// ���Ӱ���
		
		try {
			serverSocket = new ServerSocket(12345);	
			System.out.println("Server Ready...");
		} catch (IOException e) {
			System.out.println("�ش� ��Ʈ�� ���� �ֽ��ϴ�.");	// �ٸ������� �̹� ���Ǿ� �� �� 
			System.exit(-1);	// ������������ ����ɶ��� �������� �ְ�, ���������� ����ɶ����� 0�� �ش�.
		}
		
		try {
			// Ŭ���̾�Ʈ�� ���� ������ ������ ��ٸ��� Method
			socket = serverSocket.accept();
			System.out.println("������ ���� : " + socket.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
