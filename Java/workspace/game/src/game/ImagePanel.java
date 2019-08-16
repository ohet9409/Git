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
	// 실제게임화면을표시할패널
	int count = 3;// 카운트다운표시용
	int x, y; // 좌표값
	int check; // 숫자체크용
	String time;// 클리어시간값표시용
	boolean game_start = false;
	Random ran_num = new Random();
	// 랜덤함수
	Vector rect_select = new Vector();
	// 1-50 숫자보관용 벡터
	SelectRect sr;

	public ImagePanel() {
		this.addMouseListener(this);
	}

	public void countDown(int count) {
		// 게임시간값을 받아와 카운트다운 표시
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
		// 게임기본세팅
		// 25개의사각박스와해당박스안에
		// 랜덤으로난수를발생시켜나온숫자를받아입력한다.
		this.game_start = game_start;
		if (this.game_start) {
			check = 1;
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					int num = 0;
					int xx = 5 + i * 80;
					int yy = 5 + j * 80;
					// 25개사각형좌표값들
					num = ran_num.nextInt(25) + 1;
					for (int k = 0; k < rect_select.size(); ++k) {
						sr = (SelectRect) rect_select.get(k);
						if (sr.number == num) {
							num = ran_num.nextInt(25) + 1;
							k = -1;
						}
					}
					// 중복없는난수발생
					sr = new SelectRect(xx, yy, num);
					rect_select.add(sr);
					// 받은좌표및난수값을객체화시켜벡터로저장
				}
			}
		}
	}

	public void paint(Graphics g) {
		g.drawRect(0, 0, 400, 400);
		// 게임화면 사각 테두리
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
				// 벡터에 저장된 각각의 숫자값을 받아서 사각형과 숫자 그리기
			}
		}
		g.setColor(Color.red);
		g.drawRect(x*80+5, y*80+5, 70, 70);
		//마우스로 선택된 사각박스를 붉게 표시 
	
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
