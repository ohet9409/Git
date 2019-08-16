import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.naming.InitialContext;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

class Swing09 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("ID : ",JLabel.RIGHT);
	JTextField textField = new JTextField(10);
	
	JDialog dialog = new JDialog(this,"확인");
	Container dialogcontainer = dialog.getContentPane(); // 다이얼로그로 부터 얻어온다.
	JLabel diJLabel = new JLabel("사용할 수 있는 ID입니다.",JLabel.CENTER);
	
	public Swing09() {
		// JFrame 설정
		setTitle("Swing09");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new FlowLayout());
		container.add(label);
		container.add(textField);
		
		dialogcontainer.setLayout(new BorderLayout());
		diJLabel.setBorder(new BevelBorder(BevelBorder.RAISED));	// 다이얼로그에 튀어나오는 효과추가
		dialogcontainer.add("Center",diJLabel);			// 다이얼로그에 라벨 추가
		dialog.setSize(200,150);
		dialog.setLocation(1400, 400);
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	// 완전히 종료
		// dialog x버튼 처리 : 숨김기능만 처리한다.
		dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);	// 창만 사라진다
		// textField 이벤트 처리
		textField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);	// 텍스트 필드에 엔터를 치면 다이얼로그 창이 뜨도록 설정
				
			}
		});
	}
}
public class Exam09 {

	public static void main(String[] args) {
		Swing09 swing09 = new Swing09();

	}

}
