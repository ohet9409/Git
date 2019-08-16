import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ScoreFrame extends Frame implements ActionListener {
	Button button1 = new Button("입력");
	Button button2 = new Button("취소");
	Label labelKor = new Label("국어");
	Label labelEng = new Label("영어");
	Label labelTot = new Label(" 총점 : ");
	Label labelAvg = new Label(" 평균 : ");
	TextField textFieldKor = new TextField(25);
	TextField textFieldEng = new TextField(25);
	Panel panelButton = new Panel();
	Panel panelKor = new Panel();
	Panel panelEng = new Panel();
	Panel panelBind = new Panel();
	BorderLayout boarderLayout = new BorderLayout();
	GridLayout gridLayoutButton = new GridLayout(1, 2);
	GridLayout gridLayoutBind = new GridLayout(4, 1);
	FlowLayout flowLayoutSubject = new FlowLayout(FlowLayout.LEFT);
	
	public ScoreFrame() {
		// Frame 설정
		setTitle("Score");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();	// 이벤트 설정
		
		setVisible(true);
	}
	
	private void init() {
		// Frame Layout 설정
		setLayout(boarderLayout);
		// 국어 패널 구성
		panelKor.setLayout(flowLayoutSubject);
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// 영어 패널 구성
		panelEng.setLayout(flowLayoutSubject);
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// 성적 패널 구성
		panelBind.setLayout(gridLayoutBind);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(labelTot);
		panelBind.add(labelAvg);
		// Button 패널 구성
		panelButton.setLayout(gridLayoutButton);
		button1.setBackground(Color.YELLOW);
		button2.setBackground(Color.YELLOW);
		panelButton.add(button1);
		panelButton.add(button2);
		// Frame에 배치
		add("Center", panelBind);
		add("South", panelButton);
	}
	private void start() {
		// Frame 창의 x버튼 종료 처리
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); 
			}
		});
		// Button 이벤트 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {
			int kor = Integer.parseInt(textFieldKor.getText().trim());
			int eng = Integer.parseInt(textFieldEng.getText().trim());
			int tot = kor + eng;
			double avg = (double)tot / 2;
			labelTot.setText(" 총점 : " + tot);
			labelAvg.setText(" 평균 : " + avg);
		} else if(e.getSource() == button2) {
			textFieldKor.setText(" ");
			textFieldEng.setText(" ");
			labelTot.setText(" 총점 : ");
			labelAvg.setText(" 평균 : ");
		}
	}	
}
public class Exam7 {
	public static void main(String[] args) {
		ScoreFrame scoreFrame = new ScoreFrame();
	}
}






