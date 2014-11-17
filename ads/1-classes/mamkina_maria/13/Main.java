

public class Main {

    public static void main(String[] args) {
        Sector sec = new Sector();
        boolean side=true;//protiv
        sec.setPoints(0,0,2,0,0,2);
        System.out.print(sec.x1);
        System.out.println(sec.y1);
       if( sec.proverka())
       {System.out.println("ugol:");
        System.out.println(sec.ugol());
        System.out.println("S:");
        System.out.println(sec.S());
        System.out.println("l:");
        System.out.println(sec.l());
        sec.povorot(90,side);
        System.out.println("After turn:");
        System.out.printf("%3f",sec.x1);
        System.out.printf("%3f",sec.y1);
        System.out.printf("%3f",sec.x2);
        System.out.printf("%3f",sec.y2);
        sec.move(1,5);
        System.out.println("After move:");
         System.out.printf("%3f",sec.x1);
         System.out.printf("%3f",sec.y1);
       }
        else
           return;
    }
}