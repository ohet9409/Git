import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam5 {

	public static void main(String[] args) {
		InetAddress inetAddress = null;		// 인터넷 주소에 관한 정보를 다루는 클래스
		Socket socket = null;	// 프로세스간의 통신을 담당, InputStream과 OutputStream을 가지고 있다. 이 두 스트림을 통해 프로세스간의 통신(입출력)이 이루어진다.
		PrintWriter out = null;	// 주어진 데이터를 문자 출력 스트림에 출력하게 된다.
		
		try {
			inetAddress = InetAddress.getLocalHost();
			socket = new Socket(inetAddress,12345);
			out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); // 네트워크쪽으로 내보낸다
//			out =new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));	// 모니터로 내보내기
		} catch (UnknownHostException e) {
			System.out.println("IP 주소를 읽어올 수가 없습니다.");
			System.exit(-1);
//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("접속 오류 : " + e.toString());
			System.exit(-1);
//			e.printStackTrace();
		}
		// "\n"은 특정 내용의 전송의 끝을 나타내는 문자이다.
		out.println("홍길동"+"\n");
		out.flush();	// 버퍼 비우기
		out.close();

	}

}
