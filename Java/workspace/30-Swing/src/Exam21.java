import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

class Swing21 extends JFrame implements ChangeListener {
	Container container = getContentPane();
	JLabel labelRGB = new JLabel("RGB(0, 0, 0)", JLabel.CENTER);
	JLabel labelRed = new JLabel("RED");
	JLabel labelGreen = new JLabel("GREEN");
	JLabel labelBlue = new JLabel("BLUE");
	// public JSlider(int orientation, int min, int max, int value)
	JSlider sliderRed = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider sliderGreen = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
	JSlider sliderBlue = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

	JPanel panel1 = new JPanel(); // 색상 보여주기 용도
	JPanel panel2 = new JPanel();
	JPanel panelWest = new JPanel();
	JPanel panelCenter = new JPanel();
	// 색상 관리 변수
	int r = 0, g = 0, b = 0;

	public Swing21() {
		// JFrame 설정
		setTitle("Swing21");
		setSize(400, 250);
		setLocation(1300, 300);

		init(); // 화면 구성
		start(); // 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North", labelRGB);
		container.add("Center", panel1);
		container.add("South", panel2);
		// labelRGB 구성
		labelRGB.setFont(new Font("돋움체", Font.BOLD, 24));
		// panelWest 구성
		labelRed.setForeground(Color.RED);
		labelGreen.setForeground(Color.GREEN);
		labelBlue.setForeground(Color.BLUE);
		panelWest.setLayout(new GridLayout(3, 1));
		panelWest.add(labelRed);
		panelWest.add(labelGreen);
		panelWest.add(labelBlue);
		// panelCenter 구성
		sliderRed.setMajorTickSpacing(50); // 슬라이드의 주 눈금 간격 지정
		sliderRed.setMinorTickSpacing(5); // 슬라이드의 보조 눈금 간격 지정
		sliderRed.setPaintTicks(true); // 슬라이드의 눈금 보이기
		sliderRed.setPaintLabels(true); // 슬라이드의 숫자 보이기

		sliderGreen.setMajorTickSpacing(50); // 슬라이드의 주 눈금 간격 지정
		sliderGreen.setMinorTickSpacing(5); // 슬라이드의 보조 눈금 간격 지정
		sliderGreen.setPaintTicks(true);
		sliderGreen.setPaintLabels(true);

		sliderBlue.setMajorTickSpacing(50); // 슬라이드의 주 눈금 간격 지정
		sliderBlue.setMinorTickSpacing(5); // 슬라이드의 보조 눈금 간격 지정
		sliderBlue.setPaintTicks(true);
		sliderBlue.setPaintLabels(true);

		panelCenter.setLayout(new GridLayout(3, 1));
		panelCenter.add(sliderRed);
		panelCenter.add(sliderGreen);
		panelCenter.add(sliderBlue);
		// panel1 구성
		panel1.setBackground(Color.black);
		// panel2 구성
		panel2.setLayout(new BorderLayout());
		panel2.add("West", panelWest);
		panel2.add("Center", panelCenter);

	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// slider 이벤트 설정
		sliderRed.addChangeListener(this);
		sliderBlue.addChangeListener(this);
		sliderGreen.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {

		if (e.getSource() == sliderRed) {
			r = sliderRed.getValue();
		} else if (e.getSource() == sliderGreen) {
			g = sliderGreen.getValue();
		} else if (e.getSource() == sliderBlue) {
			b = sliderBlue.getValue();
		}
		panel1.setBackground(new Color(r, g, b));
		labelRGB.setText("RGB(" + r + "," + g + "," + b + ")");

	}
}

public class Exam21 {

	public static void main(String[] args) {
		Swing21 swing = new Swing21();

	}

}
