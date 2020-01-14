import facade.Facade;
import timer.TimerData;
import timer.panel.SettingsGui;

public class Main {
	public Main() {
		Facade.getInstace().generateMainFrame();
	}
	public static void main(String[] args) {

		new Main();
	}
}