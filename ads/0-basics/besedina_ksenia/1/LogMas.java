package logmas;
import java.util.Random;

public class LogMas 
{
	public static final int n=10;
	public static final int m=10;
	public static void main(String[] args) 
	{
		Random rand = new Random();
		boolean [][] bool=new boolean [n][m];
		for(int i=0; i<n; i++)
			bool[i]=new boolean [n];
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
			{
				bool[i][j]=rand.nextBoolean();
			}
		}
		System.out.print(" ");
		for(int j=0;j<m;j++)
		{
			System.out.print(" ");
			System.out.print(j+1);
		}
		System.out.println();
		for(int i=0;i<n;i++)
		{
			System.out.print(i+1);
			System.out.print(" ");
			for(int j=0;j<m;j++)
			{
				if(bool[i][j]==true)
				{
					System.out.print("*");
					System.out.print(" ");
				}
				else
				{
					System.out.print(" ");
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
