/*******************************************************************************
 * Source code copyright Berkeley Community Media. All rights reserved.
 ******************************************************************************/
package org.bcmtv.prepareuser.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class TxtToArray {
	
	//returns a String array consisting of the individual lines of a .txt file
	public static String[] convert(File file) throws FileNotFoundException 
	{
		//create objects
		Scanner sc = new Scanner(file);
		List<String> lines = new ArrayList<String>();
		
		//go through fine adding lines to list
		while (sc.hasNextLine())
		{
			lines.add(sc.nextLine());
		}
		sc.close();
		
		return lines.toArray(new String[0]);
	}

}
