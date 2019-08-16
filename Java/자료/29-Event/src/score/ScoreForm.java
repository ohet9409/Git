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

public class ScoreForm extends Frame implements ActionListener{
	Button button1 = new Button("�Է�");
	Button button2 = new Button("���");
	Button button3 = new Button("�й��˻�");
	Button button4 = new Button("�̸��˻�");
	Button button5 = new Button("��������");
	Button button6 = new Button("�����б�");
	Label labelHak = new Label("�й�");
	Label labelName = new Label("�̸�");
	Label labelKor = new Label("����");
	Label labelEng = new Label("����");
	Label labelMat = new Label("����");
	TextField textFieldHak = new TextField(20);
	TextField textFieldName = new TextField(20);
	TextField textFieldKor = new TextField(20);
	TextField textFieldEng = new TextField(20);
	TextField textFieldMat = new TextField(20);
	TextArea textArea = new TextArea();
	Panel panelHak = new Panel();
	Panel panelName = new Panel();
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelMat = new Panel();
	Panel panelBind = new Panel();
	Panel panelCenter = new Panel();
	Panel panelBtn = new Panel();
	// ��ü ����� �����ϴ� ScoreImpl ��ü ����
	ScoreImpl scoreImpl = new ScoreImpl();
	
	public ScoreForm() {
		// Frame ����
		setTitle("���� ����");
		setSize(700, 250);
		setLocation(1200, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// PanelBtn ����
		panelBtn.setLayout(new GridLayout(1, 6));
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.YELLOW);
		button3.setBackground(Color.YELLOW);
		button4.setBackground(Color.YELLOW);
		button5.setBackground(Color.YELLOW);
		button6.setBackground(Color.YELLOW);
		panelBtn.add(button1);
		panelBtn.add(button2);
		panelBtn.add(button3);
		panelBtn.add(button4);
		panelBtn.add(button5);
		panelBtn.add(button6);
		// PanelHak ����
		panelHak.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelHak.add(labelHak);
		panelHak.add(textFieldHak);
		// PanelName ����
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelName.add(labelName);
		panelName.add(textFieldName);
		// PanelKor ����
		panelKor.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// PanelEng ����
		panelEng.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// PanelMat ����
		panelMat.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelMat.add(labelMat);
		panelMat.add(textFieldMat);
		// PanelBind ����
		panelBind.setLayout(new GridLayout(5, 1));
		panelBind.add(panelHak);
		panelBind.add(panelName);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(panelMat);
		// PanelCenter ����	
		panelCenter.setLayout(new GridLayout(1, 2));
		panelCenter.add(panelBind);
		panelCenter.add(textArea);
		// Frame ����
		setLayout(new BorderLayout());
		add("Center", panelCenter);
		add("South", panelBtn);
	}
	private void start() {
		// Frame â�� x��ư ���� ó��
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scoreImpl.pgmEnd();
			}
		});
		// ��ư �̺�Ʈ ����
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {	// �Է�
			try {
				String hak = textFieldHak.getText();
				String name = textFieldName.getText();			
				int kor = Integer.parseInt(textFieldKor.getText().trim());
				int eng = Integer.parseInt(textFieldEng.getText().trim());
				int mat = Integer.parseInt(textFieldMat.getText().trim());
				int tot = kor + eng + mat;
				double avg = (double) tot / 3;
				
				ScoreVO vo = new ScoreVO();
				vo.setHak(hak); 
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				vo.setTot(tot);
				vo.setAvg(avg);
				scoreImpl.input(vo);
				textArea.setText("�ԷµǾ����ϴ�.");
				
				textFieldHak.setText("");
				textFieldName.setText("");
				textFieldKor.setText("");
				textFieldEng.setText("");
				textFieldMat.setText("");
			} catch(Exception err) {
				textArea.setText("[���] �Է°��� ���� ���� �ֽ��ϴ�.");
			}
		} else if(e.getSource() == button2) {	// ���
			String result = scoreImpl.print();
			textArea.setText(result);
		} else if(e.getSource() == button3) {	// �й��˻�
			String hak = textFieldHak.getText();
			String result = scoreImpl.searchHak(hak);
			textArea.setText(result);
		} else if(e.getSource() == button4) {	// �̸��˻�
			String name = textFieldName.getText();
			String result = scoreImpl.searchName(name);
			textArea.setText(result);
		} else if(e.getSource() == button5) {	// ��������
			scoreImpl.writeFile();
			textArea.setText("���� ���� ����");
		} else if(e.getSource() == button6) {	// �����б�
			scoreImpl.readFile();
			textArea.setText("���� �б� ����");
		} 
	}
}






