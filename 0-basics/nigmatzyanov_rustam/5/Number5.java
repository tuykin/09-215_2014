package basics;

public class Number5 {
	
	public static double logfactorial(int n) {
		if (n == 1) 
			return 0;
		
		return Math.log(n)+logfactorial(n-1);
	}

	public static void main(String[] args) {

		System.out.println("Результат: " + logfactorial(5));
		System.out.println("Для сравнения: " + Math.log(120));
	}
}
