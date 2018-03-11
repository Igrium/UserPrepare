package org.bcmtv.prepareuser.util;

import java.util.ArrayList;

public class Log 
{
	public static Log currentLog;
	
	private ArrayList<String> log = new ArrayList<String>();
	
	public void add(String message)
	{
		System.out.println(message);
		log.add(message);
	}
	
	//gets everything that has been logged as a list
	public String[] getLog()
	{
		return log.toArray(new String[log.size()]);
	}
	
	public String getLogFormatted(String separator)
	{
		String[] array = this.getLog();
		String output = null;

		for (String s : array) {
		    output += s + separator;
		}
		
		return output;
	}
}
