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
	Button button1 = new Button("입력");
	Button button2 = new Button("출력");
	Button button3 = new Button("학번검색");
	Button button4 = new Button("이름검색");
	Button button5 = new Button("파일저장");
	Button button6 = new Button("파일읽기");
	Label labelHak = new Label("학번");
	Label labelName = new Label("이름");
	Label labelKor = new Label("국어");
	Label labelEng = new Label("영어");
	Label labelMat = new Label("수학");
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
	// 전체 기능을 관리하는 ScoreImpl 객체 생성
	ScoreImpl scoreImpl = new ScoreImpl();
	
	public ScoreForm() {
		// Frame 설정
		setTitle("성적 관리");
		setSize(700, 250);
		setLocation(1200, 300);
		
		init();
		start();
		
		setVisible(true);
	}
	private void init() {
		// PanelBtn 구성
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
		// PanelHak 구성
		panelHak.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelHak.add(labelHak);
		panelHak.add(textFieldHak);
		// PanelName 구성
		panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelName.add(labelName);
		panelName.add(textFieldName);
		// PanelKor 구성
		panelKor.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelKor.add(labelKor);
		panelKor.add(textFieldKor);
		// PanelEng 구성
		panelEng.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelEng.add(labelEng);
		panelEng.add(textFieldEng);
		// PanelMat 구성
		panelMat.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelMat.add(labelMat);
		panelMat.add(textFieldMat);
		// PanelBind 구성
		panelBind.setLayout(new GridLayout(5, 1));
		panelBind.add(panelHak);
		panelBind.add(panelName);
		panelBind.add(panelKor);
		panelBind.add(panelEng);
		panelBind.add(panelMat);
		// PanelCenter 구성	
		panelCenter.setLayout(new GridLayout(1, 2));
		panelCenter.add(panelBind);
		panelCenter.add(textArea);
		// Frame 구성
		setLayout(new BorderLayout());
		add("Center", panelCenter);
		add("South", panelBtn);
	}
	private void start() {
		// Frame 창의 x버튼 종료 처리
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				scoreImpl.pgmEnd();
			}
		});
		// 버튼 이벤트 설정
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button1) {	// 입력
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
				textArea.setText("입력되었습니다.");
				
				textFieldHak.setText("");
				textFieldName.setText("");
				textFieldKor.setText("");
				textFieldEng.setText("");
				textFieldMat.setText("");
			} catch(Exception err) {
				textArea.setText("[경고] 입력값이 없는 것이 있습니다.");
			}
		} else if(e.getSource() == button2) {	// 출력
			String result = scoreImpl.print();
			textArea.setText(result);
		} else if(e.getSource() == button3) {	// 학번검색
			String hak = textFieldHak.getText();
			String result = scoreImpl.searchHak(hak);
			textArea.setText(result);
		} else if(e.getSource() == button4) {	// 이름검색
			String name = textFieldName.getText();
			String result = scoreImpl.searchName(name);
			textArea.setText(result);
		} else if(e.getSource() == button5) {	// 파일저장
			scoreImpl.writeFile();
			textArea.setText("파일 저장 성공");
		} else if(e.getSource() == button6) {	// 파일읽기
			scoreImpl.readFile();
			textArea.setText("파일 읽기 성공");
		} 
	}
}






