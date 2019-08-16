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
	String[] str = {"1번","2번","3번","4번"};
	// 제목으로 str배열을 배정, 5행으로 데이터가 들어갈 영역 설정
	DefaultTableModel defaultTableModel = new DefaultTableModel(str,5);
	// TableModel을 기준으로 JTable 객체 생성
	JTable table = new JTable(defaultTableModel);
	JScrollPane scrollPane = new JScrollPane(table);
	
	JLabel label = new JLabel("JTable!!!",JLabel.CENTER);
	JButton button = new JButton("확인");
	JButton button2 = new JButton("취소");
	JPanel panel = new JPanel();
	
	public Swing25() {
		// JFrame 설정
		setTitle("Swing25");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);
		
		changeContent();
	}

	private void changeContent() {
		System.out.println("1 Column's Class Name = " + defaultTableModel.getColumnClass(0));
		System.out.println("Coloumn Count = " + defaultTableModel.getColumnCount());
		System.out.println("3 Coloumn's Name  = " + defaultTableModel.getColumnName(2));
		System.out.println("Row Count = " + defaultTableModel.getRowCount());
		// 3행 3열의 위치에  "Test" 문자열을 기입
		defaultTableModel.setValueAt("Test", 2, 2);
		System.out.println("2, 2 Editable = " + defaultTableModel.isCellEditable(2, 2));
		System.out.println("2번 Column's Pos = " + defaultTableModel.findColumn("2번"));
		// 열 추가
		defaultTableModel.addColumn("5번");
		// 행 추가
		String[] s = new String[defaultTableModel.getColumnCount()];	// 열 개수만큼 1행 추가
		defaultTableModel.addRow(s);
		// 전체 행, 열의 갯수를 설정
		defaultTableModel.setRowCount(14);		// 행 : 14
		defaultTableModel.setColumnCount(10);	// 열 : 10
		// 값 읽어 오기
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
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam25 {

	public static void main(String[] args) {
		Swing25 swing = new Swing25();

	}

}
