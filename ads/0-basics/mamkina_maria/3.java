//import java.util.ArrayList;
import java.util.Scanner;
import java.text.NumberFormat ;
public class Table {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        System.out.println("¬ведите строку:");
        String[]str=new String[2];
        String[]a=new String[3];

        for(int i=0;i<2;i++)
            str[i]=scan.nextLine();
        System.out.printf("name:| 1:| 2:| result:| \n");
        for(int i=0;i<2;i++)
        {
            a=str[i].split(" ");
            String name=a[0];
            Integer first=Integer.parseInt(a[1]);
            Integer second=Integer.parseInt(a[2]);
            double result=(double)first/second;
          // result.formatter.setMaximumFraction(3);
            System.out.printf("|%s| %d| %d| %f| \n", name,first,second,result);
        }
   }

}
      