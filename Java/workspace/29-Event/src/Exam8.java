import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class CalculatorForm extends Frame implements ActionListener {
	TextField textField = new TextField("0");
	Button[] buttonsNum = new Button[16];
	Button buttonResult = new Button("=");
	Panel panelNum = new Panel(); // 버튼 16개 묶기
	String[] strs_num = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", ".", "+" };
	String input = ""; // 입력값 저장
	boolean positive = true; // 음수(false), 양수(true) 판단용
	double num1 = 0, num2 = 0, result = 0; // 숫자 저장
	String op = null; 						// 연산자 저장
	int dotCnt=0;							// "." 이 눌린 수를 저장

	public CalculatorForm() {
		// frame 설정
		setTitle("계산기");
		setSize(250, 200);
		setLocation(1300, 300);

		init(); // 화면 구성
		start(); // 이벤트 설정
		setVisible(true);
	}

	private void init() {
		// panelNum 구성
		panelNum.setLayout(new GridLayout(4, 4, 3, 3));
		panelNum.setBackground(Color.LIGHT_GRAY);
		// panelNum에 버튼 추가하기
		for (int x = 0; x < buttonsNum.length; x++) {
			buttonsNum[x] = new Button(strs_num[x]);
			// 글자색 설정
			buttonsNum[x].setForeground(Color.BLUE);
			panelNum.add(buttonsNum[x]);
		}
		buttonResult.setForeground(Color.BLUE);
		// frame 구성
		setLayout(new BorderLayout()); // 동서남북 배치
		add("North", textField);
		add("Center", panelNum);
		add("South", buttonResult);
	}

	private void start() {
		// frame의 x버튼 종료 처리
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});
		// 버튼 이벤트 설정
		for (int x = 0; x < buttonsNum.length; x++) {
			buttonsNum[x].addActionListener(this);
		}
		buttonResult.addActionListener(this);
		// 키보드 입력 금지 설정
		textField.setEditable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 숫자는 input변수에 해당하는 숫자를 누적
		if (e.getSource() == buttonsNum[0]) { // 7
			input += "7";
		} else if (e.getSource() == buttonsNum[1]) { // 8
			input += "8";
		} else if (e.getSource() == buttonsNum[2]) { // 9
			input += "9";
		} else if (e.getSource() == buttonsNum[3]) { // /
			op = "/";
			num1 = Double.parseDouble(input); // 첫번째수 완성
			input = ""; // input 초기화
			dotCnt=0;	// dotCnt 초기화
		} else if (e.getSource() == buttonsNum[4]) { // 4
			input += "4";
		} else if (e.getSource() == buttonsNum[5]) { // 5
			input += "5";
		} else if (e.getSource() == buttonsNum[6]) { // 6
			input += "6";
		} else if (e.getSource() == buttonsNum[7]) { // *
			op = "*";
			num1 = Double.parseDouble(input); // 첫번째수 완성
			input = ""; // input 초기화
			dotCnt=0;	// dotCnt 초기화
		} else if (e.getSource() == buttonsNum[8]) { // 1
			input += "1";
		} else if (e.getSource() == buttonsNum[9]) { // 2
			input += "2";
		} else if (e.getSource() == buttonsNum[10]) { // 3
			input += "3";
		} else if (e.getSource() == buttonsNum[11]) { // -
			op = "-";
			num1 = Double.parseDouble(input); // 첫번째수 완성
			input = ""; // input 초기화
			dotCnt=0;	// dotCnt 초기화
		} else if (e.getSource() == buttonsNum[12]) { // 0
			input += "0";
		} else if (e.getSource() == buttonsNum[13]) { // +/-
			if(positive == true) {  // 양수 -> 음수
				positive = false;
				input = "-"+input;
			} else {				// 음수 -> 양수
				positive = true;
				input = input.substring(1);	// "-" 잘라내기
			}
		} else if (e.getSource() == buttonsNum[14]) { // .
			if(dotCnt==0) input+=".";
			// 맨처음 숫자에 "."이 입력이 되었을 때, "0."으로 만들기
			int position = input.indexOf(".");	// 왼쪽에서 오른쪽으로 위치 찾기
			if(position == 0) input ="0.";
			dotCnt++;
		} else if (e.getSource() == buttonsNum[15]) { // +
			op = "+";
			num1 = Double.parseDouble(input); // 첫번째수 완성
			input = ""; // input 초기화
			dotCnt=0;	// dotCnt 초기화
		} else if (e.getSource() == buttonResult) { // =
			num2 = Double.parseDouble(input);
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
			case "*":
				result = num1 * num2;
				break;
			case "/":
				result = num1 / num2;
				break;

			}
			
			textField.setText(String.valueOf(result));	// 일반자료형을 문자형으로 바꿈
			// 초기화 작업
			input="";
			num1=num2=result=0;
			positive = true;
			dotCnt=0;	// dotCnt 초기화
			return;			// 반드시 써줘야함 (뒤에 명령을 실행시키지 않기 위해서) 함수를 중간에 종료시키기위해 사용
		}
		textField.setText(input);	// 숫자를 화면에 표시
	}

}

public class Exam8 {

	public static void main(String[] args) {
		CalculatorForm calculatorForm = new CalculatorForm();

	}

}
