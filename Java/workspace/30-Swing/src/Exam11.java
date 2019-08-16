import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.naming.InitialContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class Swing11 extends JFrame {
	Container container = getContentPane();
	JLabel label = new JLabel("메모장",JLabel.CENTER);
	JButton button = new JButton("확인");
	JButton button2 = new JButton("취소");
	JTextArea textArea = new JTextArea();
	JScrollPane scrollPane = new JScrollPane(textArea);	//textArea에 스크롤 기능 추가
	JPanel panelButton = new JPanel();
	
	
	public Swing11() {
		// JFrame 설정
		setTitle("Swing11");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		container.setLayout(new BorderLayout());
		container.add("North",label);
		container.add("Center",scrollPane);
		container.add("South",panelButton);
		
		panelButton.setLayout(new FlowLayout(FlowLayout.RIGHT)); // 버튼 패널을 오른쪽에 배치
		panelButton.add(button);
		panelButton.add(button2);
		// textArea 기능 설정
		textArea.setDragEnabled(true); // 드래그 기능 활성화
		textArea.setFocusAccelerator('r');	// textArea에 커서 옮김(단축키 사용 alt+r)
		textArea.setSelectedTextColor(Color.RED);	// 선택된 영역의 글자 색상 설정
		textArea.setSelectionColor(Color.YELLOW);	// 선택된 영역의 배경 색상 설정
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// textArea 이벤트 설정
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {	// 더블 클릭 인식
					textArea.paste(); 	// 붙여넣기 기능 수행
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				if(e.isPopupTrigger()) {	// 오른쪽 마우스 키를 눌렀음을 인식
					textArea.setText("홍길동");
				}
			}
		});
	}
}
public class Exam11 {

	public static void main(String[] args) {
		Swing11 swing11 = new Swing11();

	}

}
