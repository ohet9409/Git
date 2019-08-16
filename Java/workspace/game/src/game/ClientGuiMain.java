package game;

import java.net.InetAddress;
import java.net.UnknownHostException;

import chatting.ClientGui;

public class ClientGuiMain {
	public static void main(String[] args) {

			ClientGui clientGui = new ClientGui("127.0.0.1",5420);	// 자신의 pc ip주소로 인식
//			ClientGui clientGui = new ClientGui("192.168.0.53",5420);
		
		
	}
}
