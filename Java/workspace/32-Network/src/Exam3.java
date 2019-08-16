import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exam3 {
	public static void main(String[] args) {
		InetAddress inetAddress = null;
		Socket socket= null;
		
		try {
			inetAddress = InetAddress.getLocalHost();
			socket = new Socket(inetAddress,12345);
		} catch (UnknownHostException e) {
			System.out.println("IP 주소를 읽어올 수 없습니다.");
			System.exit(-1);
			//			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("접속 오류 : " + e.toString());
			System.exit(-1);
			//			e.printStackTrace();
		}
	}
}
