import java.util.Scanner;

public class Palindrom 
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s=in.nextLine();

		if(isPalindrom(s))
		{
			System.out.println("YES");
		}
		else
		{
			System.out.println("NO");
		}
	}
	
	public static boolean isPalindrom(String s)
	{
		for(int i=0; i<s.length()/2; i++)
		if(s.charAt(i)!=s.charAt(s.length()-i-1))
		return false;
		return true;
	}
	
}
