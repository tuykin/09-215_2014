import java.util.Scanner;
import java.util.StringTokenizer;

public class Vector {
    private double a,b;

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public String toString(){
      return ("("+ a + "," + b + ")");
    }

    public double getB() {
        return b;
    }

    public Vector (double a, double b){
        this.a = a;
        this.b = b;
    }
    public Vector (){
        this.a = 0;
        this.b = 0;
    }


    public void sum (){
        System.out.print("Сложение векторов. Необходимо задать второй вектор ");
        Vector vector = new Vector ();
        vector.vectorReader();
        this.a += vector.a;
        this.b += vector.b;
    }


    public void dif (){
        System.out.print("Вычитание векторов. Необходимо задать второй вектор ");
        Vector vector = new Vector ();
        vector.vectorReader();
        this.a -= vector.a;
        this.b -= vector.b;
    }


    public void prodOnNumb(){
        System.out.print("Для умножения вектора на число введите число ");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        StringTokenizer elements=new StringTokenizer(input," \t\n\r,()");
        double number = Double.valueOf(elements.nextToken());
        this.a*=number;
        this.b*=number;
    }

    public double scalProd(){
        System.out.print("Скалярное произведение векторов. Задайте второй вектор ");
        Vector myVector2 = new Vector ();
        myVector2.vectorReader();
        return (this.a*myVector2.a+this.b*myVector2.b);

    }

    public void showMyVector(){
        System.out.println("Ваш вектор: "+ this.toString());
    }

    public void vectorReader(){
        double x = 0;
        double y = 0;
        System.out.print("Задайте вектор парой (а,b) ");
        Scanner scan=new Scanner(System.in);
        String input=scan.nextLine();
        StringTokenizer elements=new StringTokenizer(input," \t\n\r,()");
        while (elements.hasMoreTokens())
        {
            x = Double.valueOf(elements.nextToken());
            y = Double.valueOf(elements.nextToken());
        }
        this.a = x;
        this.b = y;
    }


}
