package work1;

import java.util.Scanner;

public class program2 {
	
public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		String str= scan.nextLine();
		String strCopy=new String("");
		for(int i=str.length()-1;i>=0;i--)
		{
			strCopy=strCopy+str.charAt(i);
		
		}
		if(str.equals(strCopy))
			System.out.println("string is a palindrome");
		else
			System.out.println("string isn't a palindrome");
		
	}
}
