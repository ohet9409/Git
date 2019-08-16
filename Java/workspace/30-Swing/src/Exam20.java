
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
	// spinner에 사용할 컴포넌트
	JTextField textField = new JTextField();
	// 날짜 관리 클래스
	DateFormatSymbols deFormatSymbols = new DateFormatSymbols();
	String[] str = deFormatSymbols.getMonths();
	
	SpinnerListModel spinnerListModel = new SpinnerListModel(str);
	// 현재 시스템의 날짜 값을 그대로 가져온다.
	SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
	// 0~100 사이의 숫자값으로, 50을 기본값으로 나타내고, 2씩 증가 감소 시킨다.
	SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(50,0,100,2);
	public Swing20() {
		// JFrame 설정
		setTitle("Swing20");
		setSize(300, 200);
		setLocation(1300, 300);

		init(); // 화면 구성
		start(); // 이벤트 설정
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
		// spinner1 : 1월 ~ 12월 설정
		spinner1.setModel(spinnerListModel);
		// spinner2 : 현재 시스템의 날짜
		spinner2.setModel(spinnerDateModel);
		// spinner의 TextField 영역의 편집 금지 기능 설정
		// Jspinner의 JTextField의 값을 얻어옴
		textField = ((JSpinner.DateEditor)spinner2.getEditor()).getTextField();
		textField.setEditable(false);	// JTextField 비활성화 설정
		// spinner3 : 0~100 사이의 숫자값
		spinner3.setModel(spinnerNumberModel);
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

public class Exam20 {

	public static void main(String[] args) {
		Swing20 swing = new Swing20();

	}

}
