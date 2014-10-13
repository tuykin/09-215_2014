package work1;

import java.util.InputMismatchException;
import java.util.Scanner;
public class program5 {
	
	public static int fact(int arg){ //функция для факториала
		
		if(arg!=1)
			return arg*fact(arg-1);
		else
			return 1;
	}
	public static void main(String[] args){
		try{
		Scanner scan=new Scanner(System.in);
		int arg=scan.nextInt();
		System.out.println(Math.log(fact(arg)));
		scan.close();
		}
		catch(InputMismatchException e)
		{
			System.out.println(e.toString());
		
		}
	}

}
