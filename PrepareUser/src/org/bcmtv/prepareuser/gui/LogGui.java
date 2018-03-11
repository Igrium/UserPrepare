package org.bcmtv.prepareuser.gui;

import java.awt.BorderLayout;

import javax.swing.*;

import org.bcmtv.prepareuser.util.Log;

public class LogGui 
{
	JFrame frame;
	JTextArea text;
	
	public static void Main(String[] args)
	{
		Log.currentLog = new Log();
		
		LogGui gui = new LogGui();
		gui.show();
	}
	
	public void show()
	{
		frame = new JFrame();
		text = new JTextArea(10,20);
		text.setLineWrap(false);
		text.setEditable(false);
		text.setText(Log.currentLog.getLogFormatted("\n"));
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		frame.getContentPane().add(BorderLayout.CENTER, scroller);
		
		//render
		frame.setSize(700,600);
		frame.setVisible(true);
	}
}
