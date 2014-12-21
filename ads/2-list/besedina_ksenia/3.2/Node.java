public class Node {

    public int factor;
    public int power;
    public Node next;

    public Node(int factor,int power)
    {
        this.factor=factor;
        this.power=power;
        this.next=null;
    }

    public int getFactor()
    {
        return factor;
    }
    public int getPower()
    {
        return power;
    }

    public int getElement(int n)
    {
        return (int) (factor*Math.pow(n,power));
    }
}