import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class Exam2 {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(300, 200);
		frame.setTitle("�⺻ȭ��");
		frame.setLayout(null); 	// ȭ�� ���ҿ� Layout�� ������� ����
		Button button = new Button("Ȯ��");
		button.setBackground(Color.yellow);
		// ��ư�� ��ġ�� ũ�� ����
//		// public void setBounds(int x,
//                int y,
//                int width,
//                int height)
		button.setBounds(100, 100, 80, 30);
		frame.add(button);
		frame.setVisible(true);
	}

}
