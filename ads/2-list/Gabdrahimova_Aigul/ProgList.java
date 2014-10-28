package list;

import java.io.*;
import java.util.*;

public class ProgList 
{   
    public static void main(String[] args) throws IOException
	{
    	FileReader fread = new FileReader("C:\\Users\\Админ\\Documents\\GitHub\\ads_3_2014\\ads\\2-list\\Gabdrahimova_Aigul\\words.txt");
        FileWriter fwrite = new FileWriter("C:\\Users\\Админ\\Documents\\GitHub\\ads_3_2014\\ads\\2-list\\Gabdrahimova_Aigul\\test.txt");
        List<String> line = new ArrayList<String>();
    	
    	ListClass.EnterFile(line, fread);
    	ListClass.DeleteZ (line);
    	ListClass.PrintFile (line, fwrite);
	}
}