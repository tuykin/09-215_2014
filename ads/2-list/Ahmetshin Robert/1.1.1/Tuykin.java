/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tuykin;

import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author 1
 */
class Node {
  //содержимое текущего элемента списка
  public int degree;
  public double koef;
  //указатель на следующий элемент списка
  public Node next;

}
class polyList
{
    public Node head;
    boolean bolvanchik = false;
    public polyList()
    {
        head = new Node();
        head.next = null;
    }
    
    public void push(int d, double k)
    {
        if(head.next == null && !bolvanchik)
        {
            head.degree = d;
            head.koef = k;
            bolvanchik = true;
        }
        else{
            Node tmp = new Node();
            tmp.degree = d;
            tmp.koef = k;
            tmp.next = head;
            head = tmp;
        }
    }
    
    public void output()
    {
        Node node_ = head;
	while(node_ != null)
	{
		System.out.println(node_.degree+" - "+node_.koef);
		node_ = node_.next;
	}
        System.out.println();
    }
    
    public void multiply(double c, double d)//умножение на c+dx
    {
        Node p = head,q = head.next;
        push(head.degree+1,head.koef*d);
        while(q != null)
        {
            if(p.degree == q.degree + 1)
            {
                p.koef = p.koef*c + q.koef*d;
                p = p.next;
                q = q.next;
                continue;
            }
            if(p.degree > q.degree+1)
            {
                p.koef *= c;
                Node tmp = new Node();
                p.next = tmp;
                tmp.next = q;
                tmp.koef = q.koef*d;
                tmp.degree = q.degree+1;
                p = q;
                q = q.next;
                continue;
            }
        }
        p.koef*=c;
    }
}

public class Tuykin {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
            
            File f = new File("koef.txt");
            Scanner sc = new Scanner(f);
            String s = sc.nextLine();
            StringTokenizer st = new StringTokenizer(s," ,;");
            int degree = 0;
            polyList poly = new polyList();
            
            while(st.hasMoreTokens())
            {
                s = st.nextToken();
                if(!s.equals("0"))
                {
                    poly.push(degree,Double.parseDouble(s));
                }
                degree++;
            }
            poly.output();
            poly.multiply(2, 3);
            poly.output();
            
            
            
        }
        catch(Exception exc){}
        
    }
    
}
