package facade;


import mainFrameBuilder.FrameBuilder;
import mainFrameBuilder.MyMainFrame;
import serializeIO.TimerDataIO;
import timer.TimerData;
import timer.panel.SettingsGui;

public class Facade {
	public volatile static Facade instance;
	
	public FrameBuilder mainFrame;
	public SettingsGui setting;
	public TimerData timerData = TimerDataIO.getInstance().loadDataFromSerFile();
	private Facade() {
		mainFrame = new MyMainFrame();
	}
	
	public static Facade getInstace() {
		if(instance == null) {
			synchronized (Facade.class) {
				if(instance == null) {
					instance = new Facade();
				}
			}
		}
		return instance;
	}
	public void generateMainFrame() {
		this.mainFrame.createFrame();
	}
}
