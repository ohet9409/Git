import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;

import org.omg.CORBA.PUBLIC_MEMBER;

class Event3 extends Frame{
	Button button = new Button("Ȯ��");
	public  Event3() {
		// frame ����
		setTitle("Event �͸� Ŭ���� ���");
		setSize(300, 200);
		init();		// ȭ�� ����
		start();	// �̺�Ʈ ����
		setVisible(true);
		
	}
	private void start() {
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		}
	// ȭ�� ����
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
		
	}
	
	
}
public class Exam3 {

	public static void main(String[] args) {
		Event3 event3 = new Event3();

	}

}
