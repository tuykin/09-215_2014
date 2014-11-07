package list;

import java.io.*;

public class ProgList 
{   
    public static void main(String[] args) throws IOException
	{
    	FileWriter fwrite = new FileWriter("D:\\ява\\vect1\\src\\list\\test1.txt");
    	FileReader fread = new FileReader("D:\\ява\\vect1\\src\\list\\words.txt");
    	ListClass line = new ListClass();
    	    	
    	ListClass.EnterFile(fread);
    	line.DeleteZ ();
    	ListClass.PrintFile (fwrite);
	}
}