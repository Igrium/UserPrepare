package org.bcmtv.prepareuser;

import java.io.File;

import org.bcmtv.prepareuser.util.FileUtil;
import org.bcmtv.prepareuser.util.Log;
import org.bcmtv.prepareuser.filedeleter.FileDeleter;

public class DeleteFiles 
{
	public void deleteFiles(String path)
	{
		//get files to delete
		String[] stringFiles = Constants.FILES_TO_DELETE;
		String[] stringFilesFull = FileUtil.makeFullPath(path, stringFiles);
		File[] files = FileUtil.convertStringsToFiles(stringFilesFull);
		
		//actually remove the files
		FileDeleter deleter = new FileDeleter();
		deleter.deleteFiles(files);
		Log.currentLog.add("Finished preparing account");
	}
	
	public static void main(String[] args)
	{
		if (Log.currentLog == null)
		{
			Log log = new Log();
			Log.currentLog = log;
		}
		
		if (args.length == 1)
		{
			DeleteFiles deleteFiles = new DeleteFiles();
			deleteFiles.deleteFiles(args[0]);
		}
		else
		{
			System.out.println("usage: java PrepareUser [folder]");
		}
	}
}
