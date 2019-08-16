import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Exam4 {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;		// 서버만들기
		Socket socket = null;					// 접속관리
		
		try {
			serverSocket= new ServerSocket(12345);
			System.out.println("Server Ready...");
		} catch (IOException e) {
			System.out.println("해당포트가 열려있습니다.");
			System.exit(-1);
//			e.printStackTrace();
		}
		try {
			// 클라이언트로 부터 들어오는 정보를 기다리는 Method
			socket = serverSocket.accept();
			System.out.println("접속자 정보 : " + socket.toString());
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));	// 문자열 한 줄 단위로 읽어온다
			String str = in.readLine();	//문자열 한 줄씩 출력한다.
			System.out.println("전송된 내용 : " + str);
			socket.close();
		} catch (IOException e) {
			System.exit(-1);
//			e.printStackTrace();
		}
	}

}
