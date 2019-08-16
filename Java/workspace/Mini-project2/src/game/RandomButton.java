package game;

import javax.swing.JButton;
public class RandomButton {
	JButton[] buttons;
	

	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}

	public void rand1() {
		int[] ran1 = new int[25];
		for(int x=0; x<ran1.length; x++) {			// 1~25
			ran1[x] = (int)((Math.random()*25) + 1);
			for(int y=0; y<x; y++) {
				if(ran1[x] == ran1[y]) {
					x--;
					break;
				}
			}
		}
		for(int x=0; x<=ran1.length-1; x++) {
			buttons[x].setText(String.valueOf(ran1[x]));
		}
		
		
	}
	
}
