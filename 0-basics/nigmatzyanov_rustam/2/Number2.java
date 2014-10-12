package basics;
import java.util.Scanner;

public class Number2 {

	private static boolean isPalindrome(String str) {
        if (str == null)
            return false;
        
        int length = str.length();
        
        for (int i = 0; i < length / 2; i++) { //сравниваем символы в строке с обеих сторон
            if (str.charAt(i) != str.charAt(length - i - 1))
                return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Введите строку: ");
		String str=sc.nextLine();
		
		if (isPalindrome(str))
			System.out.println("Палиндром");
		else
			System.out.println("Не палиндром");
		
		sc.close();
	}
}
