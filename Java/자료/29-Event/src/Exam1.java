import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ActionDefine implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {		
		System.exit(0);
	}	
}
class Event1 extends Frame {
	Button button;
	ActionDefine actionDefine;
	
	public Event1() {
		button = new Button("Ȯ��");
		actionDefine = new ActionDefine();
		// Frame ����
		setTitle("Event Ŭ���� �̿�");
		setSize(300, 200);
		
		init();		// ȭ�� ����
		start();	// �̺�Ʈ ����
		
		setVisible(true);
	}
	// ȭ�� ����
	private void init() {
		setLayout(null);
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// �̺�Ʈ ����
	private void start() {
		// ��ư�� �̺�Ʈ ���
		button.addActionListener(actionDefine);
	}
}
public class Exam1 {
	public static void main(String[] args) {
		Event1 event1 = new  Event1();
	}
}






