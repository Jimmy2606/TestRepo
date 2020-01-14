package task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class TaskData implements Serializable {
	public ArrayList childTask;
	private TaskData parentTask;
	public int level;
	public String taskName;
	
	 public TaskData(TaskData currTask) {
	      this.parentTask = currTask.parentTask;
	      this.level = currTask.level;
	      this.taskName = currTask.taskName;
	      
	      this.childTask = new ArrayList();
	      Iterator taskItterator = currTask.childTask.iterator();

	      while(taskItterator.hasNext()) {
	         currTask = (TaskData)taskItterator.next();
	         this.childTask.add(new TaskData(currTask));
	      }

	   }
	public TaskData(String taskName, TaskData parentTask) {
	      this.childTask = new ArrayList();
	      this.taskName = taskName;
	      
	      if (parentTask != null) {
	    	  this.parentTask = parentTask;
	         this.level = parentTask.level + 1;
	      } else {
	         this.parentTask = null;
	         this.level = 1;
	      }
	   }
}
