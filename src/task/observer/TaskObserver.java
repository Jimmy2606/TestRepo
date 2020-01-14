package task.observer;

import task.TaskData;

public interface TaskObserver {
	   void stop();

	   void start(TaskData var1);

	   void done(TaskData var1);

	   void remove(TaskData var1);
}