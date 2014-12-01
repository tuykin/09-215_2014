import java.math.*;



public class Node {

    public double base;
    public double power;
    public Node next;



    public Node(double base,double power)
    {
        this.base=base;
        this.power=power;
        this.next=null;
    }


    public double getBase()
    {
        return base;
    }
    public double getPower()
    {
        return power;
    }


    public double getElement(int n)
    {
        return base*Math.pow(n,power);
    }






    public void setElement(double e,double a){
        base = e;
        power=a;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        next = n;
    }


}