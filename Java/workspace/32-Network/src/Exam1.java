import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exam1 {
	public static void main(String[] args) {
		InetAddress address1 = null;
		InetAddress address2 = null;
		InetAddress address3 = null;
		try {
			address1 = InetAddress.getByName("www.naver.com");
			address2 = InetAddress.getLocalHost();
			address3 = InetAddress.getByName("gn.ezenac.co.kr");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("www.naver.com = " + address1);
		System.out.println("내 컴퓨터 주소0 = " + address2);
		System.out.println("gn.ezenac.co.kr = " + address3);
	}
}
