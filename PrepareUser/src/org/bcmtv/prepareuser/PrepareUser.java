package org.bcmtv.prepareuser;

import org.bcmtv.prepareuser.gui.GuiManager;
import org.bcmtv.prepareuser.util.Log;

public class PrepareUser 
{
	public static void main(String[] args)
	{
		Log log = new Log();
		Log.currentLog = log;
		
		if (args.length == 1)
		{
			DeleteFiles deleteFiles = new DeleteFiles();
			deleteFiles.deleteFiles(args[0]);
		}
		else
		{
			GuiManager guiManager = new GuiManager();
			guiManager.init();
		}
	}
	
}
