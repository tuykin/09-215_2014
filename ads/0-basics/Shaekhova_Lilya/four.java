import java.util.Scanner;

public class four {

    public static int alg(int a,int b) {
        System.out.print("Последовательность p,q: " + a + "," + b + '\t');

        while (b != 0) {
            int temp = a%b;
            a = b;
            b = temp;
            System.out.print(a + "," + b + '\t');
        }
        System.out.println();
        return a;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Введите два числа: ");
        int a=sc.nextInt();
        int b=sc.nextInt();

        System.out.println("НОД: " + alg(a,b));

        sc.close();
    }
}