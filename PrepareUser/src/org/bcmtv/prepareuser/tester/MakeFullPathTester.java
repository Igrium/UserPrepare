/*******************************************************************************
 * Source code copyright Berkeley Community Media. All rights reserved.
 ******************************************************************************/
package org.bcmtv.prepareuser.tester;

//Works
import java.io.File;

import org.bcmtv.prepareuser.filedeleter.FileDeleter;

public class MakeFullPathTester 
{
	public static void main(String args[])
	{
		FileDeleter fileDeleter = new FileDeleter();
		
		File[] files = 
			{new File("/Users/Sam54123/Documents/java/PrepareDefaultUser/TestFiles/File1.txt"),
			new File("/Users/Sam54123/Documents/java/PrepareDefaultUser/TestFiles/File2.txt")};
		
		for(File file:files)
		{
			System.out.println(file.exists());
		}
		fileDeleter.deleteFiles(files);
		
	}
}
