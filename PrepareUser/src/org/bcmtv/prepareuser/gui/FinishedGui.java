package org.bcmtv.prepareuser.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import org.bcmtv.prepareuser.PrepareUser;
import org.bcmtv.prepareuser.util.Log;

public class FinishedGui 
{
	JFrame frame;
	GuiManager guiManager;
	
	public static void main(String[] args)
	{
		if (Log.currentLog == null) {
			Log.currentLog = new Log();
		}
		
		FinishedGui gui = new FinishedGui(new GuiManager());
		gui.show();
	}
	
	public FinishedGui(GuiManager guiManager)
	{
		this.guiManager = guiManager;
	}
	
	public void show()
	{
		frame = new JFrame("Prepare Finished");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//main panel
		JPanel panel1 = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER, panel1);
		
		//center label
		JLabel label = new JLabel();
		panel1.add(BorderLayout.CENTER, label);
		
		if (PrepareUser.success)
		{
			label.setText("User Prepared Successfully!");
		}
		else
		{
			label.setText("User Prepare Unsuccessful");
		}
		
		//buttons panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel1.add(BorderLayout.SOUTH, panel);
		
		//quit button
		JButton quitButton = new JButton("Quit");
		panel.add(quitButton);
		quitButton.addActionListener(new QuitListener());
		
		//log button
		JButton logButton = new JButton("Log");
		panel.add(logButton);
		logButton.addActionListener(new LogListener());
		
		//render on screen
		frame.setSize(210, 100);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
	class QuitListener implements ActionListener
	{

		public void actionPerformed(ActionEvent event) 
		{
			System.exit(0);
		}
		
	}
	class LogListener implements ActionListener
	{
		//run when log button is pressed
		public void actionPerformed(ActionEvent event) {
			guiManager.showLog();
			
		}
		
	}
}