import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam2 {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;		// 서버만들기
		Socket socket = null;					// 접속관리
		
		try {
			serverSocket = new ServerSocket(12345);	
			System.out.println("Server Ready...");
		} catch (IOException e) {
			System.out.println("해당 포트가 열려 있습니다.");	// 다른곳에서 이미 사용되어 질 때 
			System.exit(-1);	// 비정상적으로 종료될때는 음수값을 주고, 정상적으로 종료될때에는 0을 준다.
		}
		
		try {
			// 클라이언트로 부터 들어오는 정보를 기다리는 Method
			socket = serverSocket.accept();
			System.out.println("접속자 정보 : " + socket.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
