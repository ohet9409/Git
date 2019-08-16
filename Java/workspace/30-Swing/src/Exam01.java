import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

class Swing1 extends JFrame{
	ImageIcon imageIcon = new ImageIcon("img/Cat.gif");	// 이미지 추가(현재 프로젝트 기준)
	public Swing1() {
		// jframe 설정
		setTitle("Swing1");
		setSize(300, 200);
		// 한가운데 위치 지정
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dimension1 = toolkit.getScreenSize();	 // 모니터의 크기 관리
		Dimension dimension2 = this.getSize();			// 프로그램의 크기
		int x = (int) (dimension1.getWidth()/2-dimension2.getWidth()/2);
		int y = (int) (dimension1.getHeight()/2 - dimension2.getHeight()/2);
		setLocation(x, y);
		setIconImage(imageIcon.getImage());
		init();
		start();
		setVisible(true);
	}

	private void init() {
		
		
	}

	private void start() {
		// jframe의 x버튼 종료 처리
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam01 {

	public static void main(String[] args) {
		Swing1 swing1 = new Swing1();

	}

}
