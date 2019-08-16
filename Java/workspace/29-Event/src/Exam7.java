import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ScoreFrame extends Frame implements ActionListener {
	Button button1 = new Button("�Է�");
	Button button2 = new Button("���");
	Label labelKor = new Label("����");
	Label labelEng = new Label("����");
	Label labelTot = new Label("  ���� : ");
	Label labelAvg = new Label("  ��� : ");
	TextField textFieldKor = new TextField(25);
	TextField textFieldEng = new TextField(25);
	Panel panelButton = new Panel();
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelBind = new Panel();
	BorderLayout borderLayout = new BorderLayout();
	GridLayout gridLayoutButton = new GridLayout(1, 2); // �Է� ~ ���
	GridLayout gridLayoutBind = new GridLayout(4, 1); // ���� ~ ���
	FlowLayout flowLayoutSubject = new FlowLayout(FlowLayout.LEFT); // ���� (���ʿ��� ���������� ��ġ)

	public ScoreFrame() {
		// frame ����
		setTitle("Score");
		setSize(300, 200);
		setLocation(1300, 300);
		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);
	}

	private void init() {
		// frame layout ����
		setLayout(borderLayout);
		// ���� �г� ����
		panelKor.setLayout(flowLayoutSubject);
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// ���� �г� ����
		panelEng.setLayout(flowLayoutSubject);
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// ���� �г� ����
		panelBind.setLayout(gridLayoutBind);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(labelTot);
		panelBind.add(labelAvg);
		// button �г� ����
		panelButton.setLayout(gridLayoutButton);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.YELLOW);
		panelButton.add(button1);
		panelButton.add(button2);
		// frame�� ��ġ
		add("Center", panelBind);
		add("South", panelButton);
	}

	private void start() {
		// frame â�� x��ư ���� ó��
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
		// Button �̺�Ʈ ����
		button1.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			int kor = Integer.parseInt(textFieldKor.getText().trim()); //.trim �յ� ���鹮�� ���ֱ�
			int eng = Integer.parseInt(textFieldEng.getText().trim());
			int tot = kor + eng;
			double avg = (double)tot/2;
			labelTot.setText("  ���� : " + tot);
			labelAvg.setText("  ��� : " + avg);
		} else if (e.getSource() == button2) {
			textFieldKor.setText(" ");
			textFieldEng.setText(" ");
			labelTot.setText("  ���� : ");
			labelAvg.setText("  ��� : ");
		}
	}

}

public class Exam7 {

	public static void main(String[] args) {
		ScoreFrame scoreFrame = new ScoreFrame();

	}

}
