/*******************************************************************************
 * Source code copyright Berkeley Community Media. All rights reserved.
 ******************************************************************************/
package org.bcmtv.prepareuser.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class FileUtil {
	
	//returns a String array consisting of the individual lines of a .txt file
	public static File[] convertStringsToFiles(String[] strings) 
	{
		//create object
		List<File> files = new ArrayList<File>();
		
		//go through fine adding lines to list
		for (String string:strings)
		{
			files.add(new File(string));
		}
		
		return files.toArray(new File[0]);
	}
	
	//takes the relative path of files and converts it to the full path
	public static String[] makeFullPath(String path, String[] files)
	{
		//create arraylist
		List<String> newFiles = new ArrayList<String>();
		
		//make sure the path doesn't have a spare slash at the end
		if(path.substring(path.length() - 1) == "/")
		{
			path = path.substring(0, path.length() -1);
		}
		
		//add the full path
		for (String currentFile:files)
		{
			newFiles.add(path+"/"+currentFile);
		}
		
		return newFiles.toArray(new String[0]);
		
	}

}
