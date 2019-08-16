import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

class Swing25 extends JFrame {
	Container container = getContentPane();
	String[] str = {"1��","2��","3��","4��"};
	// �������� str�迭�� ����, 5������ �����Ͱ� �� ���� ����
	DefaultTableModel defaultTableModel = new DefaultTableModel(str,5);
	// TableModel�� �������� JTable ��ü ����
	JTable table = new JTable(defaultTableModel);
	JScrollPane scrollPane = new JScrollPane(table);
	
	JLabel label = new JLabel("JTable!!!",JLabel.CENTER);
	JButton button = new JButton("Ȯ��");
	JButton button2 = new JButton("���");
	JPanel panel = new JPanel();
	
	public Swing25() {
		// JFrame ����
		setTitle("Swing25");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// ȭ�� ����
		start();		// �̺�Ʈ ����
		setVisible(true);
		
		changeContent();
	}

	private void changeContent() {
		System.out.println("1 Column's Class Name = " + defaultTableModel.getColumnClass(0));
		System.out.println("Coloumn Count = " + defaultTableModel.getColumnCount());
		System.out.println("3 Coloumn's Name  = " + defaultTableModel.getColumnName(2));
		System.out.println("Row Count = " + defaultTableModel.getRowCount());
		// 3�� 3���� ��ġ��  "Test" ���ڿ��� ����
		defaultTableModel.setValueAt("Test", 2, 2);
		System.out.println("2, 2 Editable = " + defaultTableModel.isCellEditable(2, 2));
		System.out.println("2�� Column's Pos = " + defaultTableModel.findColumn("2��"));
		// �� �߰�
		defaultTableModel.addColumn("5��");
		// �� �߰�
		String[] s = new String[defaultTableModel.getColumnCount()];	// �� ������ŭ 1�� �߰�
		defaultTableModel.addRow(s);
		// ��ü ��, ���� ������ ����
		defaultTableModel.setRowCount(14);		// �� : 14
		defaultTableModel.setColumnCount(10);	// �� : 10
		// �� �о� ����
		String result = (String) defaultTableModel.getValueAt(2, 2);
		System.out.println("result = " + result);
		
	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		container.add("Center",scrollPane);
		container.add("South",panel);
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel.add(button);
		panel.add(button2);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam25 {

	public static void main(String[] args) {
		Swing25 swing = new Swing25();

	}

}
