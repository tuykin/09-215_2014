package list;

import java.io.*;
//import java.util.*;


public class ListClass 
{
	private static  Term first; 
	
	public static void AddListTerm (String str)
	{
		if (ListClass.first == null) 
			ListClass.first = new Term(str);
		else 
		{
			Term current = ListClass.first; 
			while (current.next != null)
				current = current.next;
			Term adding = new Term(str);
			current.next = adding;
		}
	}
	
	public static void EnterFile ( FileReader fr ) throws IOException
	{
		BufferedReader reader = new BufferedReader(fr);
		String line;
		while ((line = reader.readLine()) != null) 
			AddListTerm(line);
		reader.close();
		fr.close();
    }
	
	public static void PrintFile (FileWriter fw ) throws IOException
	{
			Term current = ListClass.first; 
			while (current != null)
			{
	    	  fw.write(current.info);
	      	  fw.write(System.getProperty( "line.separator" ));
	      	  current = current.next;
	      	}
		
	 fw.close();
	}		
	
	public void DeleteZ() 
	{ 
		Term current = ListClass.first;
		while (current != null) 
		{
			if (current.info.charAt(0) == 'z') 
				if (current == ListClass.first)
				{ 
					ListClass.first = current.next;
					current.next = null;
					current = ListClass.first;
				} 
				else 
				{
					Term previous=ListClass.first; 
					while(previous.next != current)
						previous = previous.next;
					previous.next = current.next;
					current.next = null;
					current = previous.next;
				}
			else
				current = current.next;
		}
	}
}