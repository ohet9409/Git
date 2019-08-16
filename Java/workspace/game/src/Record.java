import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Canvas;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class Record extends JFrame {

	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Label label_1;
	private JButton button;
	private final JLabel lblNewLabel = new JLabel("New label");
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_5;
	private JPanel panel_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPanel panel_5;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JPanel panel_6;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JLabel label;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JPanel panel_7;
	private JPanel panel_8;
	private Label label_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Record frame = new Record();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Record() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 527);
		contentPane = new JPanel();
		contentPane.setForeground(SystemColor.desktop);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon("D:\\android_3rd_oh\\java\\\uC790\uB8CC\\img\\rank.png"));
		lblNewLabel.setBounds(234, 10, 172, 148);
		contentPane.add(lblNewLabel);
		
		button = new JButton("순위 검색");
		button.setBounds(433, 135, 121, 25);
		contentPane.add(button);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		button.setFont(new Font("굴림", Font.BOLD, 13));
		
		label_1 = new Label("순위");
		label_1.setBounds(74, 167, 120, 28);
		contentPane.add(label_1);
		label_1.setFont(new Font("Dialog", Font.BOLD, 17));
		label_1.setForeground(SystemColor.desktop);
		label_1.setAlignment(Label.CENTER);
		label_1.setBackground(new Color(250, 250, 210));
		
		panel_7 = new JPanel();
		panel_7.setBounds(73, 166, 492, 290);
		contentPane.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_7.add(panel_2, BorderLayout.EAST);
		panel_2.setLayout(new GridLayout(5, 1, 0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(248, 248, 255), 2, true));
		panel_2.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 4, 10, 10));
		
		lblNewLabel_1 = new JLabel("");
		panel_3.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\android_3rd_oh\\java\\\uC790\uB8CC\\img\\1.png"));
		
		textField = new JTextField();
		textField.setColumns(10);
		panel_3.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_3.add(textField_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		panel_3.add(textField_5);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(248, 248, 255), 2, true));
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 4, 10, 10));
		
		label = new JLabel("");
		panel_4.add(label);
		label.setIcon(new ImageIcon("D:\\android_3rd_oh\\java\\\uC790\uB8CC\\img\\2.png"));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		panel_4.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		panel_4.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		panel_4.add(textField_8);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(248, 248, 255), 2, true));
		panel_2.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 4, 10, 10));
		
		label_5 = new JLabel("");
		panel_5.add(label_5);
		label_5.setIcon(new ImageIcon("D:\\android_3rd_oh\\java\\\uC790\uB8CC\\img\\3.png"));
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_5.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		panel_5.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		panel_5.add(textField_11);
		
		panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(248, 248, 255), 2, true));
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(0, 4, 10, 10));
		
		label_6 = new JLabel("4\uC704");
		panel_6.add(label_6);
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		panel_6.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		panel_6.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		panel_6.add(textField_14);
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setBorder(new LineBorder(new Color(248, 248, 255), 2, true));
		panel.setLayout(new GridLayout(0, 4, 10, 10));
		
		label_7 = new JLabel("5\uC704");
		panel.add(label_7);
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		panel.add(textField_4);
		
		panel_8 = new JPanel();
		panel_7.add(panel_8, BorderLayout.NORTH);
		panel_8.setLayout(new GridLayout(0, 4, 0, 0));
		
		Label label_2 = new Label("ID");
		panel_8.add(label_2);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Dialog", Font.BOLD, 17));
		label_2.setBackground(new Color(250, 250, 210));
		label_2.setAlignment(Label.CENTER);
		
		label_8 = new Label("ID");
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Dialog", Font.BOLD, 17));
		label_8.setBackground(new Color(250, 250, 210));
		label_8.setAlignment(Label.CENTER);
		panel_8.add(label_8);
		
		Label label_3 = new Label("기록");
		panel_8.add(label_3);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Dialog", Font.BOLD, 17));
		label_3.setBackground(new Color(250, 250, 210));
		label_3.setAlignment(Label.CENTER);
		
		Label label_4 = new Label("날짜");
		panel_8.add(label_4);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Dialog", Font.BOLD, 17));
		label_4.setBackground(new Color(250, 250, 210));
		label_4.setAlignment(Label.CENTER);
		
		JLabel Back = new JLabel("New label");
		Back.setIcon(new ImageIcon("D:\\android_3rd_oh\\java\\\uC790\uB8CC\\img\\back.gif"));
		Back.setBounds(0, 0, 655, 496);
		contentPane.add(Back);
	}
}
