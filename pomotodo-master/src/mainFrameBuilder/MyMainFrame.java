package mainFrameBuilder;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import menuBarBuilder.MenuBarBuilder;
import menuBarBuilder.MyMenuBar;

public class MyMainFrame extends FrameBuilder{
	private MenuBarBuilder menuBar = new MyMenuBar() ;
	
	public void createFrame() {
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.createTitleBar();
		this.createMenuBar();
		this.createContentPanel();
		this.setVisible(true);
	}
	protected void createMenuBar() {
		
		this.setJMenuBar(this.menuBar);
	}
	@Override
	protected void createTitleBar() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void createContentPanel() {
		// TODO Auto-generated method stub
		
	}
}
