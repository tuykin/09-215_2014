package basics;
import java.util.Random;
import java.util.Scanner;

public class Number1 {
	public static int digit(int n){ //разрядность числа
		if (n>0 & n<10) return 1; //числа 1-9
		if (n>9 & n<100) return 2; //числа 10-99
		
		return 0; //числа 100-...
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Random rand=new Random();
		int n,m;
		
		System.out.println("Введите размерность массива: ");
		n=sc.nextInt(); 
		m=sc.nextInt();
		
		Boolean[][]array=new Boolean[n][m];
		
		for (int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				array[i][j]=rand.nextBoolean();
		
		System.out.println("Массив: ");
		System.out.print("  ");
		for(int i = 0; i < m; i++) { //цикл для печати номеров столбцов
			System.out.print(i+1);
			
			if (digit(i+1)==1) System.out.print("  ");
			else
				if (digit(i+1)==2) System.out.print(" ");	
				else System.out.print("");	
		}
		
		for (int i=0; i<n; i++) {
			System.out.println();
			if (i<9) //печать номеров строк
				System.out.print(i+1 + " "); 
			else
				System.out.print(i+1);
			
			for(int j=0; j<m; j++) {
				if (array[i][j])
					System.out.print("*  ");
				else
					System.out.print("   ");
			}
			System.out.println();
		}
		sc.close();
	}
}
