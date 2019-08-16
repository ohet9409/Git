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
	// ������ ȭ���
	Container container = getContentPane();
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);
	JTextField textField = new JTextField();
	// ��ſ�
	Socket socket;
	PrintWriter out;
	BufferedReader in;
	String str;
	
	public ClientGui(String ip, int port) {
		// JFrame ����
		setTitle(this.getClass().getName());
		setSize(550,400);
		setLocation(1000, 300);
		
		init();		// ȭ�� ����
		start();	// �̺�Ʈ ����
		
		setVisible(true);
		
		// ��� �ʱ�ȭ
		initNet(ip, port);
	}
	// ��� �ʱ�ȭ
	private void initNet(String ip, int port) {
		System.out.println(this.getClass().getName()+"1. Start -->");
		try {
			socket = new Socket(ip, port);
			System.out.println(this.getClass().getName()+"2. Socket -->");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
			System.out.println(this.getClass().getName()+"3. InputOutput -->");
		} catch (UnknownHostException e) {
			System.out.println("IP �ּҰ� �����ϴ�.");
			
		} catch (IOException e) {
			System.out.println("���� ����");

		}
		// ������ ����
		Thread thread = new Thread(this);
		thread.start();
	}
	private void init() {
		container.setLayout(new BorderLayout());
		container.add("Center",scrollPane);
		container.add("South",textField);
//		textArea ���� ����
		textArea.setEditable(false);
		textArea.setBackground(new Color(240, 240, 240));
	}
	private void start() {
		// x��ư ���� ó��
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// textField �̺�Ʈ ����
		textField.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String strInput = textField.getText();
		out.println(strInput);	// ���������� ���ڿ� ����
		textField.setText("");	// ���鸸���
	}
	// �����κ��� �������� ���޵� ���ڿ��� �о, textArea�� ����ϱ�
	@Override
	public void run() {
		System.out.println(this.getClass().getName()+"4. run -->");		// -> ������ ����
		try {
			while(true) {
				str = in.readLine();
				textArea.append(str + "\n");	// --> textArea�� ���ڿ� �߰�
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		
	}
	


}
