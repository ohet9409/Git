import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

class Form3 extends Frame{
	private Button button;
	
	Form3() {
		button = new Button("Ȯ��");
		// Frame ����
		setTitle("�⺻ȭ��3");
		setSize(300,200);
		
		init();		// ȭ�� ����
		start();	// �̺�Ʈ ����
		
		setVisible(true);
	}
	// ȭ�� ����
	private void init() {
		setLayout(null);	// ȭ�� ���ҿ� Layout�� ������� �ʰڴٰ� ����
		button.setBackground(Color.YELLOW);
		button.setBounds(100, 100, 80, 30);
		add(button);
	}
	// �̺�Ʈ ����
	private void start() {
		
	}
}
public class Exam3 {

	public static void main(String[] args) {
		Form3 form3 = new Form3();
		

	}

}
