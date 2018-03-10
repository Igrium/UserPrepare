/*******************************************************************************
 * Source code copyright Berkeley Community Media. All rights reserved.
 ******************************************************************************/
//Works
package org.bcmtv.prepareuser.tester;

import java.util.Arrays;

import org.bcmtv.prepareuser.util.FileUtil;


public class FileDeleterTester 
{
	private final static String[] STRING_FILES =
		{
				"Folder1/File1.txt",
				"Folder1/File3.txt"
		};
	public static void main(String args[])
	{
		String[] updatedFiles = FileUtil.makeFullPath("/Users/Sam54123/Documents/java/PrepareDefaultUser/TestFiles", STRING_FILES);
		
		System.out.println(Arrays.toString(updatedFiles));
		
	}
}
