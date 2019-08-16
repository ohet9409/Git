package game;

import javax.swing.JButton;

public class RandomButton2 {
	JButton[] buttons;
	
	public void setButtons(JButton[] buttons) {
		this.buttons = buttons;
	}
	
	public void rand2() {
		int[] ran2 = new int[25];
		for(int x=0; x<ran2.length; x++) {			// 26~50
			ran2[x] = (int)((Math.random()*25) + 26);
			for(int y=0; y<x; y++) {
				if(ran2[x] == ran2[y]) {
					x--;
					break;
				}
			}
		}
		for(int x=0; x<=ran2.length-1; x++) {
			buttons[x].setText(String.valueOf(ran2[x]));
		}
		
		
	}
	
}
