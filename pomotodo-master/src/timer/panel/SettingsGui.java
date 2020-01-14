package timer.panel;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import facade.Facade;
import serializeIO.TimerDataIO;
import timer.TimerData;

public class SettingsGui extends JFrame implements ActionListener{
	 	private JSpinner work_min;
	    private JSpinner work_sec;
	    private JSpinner rest_min;
	    private JSpinner rest_sec;
	    private JButton btn_save;
	    
	    public SettingsGui(TimerData t) {
			this.setTitle("Timer Setting");
			this.createLayout();
			this.setTimerValue(t);
			this.createLabel();
			this.createSaveButton();
			System.out.println(this.work_min.getValue());
			this.setVisible(true);
		}
	    
	    public final void setTimerValue(TimerData t) {
	        this.work_min.setValue(t.work_min);
	        
	        this.work_sec.setValue(t.work_sec);
	        this.rest_min.setValue(t.rest_min);
	        this.rest_sec.setValue(t.rest_sec);
	    }
	    
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (actionEvent.getSource() == this.btn_save) {
	            Integer work_min = (Integer)this.work_min.getValue();
	            Integer work_sec = (Integer)this.work_sec.getValue();
	            Integer rest_min = (Integer)this.rest_min.getValue();
	            Integer rest_sec = (Integer)this.rest_sec.getValue();
	            
	            Facade.getInstace().timerData.work_min = work_min;
	            Facade.getInstace().timerData.work_sec = work_sec;
	            System.out.println(Facade.getInstace().timerData.work_min);
	            Facade.getInstace().timerData.rest_min = rest_min;
	            Facade.getInstace().timerData.rest_sec = rest_sec;
	            TimerDataIO.getInstance().saveDataToSerFile(Facade.getInstace().timerData);
	          
	            this.setVisible(false);
	            this.dispose();
	        }
		}
		
		public void createLayout(){
			 this.setDefaultCloseOperation(1);
	         this.setSize(300, 200);
	         this.setLocationRelativeTo(null);
	         this.setLayout(new GridLayout(5, 1));
	         
	         this.createSpinner();
	         
		}
		protected void createSaveButton() {
			  JPanel saveJPanel= new JPanel();
		      this.btn_save = new JButton("Save");
		      saveJPanel.add(this.btn_save);
		      this.add(saveJPanel);
		     
		      this.btn_save.addActionListener(this);
		}
		protected void createLabel() {
			JPanel workMinuteJpanel= new JPanel();
			workMinuteJpanel.add(new JLabel("Work Minute"));
	        workMinuteJpanel.add(this.work_min);
	        
	        JPanel workSecondJpanel= new JPanel();
	        workSecondJpanel .add(new JLabel("Work Second"));
	        workSecondJpanel.add(this.work_sec);
	        
	        JPanel restMinuteJpanel = new JPanel();
	        restMinuteJpanel.add(new JLabel("Rest Minute"));
	        restMinuteJpanel.add(this.rest_min);
	        
	        JPanel restSecondJpanel= new JPanel();
	        restSecondJpanel.add(new JLabel("Rest Second"));
	        restSecondJpanel.add(this.rest_sec);
	        
	        this.add(workMinuteJpanel);
	        this.add(workSecondJpanel);
	        this.add(restMinuteJpanel);
	        this.add(restSecondJpanel);
		}
		protected void createSpinner(){
			  (this.work_min = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1))).setPreferredSize(new Dimension(50, 25));
		         (this.work_sec = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1))).setPreferredSize(new Dimension(50, 25));
		         (this.rest_min = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1))).setPreferredSize(new Dimension(50, 25));
		         (this.rest_sec = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1))).setPreferredSize(new Dimension(50, 25));
		}
}
