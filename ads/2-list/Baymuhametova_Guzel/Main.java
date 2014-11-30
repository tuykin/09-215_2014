
public class Main {

    public static void main(String[] args) {

        List l = new List();
        Polimonchick p1 = new Polimonchick(1 , 2.1);
        Polimonchick p2 = new Polimonchick(2 , 4.5);
        Polimonchick p3 = new Polimonchick(3 , 2.3);
        Polimonchick p4 = new Polimonchick(2 , 9.4);

        Polimonchick p5 = new Polimonchick(5 , 0);
        l.Push(p1);
        l.Push(p2);
        l.Push(p3);
        l.Push(p4);
        l.Push(p5);

        l.show();

        l.DeleteNulei();
        l.Podobie();
         System.out.print("=");
        l.show();

    }
}
