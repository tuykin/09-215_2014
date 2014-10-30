import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        System.out.print("Enter the degree of permutation: ");
        int m=in.nextInt();

        int[] p_mas=new int[m];
        int[] q_mas=new int[m];

        System.out.print("\nEnter the permutation p:\n");
        for(int i=0;i<m;i++)
            p_mas[i]=in.nextInt();

        System.out.print("\nEnter the permutation q:\n");
        for(int i=0;i<m;i++)
            q_mas[i]=in.nextInt();

        Perms p=new Perms(p_mas);
        Perms q=new Perms(q_mas);
        Perms qp=new Perms(q_mas);
        Perms pq=new Perms(p_mas);


        //Умножение перестановок

        qp.multPerms(p); //(q*p)

        pq.multPerms(q); //(p*q)

        qp.reversePerms(); //Обратная перестановка (q*p)

        pq.reverse();//Перестановка в обратном порядке (p*q)

        if(pq.isEqual(qp))//Проверка на равенство
            System.out.println("\nYes equal");
           else System.out.println("\nNo equal");

    }

}
