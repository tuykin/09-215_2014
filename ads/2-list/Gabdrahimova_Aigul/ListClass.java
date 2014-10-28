package list;

import java.io.*;
import java.util.*;


public class ListClass {
	public static void EnterFile (List<String> lines, FileReader fr ) throws IOException
	{
		BufferedReader reader = new BufferedReader(fr);
		String line;
		while ((line = reader.readLine()) != null) 
			lines.add(line);
		reader.close();
		fr.close();
    }
	
	public static void PrintFile (List<String> lines, FileWriter fw ) throws IOException
	{
		 Iterator<String> iterator = lines.iterator();
	     while(iterator.hasNext())
	      	{
	    	  fw.write(iterator.next());
	      	  fw.write(System.getProperty( "line.separator" ));
	      	}
	     fw.close();
	}
	
	public static void DeleteZ (List<String> lines) throws IOException
	{
		Iterator<String> i = lines.iterator();
	     while(i.hasNext())
    		if ( i.next().charAt(0)== 'z')
    			i.remove();
	}
}
