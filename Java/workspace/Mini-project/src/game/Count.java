package game;

import javax.swing.JLabel;

class ThreadTimer extends Thread{
	JLabel labelTime;
	
	public void setLabelTime(JLabel labelTime) {
		this.labelTime = labelTime;
	}
	
	int i = 0;
	public void run() {
		while(true)
		{
			try {
				labelTime.setText(String.valueOf(i));
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}	
	}
	
}
public class Count{
	public static void main(String[] args) {
		ThreadTimer threadTimer = new ThreadTimer();
		threadTimer.start();
	}
}
