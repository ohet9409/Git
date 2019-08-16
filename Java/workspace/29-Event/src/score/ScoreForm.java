package score;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ScoreForm extends Frame implements ActionListener {
	ScoreVO vo = new ScoreVO();
	// layout
	BorderLayout borderLayout = new BorderLayout();
	FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
	GridLayout gridLayoutButton = new GridLayout(1, 6); // 1�� 6��
	GridLayout gridLayoutBind = new GridLayout(5, 1); // 5�� 1��
	// button
	Button bu_input = new Button("�Է�");
	Button bu_print = new Button("���");
	Button bu_SH = new Button("�й��˻�");
	Button bu_SN = new Button("�̸��˻�");
	Button bu_SF = new Button("��������");
	Button bu_RF = new Button("�����б�");
	// label
	Label label_hak = new Label("�й�");
	Label label_name = new Label("�̸�");
	Label label_kor = new Label("����");
	Label label_eng = new Label("����");
	Label label_math = new Label("����");
	// textfield
	TextField text_hak = new TextField(20);
	TextField text_name = new TextField(20);
	TextField text_kor = new TextField(20);
	TextField text_eng = new TextField(20);
	TextField text_math = new TextField(20);
	// panel
	Panel panelbutton = new Panel(); // ��ư ����
	Panel panel_hak = new Panel();
	Panel panel_name = new Panel();
	Panel panel_kor = new Panel();
	Panel panel_eng = new Panel();
	Panel panel_math = new Panel();
	Panel panelBind = new Panel(); // �й� , �̸�, ����, ����, ���� ����
	Panel panelCenter = new Panel(); // bind, textarea ����
	// textarea
	TextArea textArea = new TextArea();
	// ��ü ����� �����ϴ� ScoreImpl ��ü ����
	ScoreImpl impl = new ScoreImpl();

	public ScoreForm() {
		// frame ����
		setTitle("��������");
		setSize(700, 300);
		setLocation(300, 300);
		init();					// ȭ�� ����
		start();				// �̺�Ʈ ����
		setVisible(true);
	}

	private void init() {
		// �й�
		panel_hak.setLayout(flowLayout);
		panel_hak.add(label_hak);
		panel_hak.add(text_hak);
		// �̸�
		panel_name.setLayout(flowLayout);
		panel_name.add(label_name);
		panel_name.add(text_name);
		// ����
		panel_kor.setLayout(flowLayout);
		panel_kor.add(label_kor);
		panel_kor.add(text_kor);
		// ����
		panel_eng.setLayout(flowLayout);
		panel_eng.add(label_eng);
		panel_eng.add(text_eng);
		// ����
		panel_math.setLayout(flowLayout);
		panel_math.add(label_math);
		panel_math.add(text_math);
		// button
		panelbutton.setLayout(gridLayoutButton); // 1�� 6��(��ư ����)
		panelbutton.add(bu_input);
		panelbutton.add(bu_print);
		panelbutton.add(bu_SH);
		panelbutton.add(bu_SN);
		panelbutton.add(bu_SF);
		panelbutton.add(bu_RF);
		bu_input.setBackground(Color.YELLOW);
		bu_print.setBackground(Color.YELLOW);
		bu_SF.setBackground(Color.YELLOW);
		bu_SH.setBackground(Color.YELLOW);
		bu_SN.setBackground(Color.YELLOW);
		bu_RF.setBackground(Color.YELLOW);
		// bind
		panelBind.setLayout(gridLayoutBind); // 5�� 1��(�Է� ����)
		panelBind.add(panel_hak);
		panelBind.add(panel_name);
		panelBind.add(panel_kor);
		panelBind.add(panel_eng);
		panelBind.add(panel_math);
		// panel center
		panelCenter.setLayout(new GridLayout(1, 3));
		panelCenter.add(panelBind);
		panelCenter.add(textArea);
		// frame
		setLayout(borderLayout);
//		add("West", panelBind);
		add("South", panelbutton);
		add("Center", panelCenter);
//		add("East", textArea);

	}

	private void start() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
				impl.pgmEnd();
				super.windowClosing(e);
			}
		});
		// ��ư �̺�Ʈ ����
		bu_input.addActionListener(this);	// ���콺, ����Ű ���� �۵�
		bu_print.addActionListener(this);
		bu_SH.addActionListener(this);
		bu_SN.addActionListener(this);
		bu_SF.addActionListener(this);
		bu_RF.addActionListener(this);
//		// text �̺�Ʈ ����
//		text_hak.addActionListener(this);
//		text_name.addActionListener(this);
//		text_kor.addActionListener(this);
//		text_eng.addActionListener(this);
//		text_math.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bu_input) { // �Է�
			try {
				String hak = text_hak.getText().trim();
				String name = text_name.getText().trim();
				int kor = Integer.parseInt(text_kor.getText().trim());
				int eng = Integer.parseInt(text_eng.getText().trim());
				int math = Integer.parseInt(text_math.getText().trim());
				int tot = kor + eng + math;
				double avg = tot / 3.0;
				ScoreVO vo = new ScoreVO(); // ������ ���
				vo.setHak(hak);
				vo.setName(name);
				vo.setEng(eng);
				vo.setKor(kor);
				vo.setMat(math);
				vo.setTot(tot);
				vo.setAvg(avg);
				impl.input(vo);	// impl�� �����ϴ�  list�� �߰���Ų��
				textArea.setText("�ԷµǾ����ϴ�.");
				
			} catch (Exception e1) {
				textArea.setText("[���] �Է°��� ���� ���� �ֽ��ϴ�.");
			}
		} else if (e.getSource() == bu_print) { // ���

			String result = impl.print();
			textArea.setText(result);

		} else if (e.getSource() == bu_SH) { // �й� �˻�
			String hak = text_hak.getText().trim();
			String result = impl.searchHak(hak);
			textArea.setText(result);
		} else if (e.getSource() == bu_SN) { // �̸� �˻�
			String name = text_name.getText().trim();
			String result = impl.searchName(name);
			textArea.setText(result);
		} else if (e.getSource() == bu_SF) { // ���� ����
			impl.writeFile();
			textArea.setText("���� ���� ����");
		} else if (e.getSource() == bu_RF) { // ���� �б�
			impl.readFile();
		}
		textArea.setCaretPosition(textArea.getText().length());
		text_hak.setText(" ");
		text_name.setText(" ");
		text_kor.setText(" ");
		text_eng.setText(" ");
		text_math.setText(" ");
	}

}
