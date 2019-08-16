package chatting;


import java.util.List;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	ServerSocket serverSocket;
	Socket socket;
	List<Thread> list;
	public ChatServer() {
		list = new ArrayList<Thread>();
		System.out.println("서버가 시작되었습니다.");
	}
	public void giveAndTake() {
		try {
			serverSocket= new ServerSocket(5420);
			serverSocket.setReuseAddress(true); 		// ServerSocket port를 바로 다시 사용 설정
			
			while(true) {
				// 클라이언트로 부터 들어오는 접속 정보를 기다리는 Method
				socket = serverSocket.accept();
				ServerSocketThread sst = new ServerSocketThread(this, socket);
				addClient(sst);
				// 스레드 시작
				sst.start();    // run()함수 실행
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	public synchronized void addClient(Thread thread) { // synchronized: 쓰레드가 공유데이터를 함께 사용하지 못하도록 하는 것	
		// 리스트에 ServerSocketThread 추가
		list.add(thread);
		System.out.println("Client 1명 입장, 총"+list.size()+"명");
		
	}
	public void removeClient(Thread thread) {
		// 리스트에서 ServerSocketThread 제거
		list.remove(thread);
		System.out.println("Client 1명 퇴장, 총"+list.size()+"명");
	}
	public void broadCasting(String str) {
		for(int i=0; i<list.size(); i++) {
			ServerSocketThread sst = (ServerSocketThread)list.get(i);
			sst.sendMessage(str);
		}
	}
}
