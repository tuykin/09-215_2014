import java.util.Random;
import java.util.Scanner;


public class Logical_array {
        
    public static void main(String[] args) {
    	Scanner in=new Scanner(System.in);
		Random myrandom=new Random();
		int n,m;
		n=in.nextInt(); 
		m=in.nextInt();
		in.close();
		Boolean[][]array=new Boolean[n][m];
		
		for (int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				array[i][j]=myrandom.nextBoolean();
		for (int i=0; i<n; i++)
			for(int j=0; j<m; j++)
			if(array[i][j])
				{
                    System.out.print(i);
                    System.out.print(j);
                     System.out.print('*');
				}
			else
				{
                    System.out.print(i);
                    System.out.print(j);
                     System.out.print('_');
    			}
				
		}		
	}			
	
		
				
				
				
				
				
				
				
				
		

