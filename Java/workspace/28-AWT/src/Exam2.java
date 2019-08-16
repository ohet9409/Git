import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;

public class Exam2 {

	public static void main(String[] args) {
		Frame frame = new Frame();
		frame.setSize(300, 200);
		frame.setTitle("기본화면");
		frame.setLayout(null); 	// 화면 분할에 Layout을 사용하지 않음
		Button button = new Button("확인");
		button.setBackground(Color.yellow);
		// 버튼의 위치와 크기 지정
//		// public void setBounds(int x,
//                int y,
//                int width,
//                int height)
		button.setBounds(100, 100, 80, 30);
		frame.add(button);
		frame.setVisible(true);
	}

}
