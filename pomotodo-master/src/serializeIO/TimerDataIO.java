package serializeIO;

import timer.TimerData;

public class TimerDataIO extends SerializeIO{
	private static TimerDataIO timeDataIOInstance = null;
	
	public static TimerDataIO getInstance() {
      if (timeDataIOInstance == null) {
         synchronized(TimerDataIO.class) {
            if (timeDataIOInstance == null) {
            	timeDataIOInstance = new TimerDataIO();
            }
         }
      }

      return timeDataIOInstance;
   }
	
	private TimerDataIO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public TimerData loadDataFromSerFile() {
      TimerData timerData;
      if ((timerData = (TimerData)read("setting.ser")) == null) {
         timerData = new TimerData();
         save("setting.ser", timerData);
      }

      return timerData;
	}

	@Override
	public void saveDataToSerFile(Object obj) {
		save("setting.ser", obj);
	}
}
