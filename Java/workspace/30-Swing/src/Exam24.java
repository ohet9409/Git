import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;

class Swing24 extends JFrame {
	Container container = getContentPane();
	// tree 추가할 내용
	Object[] gen = { "프로그램", "System", "Design" };
	Vector<Vector> node1 = new Vector<Vector>() {
		@Override
		public String toString() {
			return "Lesson";
		}
	};
	Vector<String> node2 = new Vector<String>() {
		@Override
		public String toString() {
			return "Java";
		}
	};
	Vector<String> node3 = new Vector<String>() {
		@Override
		public String toString() {
			return "XML";
		}
	};

	JTree tree = new JTree(gen);
	JScrollPane scrollPane = new JScrollPane(tree);
	JLabel label = new JLabel("JTree!!!", JLabel.CENTER);

	public Swing24() {
		// JFrame 설정
		setTitle("Swing24");
		setSize(300, 300);
		setLocation(1300, 300);

		init(); // 화면 구성
		start(); // 이벤트 설정
		setVisible(true);

	}

	private void init() {

		// node1 설정
		node1.addElement(node2);
		node1.addElement(node3);
		// node2 설정
		node2.addElement("Beg");
		node2.addElement("Ady");
		node2.addElement("JSP");
		// node3 설정
		node3.addElement("XSLT");
		node3.addElement("DOM");

		gen[0] = node1;
		tree = new JTree(gen);
		scrollPane = new JScrollPane(tree);
		tree.setRootVisible(true);		// root 디렉토리 보이기
		
		// container 구성
		container.setLayout(new BorderLayout());
		container.add("North", label);
		container.add("Center", scrollPane);
	}

	private void start() {
		// x버튼 종료 처리
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
}

public class Exam24 {

	public static void main(String[] args) {
		Swing24 swing = new Swing24();

	}

}
