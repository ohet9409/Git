package chatting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerSocketThread extends Thread{
	Socket socket;
	ChatServer server;
	PrintWriter out;
	BufferedReader in;
	String name;
	String threadName = "Thread";
	
	public ServerSocketThread(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		threadName = getName();	// Thread Ŭ������ �̸��� ������ �´�.
		System.out.println(socket.getInetAddress()+"���� �����Ͽ����ϴ�.");
		System.out.println("Thread Name : " +threadName);
	}
	public void sendMessage(String str) {
		out.println(str);
	}
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			//true : (autoFlush ����)���� �ڵ� ��� ����
			sendMessage("��ȭ�� �̸��� �������� : ");
			name = in.readLine();
			server.broadCasting("["+name+"]���� ���� �ϼ̽��ϴ�.");
			while(true) {
				String strin = in.readLine() ;
				server.broadCasting("["+name+"]"+strin);
			}
		} catch (IOException e) {	// ������ �������� ���
			System.out.println(threadName + " �����߽��ϴ�.");
			server.removeClient(this);
//			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
			}
		}
		
	}

}
