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
		System.out.println("������ ���۵Ǿ����ϴ�.");
	}
	public void giveAndTake() {
		try {
			serverSocket= new ServerSocket(5420);
			serverSocket.setReuseAddress(true); 		// ServerSocket port�� �ٷ� �ٽ� ��� ����
			
			while(true) {
				// Ŭ���̾�Ʈ�� ���� ������ ���� ������ ��ٸ��� Method
				socket = serverSocket.accept();
				ServerSocketThread sst = new ServerSocketThread(this, socket);
				addClient(sst);
				// ������ ����
				sst.start();    // run()�Լ� ����
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	public synchronized void addClient(Thread thread) { // synchronized: �����尡 ���������͸� �Բ� ������� ���ϵ��� �ϴ� ��	
		// ����Ʈ�� ServerSocketThread �߰�
		list.add(thread);
		System.out.println("Client 1�� ����, ��"+list.size()+"��");
		
	}
	public void removeClient(Thread thread) {
		// ����Ʈ���� ServerSocketThread ����
		list.remove(thread);
		System.out.println("Client 1�� ����, ��"+list.size()+"��");
	}
	public void broadCasting(String str) {
		for(int i=0; i<list.size(); i++) {
			ServerSocketThread sst = (ServerSocketThread)list.get(i);
			sst.sendMessage(str);
		}
	}
}
