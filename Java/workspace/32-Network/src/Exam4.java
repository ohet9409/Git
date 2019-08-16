import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam4 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;		// ���������
		Socket socket = null;					// ���Ӱ���
		
		try {
			serverSocket= new ServerSocket(12345);
			System.out.println("Server Ready...");
		} catch (IOException e) {
			System.out.println("�ش���Ʈ�� �����ֽ��ϴ�.");
			System.exit(-1);
//			e.printStackTrace();
		}
		try {
			// Ŭ���̾�Ʈ�� ���� ������ ������ ��ٸ��� Method
			socket = serverSocket.accept();
			System.out.println("������ ���� : " + socket.toString());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	// ���ڿ� �� �� ������ �о�´�
			String str = in.readLine();	//���ڿ� �� �پ� ����Ѵ�.
			System.out.println("���۵� ���� : " + str);
			socket.close();
		} catch (IOException e) {
			System.exit(-1);
//			e.printStackTrace();
		}
	}

}
