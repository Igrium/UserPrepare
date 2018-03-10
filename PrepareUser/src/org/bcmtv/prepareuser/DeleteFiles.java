package org.bcmtv.prepareuser;

import java.io.File;

import org.bcmtv.prepareuser.util.FileUtil;
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
	}
	
	public static void main(String[] args)
	{
		DeleteFiles deleteFiles = new DeleteFiles();
		deleteFiles.deleteFiles(args[0]);
	}
}
