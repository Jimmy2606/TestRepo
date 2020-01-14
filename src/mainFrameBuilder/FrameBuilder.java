package mainFrameBuilder;

import javax.swing.JFrame;

public abstract class FrameBuilder extends JFrame{
	protected abstract void createMenuBar();
	protected abstract void createTitleBar();
	protected abstract void createContentPanel();
	public abstract void createFrame();
}
