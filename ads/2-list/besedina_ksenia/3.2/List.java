import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class List {

    private Node first;
    private Node last;

    List()
    {
        this.first=this.last=null;
    }

    public void push(int factor,int power)
    {
        if(factor!=0) {
            if (this.isEmpty()) {
                Node newNode = new Node(factor, power);
                this.first = newNode;
                this.last = newNode;
            } else {
                Node newNode = new Node(factor, power);
                this.last.next = newNode;
                this.last = newNode;
            }
        }
    }

    public boolean isEmpty()
    {
        return this.first==null;
    }

    public void Show2(int m)
    {
        if(!this.isEmpty())
        {
            Node n=this.first;
            System.out.print(n.getFactor()+"*"+m+"^"+n.getPower());
            n=n.next;
            while(n!=null)
            {
                System.out.print(" + " + n.getFactor()+"*"+m+"^"+n.getPower());
                n=n.next;
            }
            System.out.println();
        }
        else
            System.out.print("List is empty!");
    }

    public void Show1()
    {
        if(!this.isEmpty())
        {
            Node n=this.first;
            while(n!=null)
            {
                System.out.print(n.getFactor());
                n=n.next;

            }
            System.out.println();
        }
        else
            System.out.print("List is empty!");
    }

    public void Show3(int m)
    {
        if(!this.isEmpty())
        {
            Node n=this.first;
            System.out.print(n.getElement(m));
            n=n.next;
            while(n!=null)
            {
                System.out.print(" + " + n.getElement(m));
                n=n.next;
            }
            System.out.println();
        }
        else
            System.out.print("List is empty!");
    }

    public void sum( List L1, List L2)
    {
        Node n1=L1.first;
        Node n2=L2.first;
        while((n1!=null)||(n2 != null)) {
            if ((n1 != null) && (n2 != null)) {
                if (n1.getPower() == n2.getPower()) {
                    if (n1.getFactor() == 1 && n2.getFactor() == 1) {
                        this.push(0, n1.getPower());
                        n1 = n1.next;
                        n2 = n2.next;
                    }
                } else {
                    if (n1.getPower() > n2.getPower()) {
                        this.push(1, n1.getPower());
                        n1 = n1.next;
                    } else {
                        this.push(1, n2.getPower());
                        n2 = n2.next;
                    }
                }
            }
            else{
                if(n1==null){
                    this.push(1, n2.getPower());
                    n2 = n2.next;
                }
                else{
                    this.push(1, n1.getPower());
                    n1 = n1.next;
                }
            }
        }
    }

    public void Interprite(int p,int q){
        int j;
        int a[] = new int[100];
        for(j=0; p>0; j++) {
            a[j] = p % q;
            p /= q;
        }
        for(j--; j>=0; j--) {
            System.out.print(a[j]);
            this.push(a[j], j);
        }
        System.out.println();
    }

    public static void main(String[] args) throws FileNotFoundException {
        List L1=new List();
        List L2=new List();
        List L3=new List();
        int p1 = 0;
        int p2 = 0;
        Scanner scan=new Scanner(new File("src/digital1.txt"));
        while(scan.hasNextLine()){
            p1=scan.nextInt();
        }
        scan=new Scanner(new File("src/digital2.txt"));
        while(scan.hasNextLine()){
            p2=scan.nextInt();
        }
        scan.close();
        int q=2;
        System.out.println("\nq-иричное представление. q=" + q);
        System.out.println("\nЧисло "  + p1 + " переведенное в указанную систему:");
        L1.Interprite(p1,q);
        System.out.println("Число "  + p1 + " переведенное в указанную систему (список без нулевых коэффициентов):");
        L1.Show1();
        System.out.println("Предсавление:");
        L1.Show2(q);
        L1.Show3(q);
        System.out.println("\nЧисло "  + p2 + " переведенное в указанную систему:");
        L2.Interprite(p2,q);
        System.out.println("Число "  + p2 + " переведенное в указанную систему (список без нулевых коэффициентов):");
        L2.Show1();
        System.out.println("Предсавление:");
        L2.Show2(q);
        L2.Show3(q);
        System.out.println("\nПодразрядное сложение по модулю 2 двух чисел (из списков без нулевых коэффициентов):");
        L3.sum(L1, L2);
        System.out.println("Предсавление:");
        L3.Show2(q);
        L3.Show3(q);

    }
}