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

public class ScoreForm extends Frame implements ActionListener {
	ScoreVO vo = new ScoreVO();
	// layout
	BorderLayout borderLayout = new BorderLayout();
	FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
	GridLayout gridLayoutButton = new GridLayout(1, 6); // 1행 6열
	GridLayout gridLayoutBind = new GridLayout(5, 1); // 5헹 1열
	// button
	Button bu_input = new Button("입력");
	Button bu_print = new Button("출력");
	Button bu_SH = new Button("학번검색");
	Button bu_SN = new Button("이름검색");
	Button bu_SF = new Button("파일저장");
	Button bu_RF = new Button("파일읽기");
	// label
	Label label_hak = new Label("학번");
	Label label_name = new Label("이름");
	Label label_kor = new Label("국어");
	Label label_eng = new Label("영어");
	Label label_math = new Label("수학");
	// textfield
	TextField text_hak = new TextField(20);
	TextField text_name = new TextField(20);
	TextField text_kor = new TextField(20);
	TextField text_eng = new TextField(20);
	TextField text_math = new TextField(20);
	// panel
	Panel panelbutton = new Panel(); // 버튼 묶기
	Panel panel_hak = new Panel();
	Panel panel_name = new Panel();
	Panel panel_kor = new Panel();
	Panel panel_eng = new Panel();
	Panel panel_math = new Panel();
	Panel panelBind = new Panel(); // 학번 , 이름, 국어, 영어, 수학 묶기
	Panel panelCenter = new Panel(); // bind, textarea 묶기
	// textarea
	TextArea textArea = new TextArea();
	// 전체 기능을 관리하는 ScoreImpl 객체 생성
	ScoreImpl impl = new ScoreImpl();

	public ScoreForm() {
		// frame 설정
		setTitle("성적관리");
		setSize(700, 300);
		setLocation(300, 300);
		init();					// 화면 구성
		start();				// 이벤트 설정
		setVisible(true);
	}

	private void init() {
		// 학번
		panel_hak.setLayout(flowLayout);
		panel_hak.add(label_hak);
		panel_hak.add(text_hak);
		// 이름
		panel_name.setLayout(flowLayout);
		panel_name.add(label_name);
		panel_name.add(text_name);
		// 국어
		panel_kor.setLayout(flowLayout);
		panel_kor.add(label_kor);
		panel_kor.add(text_kor);
		// 영어
		panel_eng.setLayout(flowLayout);
		panel_eng.add(label_eng);
		panel_eng.add(text_eng);
		// 수학
		panel_math.setLayout(flowLayout);
		panel_math.add(label_math);
		panel_math.add(text_math);
		// button
		panelbutton.setLayout(gridLayoutButton); // 1행 6열(버튼 묶기)
		panelbutton.add(bu_input);
		panelbutton.add(bu_print);
		panelbutton.add(bu_SH);
		panelbutton.add(bu_SN);
		panelbutton.add(bu_SF);
		panelbutton.add(bu_RF);
		bu_input.setBackground(Color.YELLOW);
		bu_print.setBackground(Color.YELLOW);
		bu_SF.setBackground(Color.YELLOW);
		bu_SH.setBackground(Color.YELLOW);
		bu_SN.setBackground(Color.YELLOW);
		bu_RF.setBackground(Color.YELLOW);
		// bind
		panelBind.setLayout(gridLayoutBind); // 5행 1열(입력 묶기)
		panelBind.add(panel_hak);
		panelBind.add(panel_name);
		panelBind.add(panel_kor);
		panelBind.add(panel_eng);
		panelBind.add(panel_math);
		// panel center
		panelCenter.setLayout(new GridLayout(1, 3));
		panelCenter.add(panelBind);
		panelCenter.add(textArea);
		// frame
		setLayout(borderLayout);
//		add("West", panelBind);
		add("South", panelbutton);
		add("Center", panelCenter);
//		add("East", textArea);

	}

	private void start() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
//				System.exit(0);
				impl.pgmEnd();
				super.windowClosing(e);
			}
		});
		// 버튼 이벤트 설정
		bu_input.addActionListener(this);	// 마우스, 엔터키 사용시 작동
		bu_print.addActionListener(this);
		bu_SH.addActionListener(this);
		bu_SN.addActionListener(this);
		bu_SF.addActionListener(this);
		bu_RF.addActionListener(this);
//		// text 이벤트 설정
//		text_hak.addActionListener(this);
//		text_name.addActionListener(this);
//		text_kor.addActionListener(this);
//		text_eng.addActionListener(this);
//		text_math.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bu_input) { // 입력
			try {
				String hak = text_hak.getText().trim();
				String name = text_name.getText().trim();
				int kor = Integer.parseInt(text_kor.getText().trim());
				int eng = Integer.parseInt(text_eng.getText().trim());
				int math = Integer.parseInt(text_math.getText().trim());
				int tot = kor + eng + math;
				double avg = tot / 3.0;
				ScoreVO vo = new ScoreVO(); // 생성자 사용
				vo.setHak(hak);
				vo.setName(name);
				vo.setEng(eng);
				vo.setKor(kor);
				vo.setMat(math);
				vo.setTot(tot);
				vo.setAvg(avg);
				impl.input(vo);	// impl에 존재하는  list에 추가시킨다
				textArea.setText("입력되었습니다.");
				
			} catch (Exception e1) {
				textArea.setText("[경고] 입력값이 없는 것이 있습니다.");
			}
		} else if (e.getSource() == bu_print) { // 출력

			String result = impl.print();
			textArea.setText(result);

		} else if (e.getSource() == bu_SH) { // 학번 검색
			String hak = text_hak.getText().trim();
			String result = impl.searchHak(hak);
			textArea.setText(result);
		} else if (e.getSource() == bu_SN) { // 이름 검색
			String name = text_name.getText().trim();
			String result = impl.searchName(name);
			textArea.setText(result);
		} else if (e.getSource() == bu_SF) { // 파일 저장
			impl.writeFile();
			textArea.setText("파일 저장 성공");
		} else if (e.getSource() == bu_RF) { // 파일 읽기
			impl.readFile();
		}
		textArea.setCaretPosition(textArea.getText().length());
		text_hak.setText(" ");
		text_name.setText(" ");
		text_kor.setText(" ");
		text_eng.setText(" ");
		text_math.setText(" ");
	}

}
