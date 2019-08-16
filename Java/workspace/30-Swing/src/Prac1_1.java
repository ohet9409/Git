import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

class SwingPrac1 extends JFrame {
	Container container = getContentPane();
	// �������� ����
	JLabel labelName = new JLabel("�̸�: ", JLabel.RIGHT);
	JLabel labelJu = new JLabel("�ֹι�ȣ: ", JLabel.RIGHT);
	JLabel labelTel = new JLabel("��ȭ��ȣ: ", JLabel.RIGHT);
	JLabel labelAddr = new JLabel("�ּ�: ", JLabel.RIGHT);

	JTextField textFieldName = new JTextField(14); // �ؽ�Ʈ �ʵ� ũ�� ����
	JTextField textFieldJu1 = new JTextField(7);
	JTextField textFieldJu2 = new JTextField(7);
	JTextField textFieldTel = new JTextField(14);
	JTextField textFieldAddr = new JTextField(14);
	// �������� �� ���߱�
	JPanel panelLU = new JPanel(); // ��ü�� �����ִ� �г�
	JPanel panelLable = new JPanel(); // ���̺��� �����ִ� �г�
	JPanel panelText = new JPanel(); // textField�� �����ִ� �г�
	JPanel panelJu = new JPanel();	// �ֹι�ȣ textField�� �����ִ� �г�
	// ----------------------------------------------------//
	// �����˻� ����
	JLabel labelS = new JLabel("�˻� : ");
	JTextField textFieldS1 = new JTextField(7);
	JTextField textFieldS2 = new JTextField(7);
	JTextArea textAreaS = new JTextArea();
	JScrollPane scrollPaneS = new JScrollPane(textAreaS);
	JButton buttonS = new JButton("�˻�");
	JButton buttonAL = new JButton("<<");
	JButton buttonAR = new JButton(">>");

	JPanel panelLD = new JPanel(); // ��ü�� �����ִ� �г�
	JPanel panelS = new JPanel(); // �˻������ �����ִ� �г�
	JPanel panelBtn = new JPanel(); // ��ư�� �����ִ� �г�
	JPanel panelSC = new JPanel(); 	// �˻� textField �����ִ� �г�
	// ----------------------------------------------------//
	// ��������Ȯ�� ����
	JLabel labelR = new JLabel("<== �̰��� ������ ��ü���Ⱑ �˴ϴ�.");
	JTextArea textAreaR = new JTextArea();
	JScrollPane jScrollPaneR = new JScrollPane(textAreaR);
	JButton buttonR = new JButton("��ü����");
	JButton button1 = new JButton("���");
	JButton button2 = new JButton("����");
	JButton button3 = new JButton("����");
	JButton button4 = new JButton("Clear");
	JButton button5 = new JButton("����");
	JButton button6 = new JButton("�ε�");
	JButton button7 = new JButton("����");
	
	JPanel panelR = new JPanel(); 		// ��ü�� �����ִ� �г�
	JPanel panelRT = new JPanel();  	// ��ü���⸦ �����ִ� �г�
	JPanel panelRB = new JPanel();		// ��ư�� �����ִ� �г�
	//-------------------------------------------------------//
	JPanel panelL = new JPanel();	// ������������ + �����˻������� �����ִ� panel

	public SwingPrac1() {
		// JFrame ����
		setTitle("SwingPrac1");
		setSize(720, 400);
		setLocation(1100, 300);
		setResizable(false); // â ũ�⺯ȯ ����

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("West",panelL);
		container.add("Center",panelR);
		/** panelL ���� */
		panelL.setLayout(new GridLayout(2,1,3,3));
		panelL.add(panelLU);
		panelL.add(panelLD);
		/* ���� ��ܺ�*/
		panelLU.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"��������"));	// �簢ȿ���� Ÿ��Ʋ ȿ�� �ֱ�
		panelLU.setLayout(new BorderLayout());
		panelLU.add("West",panelLable);
		panelLU.add("Center",panelText);
		// panelLable ����
		panelLable.setLayout(new GridLayout(4,1));
		panelLable.add(labelName);
		panelLable.add(labelJu);
		panelLable.add(labelTel);
		panelLable.add(labelAddr);
		// panelText ����
		panelText.setLayout(new GridLayout(4,1));
		panelText.add(textFieldName);
		panelText.add(panelJu);
		
		panelText.add(textFieldTel);
		panelText.add(textFieldAddr);
		// panelJu ����
		panelJu.setLayout(new GridLayout(1,2,3,3));
		panelJu.add(textFieldJu1);
		panelJu.add(textFieldJu2);
		/* ���� �ϴܺ�*/
		panelLD.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"�����˻�"));
		panelLD.setLayout(new BorderLayout());
		panelLD.add("North",panelS);
		panelLD.add("Center",scrollPaneS);
		panelLD.add("South",panelBtn);
		// panelS ����
		panelS.setLayout(new BorderLayout());
		panelS.add("West",labelS);
		panelS.add("Center",panelSC);
		panelS.add("East",buttonS);
		// panelSC ����
		panelSC.setLayout(new GridLayout(1,2,3,3));
		panelSC.add(textFieldS1);
		panelSC.add(textFieldS2);
		// panelBtn ����
		panelBtn.setLayout(new FlowLayout());
		panelBtn.add(buttonAL);
		panelBtn.add(buttonAR);
		/** panelR ���� */
		panelR.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED),"��������Ȯ��"));
		panelR.setLayout(new BorderLayout());
		panelR.add("North",panelRT);
		panelR.add("Center",jScrollPaneR);
		panelR.add("South",panelRB);
		// panelRT ����
		panelRT.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelRT.add(buttonR);
		panelRT.add(labelR);
		// panelRB ����
		panelRB.setLayout(new GridLayout(1,7));
		panelRB.add(button1);
		panelRB.add(button2);
		panelRB.add(button3);
		panelRB.add(button4);
		panelRB.add(button5);
		panelRB.add(button6);
		panelRB.add(button7);
		
		// ��ư ��� ���� ����
		buttonS.setEnabled(false);
		buttonAL.setEnabled(false);
		buttonAR.setEnabled(false);
		buttonR.setEnabled(false);
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

public class Prac1_1 {

	public static void main(String[] args) {
		SwingPrac1 swing = new SwingPrac1();

	}

}
