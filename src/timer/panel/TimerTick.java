package timer.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import timer.TimerData;

public class TimerTick {
	
	public TimerTick() {
		TimerData t = new TimerData();
		this.countdown(t);
	}
	
	public void countdown(TimerData t) {
		while(true) {
			int min = t.work_min;
			int sec = t.work_sec;
			for (int i = min; i >= 0 ; i--) {
				for (int j = sec; j >=0; j--) {
					try {
						Thread.sleep(1000);
						System.out.println(i+":"+j);
					} catch (InterruptedException e) {
					}
				}
				sec = 59;
				
			}
		}
	}
	
}
