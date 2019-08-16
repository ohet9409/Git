
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

class Swing10 extends JFrame implements ActionListener {
	Container container = getContentPane();
	JButton button = new JButton("색 선택");
	JButton button2 = new JButton("파일 선택");
	JColorChooser colorChooser = new JColorChooser();
	JFileChooser fileChooser = new JFileChooser();

	public Swing10() {
		// JFrame 설정
		setTitle("Swing10");
		setSize(300, 200);
		setLocation(1300, 300);

		init(); // 화면 구성
		start(); // 이벤트 설정
		setVisible(true);

	}

	// colorChooser 설정 및 실행
	private void color() {
		Color cc = colorChooser.showDialog(this, "나의 색상 선택", Color.black);
//		Color cc = colorChooser.show(true);
		System.out.println("선택된 색상 = " + cc);
		colorChooser.setColor(cc); // 기본 색상 지정해 두기
		System.out.println("다시 얻어오기 = " + colorChooser.getColor());
	}

	// fileChooser 설정 및 실행
	private void file() {
		fileChooser.setDialogTitle("불러오기"); // 다이얼로그 타이틀 글자 바꾸기
		fileChooser.setMultiSelectionEnabled(true); // 다중 선택 가능하게 설정
		fileChooser.showDialog(this, "열기");
//		File file = fileChooser.getSelectedFile();	// 파일 1개 처리
		File[] files = fileChooser.getSelectedFiles();	// 파일 여러개 처리
		for (int x = 0; x < files.length; x++) {
			System.out.println("파일명 = " + files);
		}

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(button);
		container.add(button2);

	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		button.addActionListener(this);
		button2.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			color();
		} else if (e.getSource() == button2) {
			file();
		}

	}
}

public class Exam10 {

	public static void main(String[] args) {
		Swing10 swing10 = new Swing10();

	}

}
