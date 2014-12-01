import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.math.*;


public class List {

    private Node first;
    private Node last;



    List()
    {
        this.first=this.last=null;
    }

    public void push(double base,double power)
    {
        if(this.isEmpty())
        {
            Node newNode=new Node(base,power);
            this.first=newNode;
            this.last=newNode;
        }
        else
        {
            Node newNode=new Node(base,power);
            this.last.next=newNode;
            this.last=newNode;
        }
    }

    public boolean isEmpty()
    {
        return this.first==null;
    }



    public void Show(int m)
    {
        if(!this.isEmpty())
        {
            Node n=this.first;
            while(n!=null)
            {
                System.out.print(n.getBase()+"*"+m+"^"+n.getPower()+" ");
                n=n.next;
            }
            System.out.println();
        }
        else
            System.out.print("List is empty!");
    }

    public void Showdigital(int m)
    {
        if(!this.isEmpty())
        {
            Node n=this.first;
            while(n!=null)
            {
                System.out.print(n.getElement(m)+"  ");
                n=n.next;
            }
            System.out.println();
        }
        else
            System.out.print("List is empty!");
    }

    public void bubble(int n)
    {
        int i;
        Node pred;
        Node sled;


        while(n>1)
        {
            pred=null;
            Node start=this.first;
            sled=start.next;
            i=0;
            while(i<n-1)
            {
                if(start.getPower()>sled.getPower())
                {
                    if(pred==null)
                    {
                        start.next=sled.next;
                        sled.next=start;
                        this.first=sled;
                    }
                    else
                    {
                        start.next=sled.next;
                        sled.next=start;
                        pred.next=sled;

                    }
                    pred=sled;
                    sled=start.next;

                }
                else
                {
                    pred=start;
                    start=sled;
                    sled=sled.next;
                }
                i++;
            }
            n--;
        }
    }

    public int input(String FileName) throws FileNotFoundException
    {
        double c;
        double k;
        int i=0;
        Scanner scan=new Scanner(new File(FileName ));
        while(scan.hasNextLine())
        {
            c=scan.nextDouble();
            if(c!=0)
            {
                k=scan.nextDouble();
                this.push(c, k);
                i++;
            }
        }
        scan.close();
        return i;
    }


    public double calc(int m)
   {    Node n=this.first;
       double x=0;
       while(n!=null)
       { x=x+n.getElement(m);
           n=n.next;
       }
       return x;
    }








    public static void main(String[] args)
    {
        List MyList1=new List();
        List MyList2=new List();
        int y=0;
        int x=0;
        try {
            y= MyList1.input("C:\\Users\\Маруся\\Documents\\GitHub\\09-215_2014\\ads\\2-list\\Mamkina_maria\\3.1\\2.txt");
            }

          catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            x=MyList2.input("C:\\Users\\Маруся\\Documents\\GitHub\\09-215_2014\\ads\\2-list\\Mamkina_maria\\3.1\\8.txt");
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("1 spisok:");
        MyList1.Show(2);
        System.out.println(" 2 spisok:");
        MyList2.Show(8);
        System.out.println("1 spisok *:");
        MyList1.Showdigital(2);
        System.out.println("2 spisok *:");
        MyList2.Showdigital(8);
        MyList1.bubble(y);
        MyList2.bubble(x);
        System.out.println("1 spisok posle sortirovki:");
        MyList1.Show(2);
        System.out.println("1 spisok +:");
       System.out.println(MyList1.calc(2));
        System.out.println("2 spisok +:");
        System.out.println(MyList2.calc(8));
        System.out.println("1 spisok +2 spisok:");
        System.out.println(MyList2.calc(8)+MyList1.calc(2));
 

    }

}