package org.bcmtv.prepareuser.gui;

public class GuiManager {
	public void init()
	{
		ChooseFileGui fileGui = new ChooseFileGui(this);
		fileGui.show();
	}
	
	public void showDone()
	{
		FinishedGui finishedGui = new FinishedGui(this);
		finishedGui.show();
	}
	
	public void showLog()
	{
		LogGui logGui = new LogGui();
		logGui.show();
	}
}
