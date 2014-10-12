package basics;
import java.util.Scanner;

public class Number3 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		
		System.out.println("Кол-во строк в таблице: ");
		int n=Integer.parseInt(sc.nextLine());
		
		String[]str=new String[n];
		
		System.out.println("Введите имя, первое число, второе число (через пробел)");
		for (int i=0; i<n; i++)
			str[i]=sc.nextLine();
		
		System.out.printf("|%15s| %10s| %10s| %13s| \n", "Имя","Число a","Число b","a/b");
		for (int i=0; i<n; i++){
			String []sub=str[i].split(" "); //разбиваем строку на подстроки
			
			String name=sub[0];
			Integer a=Integer.parseInt(sub[1]);
			Integer b=Integer.parseInt(sub[2]);

			System.out.printf("|%15s| %10d| %10d| %13.3f| \n", name,a,b,(double)a/b);
		}
			
		sc.close();
	}
}
