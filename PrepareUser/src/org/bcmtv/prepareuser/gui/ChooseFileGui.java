package org.bcmtv.prepareuser.gui;

import javax.swing.*;

import org.bcmtv.prepareuser.DeleteFiles;
import org.bcmtv.prepareuser.util.Log;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ChooseFileGui 
{
	private GuiManager guiManager;
	private JFrame frame;
	private JTextField fileLocationField;
	private JFileChooser fileChooser;
	public static void main(String args[])
	{
		if(Log.currentLog == null)
		{
			Log.currentLog = new Log();
		}
		ChooseFileGui gui = new ChooseFileGui(new GuiManager());
		gui.show();
	}
	
	public ChooseFileGui(GuiManager guiManager)
	{
		this.guiManager = guiManager;
	}
	
	public void show()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//top panel
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
		
		JPanel choosePanel = new JPanel();
		choosePanel.setLayout(new BoxLayout(choosePanel, BoxLayout.X_AXIS));
		topPanel.add(choosePanel);
		
		frame.getContentPane().add(BorderLayout.NORTH, topPanel);
		
		//choose file button
		JButton chooseButton = new JButton("choose file");
		choosePanel.add(chooseButton);
		chooseButton.addActionListener(new ChooseButtonListener());
		
		//file chooser
		fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File("~"));
		fileChooser.setDialogTitle("Chooae File");
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		//file text field
		fileLocationField = new JTextField();
		choosePanel.add(fileLocationField);
		
		//bottom button
		JButton goButton = new JButton("Prepare");
		goButton.addActionListener(new GoButtonListener());
		frame.getContentPane().add(BorderLayout.SOUTH, goButton);
		
		
		//render on screen
		frame.setSize(350, 200);
		frame.setResizable(false);
		frame.setVisible(true);
		
	}
	
	class ChooseButtonListener implements ActionListener
	{
		//run when choose file button pressed
		@Override
		public void actionPerformed(ActionEvent event) {
			Log.currentLog.add("pressed");
			if (fileChooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION)
			{
				fileLocationField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			}
			
		}
		
	}
	
	class GoButtonListener implements ActionListener
	{
		//run when Prepare button pressed
		@Override
		public void actionPerformed(ActionEvent event) {
			Log.currentLog.add("Preparing template account...");
			
			DeleteFiles delete = new DeleteFiles();
			delete.deleteFiles(fileLocationField.getText());
			
			guiManager.showDone();
			frame.dispose();
			
		}
		
	}
}
