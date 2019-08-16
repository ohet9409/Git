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
	Panel panelNum = new Panel(); // ��ư 16�� ����
	String[] strs_num = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "+/-", ".", "+" };
	String input = ""; // �Է°� ����
	boolean positive = true; // ����(false), ���(true) �Ǵܿ�
	double num1 = 0, num2 = 0, result = 0; // ���� ����
	String op = null; 						// ������ ����
	int dotCnt=0;							// "." �� ���� ���� ����

	public CalculatorForm() {
		// frame ����
		setTitle("����");
		setSize(250, 200);
		setLocation(1300, 300);

		init(); // ȭ�� ����
		start(); // �̺�Ʈ ����
		setVisible(true);
	}

	private void init() {
		// panelNum ����
		panelNum.setLayout(new GridLayout(4, 4, 3, 3));
		panelNum.setBackground(Color.LIGHT_GRAY);
		// panelNum�� ��ư �߰��ϱ�
		for (int x = 0; x < buttonsNum.length; x++) {
			buttonsNum[x] = new Button(strs_num[x]);
			// ���ڻ� ����
			buttonsNum[x].setForeground(Color.BLUE);
			panelNum.add(buttonsNum[x]);
		}
		buttonResult.setForeground(Color.BLUE);
		// frame ����
		setLayout(new BorderLayout()); // �������� ��ġ
		add("North", textField);
		add("Center", panelNum);
		add("South", buttonResult);
	}

	private void start() {
		// frame�� x��ư ���� ó��
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				System.exit(0);
			}
		});
		// ��ư �̺�Ʈ ����
		for (int x = 0; x < buttonsNum.length; x++) {
			buttonsNum[x].addActionListener(this);
		}
		buttonResult.addActionListener(this);
		// Ű���� �Է� ���� ����
		textField.setEditable(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ���ڴ� input������ �ش��ϴ� ���ڸ� ����
		if (e.getSource() == buttonsNum[0]) { // 7
			input += "7";
		} else if (e.getSource() == buttonsNum[1]) { // 8
			input += "8";
		} else if (e.getSource() == buttonsNum[2]) { // 9
			input += "9";
		} else if (e.getSource() == buttonsNum[3]) { // /
			op = "/";
			num1 = Double.parseDouble(input); // ù��°�� �ϼ�
			input = ""; // input �ʱ�ȭ
			dotCnt=0;	// dotCnt �ʱ�ȭ
		} else if (e.getSource() == buttonsNum[4]) { // 4
			input += "4";
		} else if (e.getSource() == buttonsNum[5]) { // 5
			input += "5";
		} else if (e.getSource() == buttonsNum[6]) { // 6
			input += "6";
		} else if (e.getSource() == buttonsNum[7]) { // *
			op = "*";
			num1 = Double.parseDouble(input); // ù��°�� �ϼ�
			input = ""; // input �ʱ�ȭ
			dotCnt=0;	// dotCnt �ʱ�ȭ
		} else if (e.getSource() == buttonsNum[8]) { // 1
			input += "1";
		} else if (e.getSource() == buttonsNum[9]) { // 2
			input += "2";
		} else if (e.getSource() == buttonsNum[10]) { // 3
			input += "3";
		} else if (e.getSource() == buttonsNum[11]) { // -
			op = "-";
			num1 = Double.parseDouble(input); // ù��°�� �ϼ�
			input = ""; // input �ʱ�ȭ
			dotCnt=0;	// dotCnt �ʱ�ȭ
		} else if (e.getSource() == buttonsNum[12]) { // 0
			input += "0";
		} else if (e.getSource() == buttonsNum[13]) { // +/-
			if(positive == true) {  // ��� -> ����
				positive = false;
				input = "-"+input;
			} else {				// ���� -> ���
				positive = true;
				input = input.substring(1);	// "-" �߶󳻱�
			}
		} else if (e.getSource() == buttonsNum[14]) { // .
			if(dotCnt==0) input+=".";
			// ��ó�� ���ڿ� "."�� �Է��� �Ǿ��� ��, "0."���� �����
			int position = input.indexOf(".");	// ���ʿ��� ���������� ��ġ ã��
			if(position == 0) input ="0.";
			dotCnt++;
		} else if (e.getSource() == buttonsNum[15]) { // +
			op = "+";
			num1 = Double.parseDouble(input); // ù��°�� �ϼ�
			input = ""; // input �ʱ�ȭ
			dotCnt=0;	// dotCnt �ʱ�ȭ
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
			
			textField.setText(String.valueOf(result));	// �Ϲ��ڷ����� ���������� �ٲ�
			// �ʱ�ȭ �۾�
			input="";
			num1=num2=result=0;
			positive = true;
			dotCnt=0;	// dotCnt �ʱ�ȭ
			return;			// �ݵ�� ������� (�ڿ� ����� �����Ű�� �ʱ� ���ؼ�) �Լ��� �߰��� �����Ű������ ���
		}
		textField.setText(input);	// ���ڸ� ȭ�鿡 ǥ��
	}

}

public class Exam8 {

	public static void main(String[] args) {
		CalculatorForm calculatorForm = new CalculatorForm();

	}

}
