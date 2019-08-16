import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.InitialContext;
import javax.swing.JComboBox;
import javax.swing.JFrame;

class Swing12 extends JFrame {
	Container container = getContentPane();
	String[] str = {"AAA","BBB","CCC","DDD","EEE"};
	JComboBox<String> comboBox = new JComboBox<String>(str);	// 만들어진 문자열을 콤보박스에 추가
	
	
	public Swing12() {
		// JFrame 설정
		setTitle("Swing12");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(comboBox);
		// comboBox에 항목 추가
		comboBox.addItem("FFF");	// 콤보박스 목록에 FFF추가
		// comboBox의 내용 수정
		comboBox.setEditable(true);
		// comboBox의 행의 최대 갯수 설정
		comboBox.setMaximumRowCount(3);	// 3개씩 보여짐
		
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// comboBox 이벤트 처리
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBox.getSelectedItem());
				
			}
		});
		
		
	}
}
public class Exam12 {

	public static void main(String[] args) {
		Swing12 swing = new Swing12();

	}

}
