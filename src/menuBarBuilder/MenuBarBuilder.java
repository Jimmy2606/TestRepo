package menuBarBuilder;

import java.awt.event.ActionListener;

import javax.swing.JMenuBar;

public abstract class MenuBarBuilder extends JMenuBar implements ActionListener{
	public abstract void generateMenuItem();
}
