package menuBarBuilder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import facade.Facade;
import timer.panel.SettingsGui;

public class MyMenuBar extends MenuBarBuilder{
	private JMenu menu;

	private JMenuItem setting;
	private JMenuItem undo;
	private JMenuItem redo;
	private JMenuItem close;
	
	public MyMenuBar() {
		super();
		this.menu = new JMenu("File");
		this.setting = new JMenuItem("Setting");
		this.setting.setAccelerator(KeyStroke.getKeyStroke(83,128));
		this.undo = new JMenuItem("Undo");
		this.undo.setAccelerator(KeyStroke.getKeyStroke(90,128));
		this.redo = new JMenuItem("Redo");
		this.redo.setAccelerator(KeyStroke.getKeyStroke(89,128));
		this.close = new JMenuItem("Close");
		this.close.setAccelerator(KeyStroke.getKeyStroke(88,128));
		
		this.generateMenuItem();
	}

	@Override
	public void generateMenuItem() {
		
		this.menu.add(this.setting);
		this.menu.add(this.undo);
		this.menu.add(this.redo);
		this.menu.add(this.close);
		this.add(this.menu);
		this.setting.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Facade.getInstace().setting == null) {
					Facade.getInstace().setting = new SettingsGui(Facade.getInstace().timerData);
				}else {
					Facade.getInstace().setting.setTimerValue(Facade.getInstace().timerData);
					Facade.getInstace().setting.setVisible(true);
				}
				
			}
		});
		this.close.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 Facade.getInstace().mainFrame.dispose();
				
			}
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

}
