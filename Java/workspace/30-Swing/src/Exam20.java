
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.DateFormatSymbols;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;

class Swing20 extends JFrame {
	Container container = getContentPane();
	JSpinner spinner1 = new JSpinner();
	JSpinner spinner2 = new JSpinner();
	JSpinner spinner3 = new JSpinner();
	JPanel panel = new JPanel();
	// spinner�� ����� ������Ʈ
	JTextField textField = new JTextField();
	// ��¥ ���� Ŭ����
	DateFormatSymbols deFormatSymbols = new DateFormatSymbols();
	String[] str = deFormatSymbols.getMonths();
	
	SpinnerListModel spinnerListModel = new SpinnerListModel(str);
	// ���� �ý����� ��¥ ���� �״�� �����´�.
	SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
	// 0~100 ������ ���ڰ�����, 50�� �⺻������ ��Ÿ����, 2�� ���� ���� ��Ų��.
	SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(50,0,100,2);
	public Swing20() {
		// JFrame ����
		setTitle("Swing20");
		setSize(300, 200);
		setLocation(1300, 300);

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);
		
		// test
//		for(int x=0; x<str.length;x++) {
//			System.out.println(str[x]);
//		}

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",panel);
		
		panel.setLayout(new GridLayout(3,1));
		panel.add(spinner1);
		panel.add(spinner2);
		panel.add(spinner3);
		// spinner1 : 1�� ~ 12�� ����
		spinner1.setModel(spinnerListModel);
		// spinner2 : ���� �ý����� ��¥
		spinner2.setModel(spinnerDateModel);
		// spinner�� TextField ������ ���� ���� ��� ����
		// Jspinner�� JTextField�� ���� ����
		textField = ((JSpinner.DateEditor)spinner2.getEditor()).getTextField();
		textField.setEditable(false);	// JTextField ��Ȱ��ȭ ����
		// spinner3 : 0~100 ������ ���ڰ�
		spinner3.setModel(spinnerNumberModel);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

public class Exam20 {

	public static void main(String[] args) {
		Swing20 swing = new Swing20();

	}

}
