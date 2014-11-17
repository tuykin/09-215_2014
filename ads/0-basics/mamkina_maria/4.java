import java.util.Scanner;

public class Nod {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int n,m;
        n=scan.nextInt();
        m=scan.nextInt();
        scan.close();
        if(m>n)
           {int tmp = n;
            n = m;
            m = tmp;
           }
        while (m !=0)
        {
            int tmp = n%m;
            n = m;
            m = tmp;
            System.out.println(n);
            System.out.println(m);
        }
        System.out.println("Nod:");
        System.out.println(n);
    }
}