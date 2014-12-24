import static java.lang.Character.isDigit;


public class Zadacha4_2 {
    public static void main(String[] args) {
        Polinom a= new Polinom();
        Polinom b= new Polinom();
        In in = new In("input.txt");
        a.generateFromString(in.readLine());
        b.generateFromString(in.readLine());
        StdOut.print("Многочлен a: ");
        a.show();
        StdOut.print("Многочлен b: ");
        b.show();
        a.summ(b);
        StdOut.print("Многочлен a+b: ");
        a.show();
    }
}
class Element{
    public Integer a;
    public Integer b;
    public int i;
    public Element next;
    Element(Integer a,Integer b,int i)
    {
        this.a=a;
        this.b=b;
        this.i=i;
        next=null;
    }
}
class Polinom {
    private Element head;
    Polinom(){
        head=null;
    }
    public void show(){
        Element element=head;
        showRecurtion(element);
        System.out.println();
    }
    private void showRecurtion(Element element){
        if(element!=null)
        {
            if(element.a!=0) StdOut.print(element.a);
            if(element.b!=0)
            {
                if(element.b>0) StdOut.print("+");
                StdOut.print(element.b+"*cos("+element.i+"*x"+")");
            }
            if(element.next!=null)
                if(element.next.a>0) StdOut.print("+");
            showRecurtion(element.next);
        }
    }
    public void add(Element newOne){
        if(head!=null)
        {
            lastElement(head).next= newOne;
        }
        else
        {
            head=newOne;
        }
    }
    private Element lastElement(Element element){
        if(element.next!=null)
        {
            return lastElement(element.next);
        }
        else
            return element;
    }
    public void generateFromString(String s){
        int i=0;
        String number="";
        boolean a=true;
        while(a&&i<s.length()){
            if(isDigit(s.charAt(i))||s.charAt(i)=='-'){
                number=number+s.charAt(i);
                i++;
            } else a=false;
        }
        if(!number.equals("0")) this.add(new Element(new Integer(number),0,0));
        if(i!=s.length()) generateFromString(s,1,++i);
    }
    private void generateFromString(String s,int index,int i){
        String numberA="";
        boolean a=true;
        while(a&&i<s.length()){
            if(isDigit(s.charAt(i))||s.charAt(i)=='-'){
                numberA=numberA+s.charAt(i);
                i++;
            } else a=false;
        }
        a=true;
        i++;
        String numberB="";
        while(a&&i<s.length()){
            if(isDigit(s.charAt(i))||s.charAt(i)=='-'){
                numberB=numberB+s.charAt(i);
                i++;
            } else a=false;
        }
        if(!numberA.equals("0")||!numberB.equals("0"))this.add(new Element(new Integer(numberA),new Integer(numberB),index));
        if(i!=s.length()) generateFromString(s,++index,++i);
    }
    public Element getElementByIndex(int i){
        Element element=head;
        while(element!=null)
        {
            if(element.i==i) return element;
            element=element.next;
        }
        return element;
    }
    public void summ(Polinom b){
        Element element=head;
        Element previous=head;
        while(element!=null)
        {
            Element elementB=b.getElementByIndex(element.i);
            if(elementB!=null){
                element.a=element.a+elementB.a;
                element.b=element.b+elementB.b;
            }
            if((element.a==0)&&(element.b==0)) previous.next=element.next;
            element=element.next;
            previous=previous.next;
        }
    }
}
