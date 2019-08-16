package chatting;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ClientGui extends JFrame implements ActionListener,Runnable{
	// 윈도우 화면용
	Container container = getContentPane();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	JTextField textField = new JTextField();
	// 통신용
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String str;
	
	public ClientGui(String ip, int port) {
		// JFrame 설정
		setTitle(this.getClass().getName());
		setSize(550,400);
		setLocation(1000, 300);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
		
		// 통신 초기화
		initNet(ip, port);
	}
	// 통신 초기화
	private void initNet(String ip, int port) {
		System.out.println(this.getClass().getName()+"1. Start -->");
		try {
			socket = new Socket(ip, port);
			System.out.println(this.getClass().getName()+"2. Socket -->");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			System.out.println(this.getClass().getName()+"3. InputOutput -->");
		} catch (UnknownHostException e) {
			System.out.println("IP 주소가 없습니다.");
			
		} catch (IOException e) {
			System.out.println("접속 실패");

		}
		// 쓰레드 시작
		Thread thread = new Thread(this);
		thread.start();
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center",scrollPane);
		container.add("South",textField);
//		textArea 편집 금지
		textArea.setEditable(false);
		textArea.setBackground(new Color(240, 240, 240));
	}
	private void start() {
		// x버튼 종료 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// textField 이벤트 설정
		textField.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String strInput = textField.getText();
		out.println(strInput);	// 서버쪽으로 문자열 전달
		textField.setText("");	// 공백만들기
	}
	// 서버로부터 응답으로 전달된 문자열을 읽어서, textArea에 출력하기
	@Override
	public void run() {
		System.out.println(this.getClass().getName()+"4. run -->");		// -> 스레드 구동
		try {
			while(true) {
				str = in.readLine();
				textArea.append(str + "\n");	// --> textArea에 문자열 추가
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	


}
