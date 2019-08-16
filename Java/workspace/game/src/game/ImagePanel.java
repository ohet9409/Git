package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.JPanel;

public class ImagePanel extends JPanel implements MouseListener {
	// ��������ȭ����ǥ�����г�
	int count = 3;// ī��Ʈ�ٿ�ǥ�ÿ�
	int x, y; // ��ǥ��
	int check; // ����üũ��
	String time;// Ŭ����ð���ǥ�ÿ�
	boolean game_start = false;
	Random ran_num = new Random();
	// �����Լ�
	Vector rect_select = new Vector();
	// 1-50 ���ں����� ����
	SelectRect sr;

	public ImagePanel() {
		this.addMouseListener(this);
	}

	public void countDown(int count) {
		// ���ӽð����� �޾ƿ� ī��Ʈ�ٿ� ǥ��
		switch (count) {
		case 0:
			this.count = 3;
			break;
		case 1:
			this.count = 2;
			break;

		case 2:
			this.count = 1;
			break;
		case 3:
			this.count = 0;
			game_start = false;
			break;
		}

	}

	public void gameStart(boolean game_start) {
		// ���ӱ⺻����
		// 25���ǻ簢�ڽ����ش�ڽ��ȿ�
		// �������γ������߻����ѳ��¼��ڸ��޾��Է��Ѵ�.
		this.game_start = game_start;
		if (this.game_start) {
			check = 1;
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					int num = 0;
					int xx = 5 + i * 80;
					int yy = 5 + j * 80;
					// 25���簢����ǥ����
					num = ran_num.nextInt(25) + 1;
					for (int k = 0; k < rect_select.size(); ++k) {
						sr = (SelectRect) rect_select.get(k);
						if (sr.number == num) {
							num = ran_num.nextInt(25) + 1;
							k = -1;
						}
					}
					// �ߺ����³����߻�
					sr = new SelectRect(xx, yy, num);
					rect_select.add(sr);
					// ������ǥ�׳���������üȭ���Ѻ��ͷ�����
				}
			}
		}
	}

	public void paint(Graphics g) {
		g.drawRect(0, 0, 400, 400);
		// ����ȭ�� �簢 �׵θ�
		if(game_start) {
			g.setFont(new Font("Default",Font.BOLD,50));
			g.drawString("CountDown", 70, 150);
			g.setFont(new Font("Default",Font.BOLD,100));
			g.drawString(""+count, 170, 250);
		} else if ( !game_start && count == 0 ) {
			for (int i = 0; i < rect_select.size(); ++i) {
				sr = (SelectRect) rect_select.get(i);
				g.drawRect(sr.x, sr.y, 70, 70);
				g.setFont(new Font("Default", Font.BOLD, 30));
				g.drawString("" + sr.number, sr.x + 22, sr.y + 45);
				// ���Ϳ� ����� ������ ���ڰ��� �޾Ƽ� �簢���� ���� �׸���
			}
		}
		g.setColor(Color.red);
		g.drawRect(x*80+5, y*80+5, 70, 70);
		//���콺�� ���õ� �簢�ڽ��� �Ӱ� ǥ�� 
	
	if(check > 50) {
		g.setColor(Color.blue);
		g.setFont(new Font("Default", Font.BOLD, 50));
		g.drawString("GAME CLEAR!", 40, 150);
		g.setColor(Color.red);
		g.setFont(new Font("Default", Font.BOLD, 40));
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
