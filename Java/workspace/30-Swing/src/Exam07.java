import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.naming.InitialContext;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

class Swing07 extends JFrame {
	Container container = getContentPane();
	// 메뉴바 만들기
	JMenuBar menuBar = new JMenuBar();
	// 파일 메뉴 만들기
	JMenu menuFile = new JMenu("파일");
	JMenuItem fNew = new JMenuItem("새파일");			// 파일 메뉴에 텍스트만 추가
	ImageIcon img1 = new ImageIcon("img/cat.gif");
	JMenuItem fOpen =new JMenuItem(img1);			// 파일 메뉴에 이미지만 추가
	ImageIcon img2 = new ImageIcon("img/dog.gif");
	JMenuItem fExit = new JMenuItem("종료",img2);		// 파일 메뉴에 이미지, 텍스트 추가
	// 수정 메뉴 만들기
	JMenu menuEdit = new JMenu("수정");
	JMenu menuEditSize = new JMenu("크기");	// 수정 메뉴안에 크기라는 메뉴를 생성하기 위해
	JRadioButtonMenuItem es10 = new JRadioButtonMenuItem("10"); // 크기를 조절할 버튼 생성
	JRadioButtonMenuItem es20 = new JRadioButtonMenuItem("20");
	JRadioButtonMenuItem es30 = new JRadioButtonMenuItem("30");
	ButtonGroup buttonGroup = new ButtonGroup();	// 그룹으로 묶는다
	JMenu menuEditColor = new JMenu("색상");	// 수정 메뉴안에 색상이라는 메뉴를 생성하기 위해
	JCheckBoxMenuItem ecRed = new JCheckBoxMenuItem("Red");
	JCheckBoxMenuItem ecGreen = new JCheckBoxMenuItem("Green");
	JCheckBoxMenuItem ecBlue = new JCheckBoxMenuItem("Blue");
	// 도움말 메뉴 만들기
	JMenu menu = new JMenu("도움말");
	public Swing07() {
		// JFrame 설정
		setTitle("Swing07");
		setSize(300, 200);
		setLocation(1300, 300);
		
		init();		// 화면 구성
		start();		// 이벤트 설정
		setVisible(true);

	}

	private void init() {
		this.setJMenuBar(menuBar); // 프레임에 메뉴바 추가
		fExit.setArmed(true);		// 해당 메뉴가 열렸을 때, 자동으로 선택되는 위치로 지정(종료가 자동선택되어진다)
		menuFile.add(fNew);
		menuFile.addSeparator();	// 메뉴 구분을 위해 밑줄 표시
		menuFile.add(fOpen);
		menuFile.addSeparator();
		menuFile.add(fExit);
		menuBar.add(menuFile);		// 메뉴바에 파일 메뉴 추가
		
		menuEdit.setBorder(new LineBorder(Color.RED,3));	// 수정 메뉴 테두리에 빨간색, 3크기의 줄 생성
		menuEditSize.setBorder(new BevelBorder(BevelBorder.RAISED));	// 버튼이 튀어나오는 효과
		menuEditColor.setBorder(new BevelBorder(BevelBorder.RAISED));
		buttonGroup.add(es10);		// 크기버튼을 싱글초이스로 만들기 위하여 그룹으로 묶음
		buttonGroup.add(es20);
		buttonGroup.add(es30);
		
		menuEditSize.add(es10);	// 크기 버튼에 라디오 버튼 item 추가
		menuEditSize.add(es20);
		menuEditSize.add(es30);
		menuEdit.add(menuEditSize);	// 수정 메뉴에 크기조절 메뉴 추가
		menuEdit.addSeparator();
		
		menuEditColor.add(ecRed);	// 색상 메뉴에 checkBox 아이템 추가 (여러개 선택가능)
		menuEditColor.add(ecGreen);
		menuEditColor.add(ecBlue);
		menuEdit.add(menuEditColor);	// 수정 메뉴에 색상메뉴 추가
		
		menuBar.add(menuEdit);	// 메뉴바에 수정 메뉴 추가 
		menuBar.add(menu);		// 메뉴바에 도움말 메뉴 추가 
		
		
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
public class Exam07 {

	public static void main(String[] args) {
		Swing07 swing07 = new Swing07();

	}

}
