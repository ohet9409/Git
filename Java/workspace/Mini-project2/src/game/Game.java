package game;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.PanelPeer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class GameJFrame extends JFrame implements ActionListener, Runnable{
	boolean tf = true;		// ������ ������ ���� boolean��
	
	int startNum = 1;
	RandomButton randomButton = new RandomButton();
	RandomButton2 randomButton2 = new RandomButton2();
	
	Container container = getContentPane();			// Ŭ���� �� ȭ��
	Container endContainer = getContentPane();		// Ŭ���� �� ȭ��
	
	JButton buttonStart = new JButton("����");		// ���� ��ư
	JButton buttonReset = new JButton("�ʱ�ȭ");		// �ʱ�ȭ ��ư
	JButton[] buttons1 = new JButton[25];	// 1 ~ 25
	JButton[] buttons2 = new JButton[25];	// 26 ~ 50
	JButton buttonEnroll = new JButton("���");
	JPanel[] panelArray = new JPanel[25];	// 25ĭ�� �г�
	// ��� �г�
	JPanel panelTop = new JPanel();		// ��� ��ü
	JPanel panelTopLeft = new JPanel();	// ��� ����
	// ��� ��
	JLabel labelCurrentNumber = new JLabel("Click", JLabel.LEFT);	// ���� �������ϴ� ����
	JLabel labeltitle = new JLabel("1 to 50", JLabel.CENTER);				// ����
	JLabel labelTime = new JLabel("TIME", JLabel.RIGHT);					// �ð�
	// �ߴ� �г�
	JPanel panelNumber = new JPanel();	// �ߴ� ��ü
	JPanel panelNumber2 = new JPanel(); // Ŭ���� â
	JPanel panelPlayerName = new JPanel();
	JPanel panelPlayerName2 = new JPanel(); 
	// �ߴ� ��
	JLabel labelAcTime = new JLabel("", JLabel.CENTER);
	JLabel labelClear = new JLabel("���� Ŭ����!!!", JLabel.CENTER);
	JLabel labelPlayerName = new JLabel("�̸� : ");
	// �ϴ� �г�
	JPanel panelSr = new JPanel();		// �ϴ� ��ü
	JPanel panelStart = new JPanel();	// �ϴ� ���۹�ư �г�
	JPanel panelReset = new JPanel();	// �ϴ� �ʱ�ȭ��ư �г�
	
	
	// Ŭ����� �г��� �Է�
	JTextField textFieldPlayerName = new JTextField(15);
	
	public GameJFrame() {
		setTitle("1 to 50 Game");
		setSize(800, 900);
		setLocation(700, 100);

		container.setBackground(Color.WHITE);
		panelTop.setBackground(Color.WHITE);
		panelTopLeft.setBackground(Color.WHITE);
		panelPlayerName.setBackground(Color.WHITE);
		panelStart.setBackground(Color.WHITE);
		panelReset.setBackground(Color.WHITE);
		// ���
		labelCurrentNumber.setFont(new Font("Serif", Font.BOLD, 40));
		labeltitle.setFont(new Font("Serif", Font.BOLD, 50));
		labelTime.setFont(new Font("Serif", Font.BOLD, 50));
		// �ߴ�
		labelClear.setFont(new Font("Serif", Font.BOLD, 35));
		labelAcTime.setFont(new Font("Serif", Font.BOLD, 35));
		labelPlayerName.setFont(new Font("Serif", Font.BOLD, 35));
		textFieldPlayerName.setFont(new Font("Serif", Font.BOLD, 35));
		buttonEnroll.setFont(new Font("Serif", Font.BOLD, 35));
		// �ϴ�
		buttonStart.setFont(new Font("Serif", Font.BOLD, 35));
		buttonReset.setFont(new Font("Serif", Font.BOLD, 35));
		
		init();
		start();
		
		setVisible(true);
	}

	private void init() {
		// ���
		panelTop.setLayout(new GridLayout(1,3));	
		panelTop.add(labelCurrentNumber);
		panelTop.add(labeltitle);
		panelTop.add(labelTime);
		
		
		panelNumber.setLayout(new GridLayout(5 ,5, 20, 20));
		panelNumber.setBackground(Color.WHITE);
		for(int x=0;x<25;x++) {
			panelArray[x] = new JPanel();
			panelNumber.add(panelArray[x]);
			buttons1[x] = new JButton();
			panelArray[x].setLayout(new BorderLayout());
			buttons1[x].setFont(new Font("Serif", Font.BOLD, 35));
			panelArray[x].add(buttons1[x]);
			buttons2[x] = new JButton();
			buttons2[x].setFont(new Font("Serif", Font.BOLD, 35));
		}
		
		
		// �ϴ�
		panelSr.setLayout(new GridLayout(1, 2));
		panelStart.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelStart.add(buttonStart);
		panelReset.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelReset.add(buttonReset);
		panelSr.add("Center", panelStart);
		panelSr.add("Center", panelReset);
		
	    // ��ü
	    container.setLayout(new BorderLayout());
		container.add("North", panelTop);
		container.add("South", panelSr);
	}

	private void start() {
		// x��ư ���� ó��
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		for(int x=0;x<buttons1.length;x++) {
			buttonStart.addActionListener(this);	// ����
			buttonReset.addActionListener(this);	// �ʱ�ȭ
			buttons1[x].addActionListener(this);	// 1~25
			buttons2[x].addActionListener(this);	// 26~50
			buttonEnroll.addActionListener(this); 	// ��� ���
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// ����
		if(e.getSource() == buttonStart) {
//			startTime = System.currentTimeMillis();
			if(startNum == 1) {
				labelTime.setText("0��");
				tf = true;
				new Thread(this).start();
				randomButton.setButtons(buttons1);
			    randomButton.rand1();
			    randomButton2.setButtons(buttons2);
			    randomButton2.rand2();
			    
			    
				container.add("Center", panelNumber);
				container.revalidate();
				container.repaint();
				labelCurrentNumber.setText("Click [ " + String.valueOf(startNum) + " ]");
				labelCurrentNumber.setFont(new Font("Serif", Font.CENTER_BASELINE, 40));
			}
		}
		// �ʱ�ȭ
		if(e.getSource() == buttonReset) {
			labelCurrentNumber.setText("Click Number");
			tf = false;
			for(int x=0;x<25;x++) {
				panelArray[x].remove(buttons1[x]);
				panelArray[x].remove(buttons2[x]);
				panelArray[x].invalidate();
				panelArray[x].add(buttons1[x]);
				panelArray[x].add(buttons2[x]);
				panelArray[x].revalidate();
				panelArray[x].repaint();
			}
//			panelTop.remove(labelTime);
			container.remove(panelNumber);
			container.remove(panelNumber2);
			container.invalidate();
			container.repaint();
			startNum = 1;
		}
		// 1~25���� ��ư
		if(startNum >=1 && startNum <=25) {
			for(int x=0;x<buttons1.length;x++) {
				if(startNum == Integer.parseInt(buttons1[x].getText())) {
					if(e.getSource() == buttons1[x]) {
						panelArray[x].remove(buttons1[x]);
						panelArray[x].invalidate();
						panelArray[x].add(buttons2[x]);
						panelArray[x].revalidate();
						panelArray[x].repaint();
						labelCurrentNumber.setText("Click [ " + String.valueOf(startNum+1) + " ]");
						startNum++;
					}
				}
			}
		}
		// 26~50���� ��ư
		if(startNum >= 26 && startNum <= 50) {
			for(int x=0;x<buttons2.length;x++) {
				if(startNum == Integer.parseInt(buttons2[x].getText())) {
					if(e.getSource() == buttons2[x]) {
						panelArray[x].remove(buttons2[x]);
						panelArray[x].invalidate();
						panelArray[x].repaint();
						labelCurrentNumber.setText("Click [ " + String.valueOf(startNum+1) + " ]");
						startNum++;
					}
				}
			}
		}
		// ���� Ŭ����
		if(startNum == 51) {
			tf = false;
			labelCurrentNumber.setText("");
			labelAcTime.setText(labelTime.getText());
			container.remove(panelNumber);
			container.invalidate();
			panelNumber2.setLayout(new GridLayout(3,1));
			panelNumber2.setBackground(Color.WHITE);
			panelNumber2.add(labelClear);
			panelNumber2.add(labelAcTime);
			panelNumber2.add(panelPlayerName);
			panelPlayerName.setLayout(new FlowLayout());
			panelPlayerName.add("West", labelPlayerName);
			panelPlayerName.add("Center", textFieldPlayerName);
			panelPlayerName.add("North", buttonEnroll);
			container.add("Center", panelNumber2);
			container.revalidate();
			container.repaint();
		}
	}

	@Override
	public void run() {
		for(int x=0;x<150;x++) {
			if(!tf) break;
			try {
				labelTime.setText(String.valueOf(x + "��"));
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

public class Game{
	public static void main(String[] args) {
		GameJFrame gameJFrame = new GameJFrame();
	}
}
