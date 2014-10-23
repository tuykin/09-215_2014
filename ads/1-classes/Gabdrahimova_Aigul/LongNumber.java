package long_number;

import java.util.Scanner;

public class LongNumber 
{
	private static final int two = (int) Math.pow(2, 15);
	public static int  CreateNumber (int a,int b)// a*2^15+b
    {
      	return (a*(two)+b);
    }
	public static int [] CreateVector(int s,int k)//число в числовой массив
	    {
	        int q[]=new int[k];
	        int i=0;
	        for (i=0; i<k; i++)
	        	if (s>0) 
	            {
	            q[i]=s%10;
	            s = s / 10;
	            }
	        	else
	        		q[i]=0;
	       return q;
	    }
	public static int AmountVector(int s) 
	{
		int q[]=new int[100];
        int i=0;
        while(s>0) 
        {
            q[i]=s%10;
            i++;
            s = s / 10;
        }
        return i;
    }
    public static void PrintNumberB () 
    {
    	System.out.println("b=");
    }
    public static void PrintNumberA () 
    {
    	System.out.println("a=");
    }
    public static int EnterNumberB () 
    {
    	@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);

         String s;
         int b;      
         PrintNumberB();
         s=sc.nextLine();
         b=Integer.parseInt(s);
         while ((b>two) || (b<0))
     		{
         	System.out.println("Not correct");
         	PrintNumberB();
         	s=sc.nextLine();
         	b=Integer.parseInt(s);
     		}
         return b;
    }
    public static int EnterNumberA () 
    {
    	@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);

         String s;
         int a;      
         PrintNumberA();
         s=sc.nextLine();
      	 a=Integer.parseInt(s);
         while ((a>two) || (a<0))
         	{
         	System.out.println("Not correct");
         	PrintNumberA();
         	s=sc.nextLine();
         	a=Integer.parseInt(s);
         	}
         return a;
    }
    public static int Length (int p1, int p2)
    {
    if (p1==p2)
    	return (p1+1);
    else 
    	if (p1<p2)
    	return p2;
    	else 
    		return p1;
    }
    public static int [] CompaireLongNumber(int p1,int p2,int s1[], int s2[]){
    	if (p1<p2)
        	return s2;
        	else 
        		if (p1>p2)
        			return s1;
        		else
        			if (p1==p2)
        			{
        				int i=p1;
        				while ((i>0)&&(s1[i]==s2[i]))
        				{
        					i--;
        				}
        				if (s1[i]>s2[i])
            			return s1;
        				else 
            			return s2;	
        			}
	return s2;
    }
    public static int [] Add (int s1[], int s2[], int p) //число в числовой массив
    {
        int q[]=new int[p];
        int i=0, c=0;
        for (i=0; i<p;i++)
          {
            c = c+s1[i]+s2[i];
            q[i] = c%10;
            c = c/10;
          }
        if(c>0)
        {
            i=i+1;
            q[i] = c;
          }
          
       return q;
    }
    public static int [] Sub (int s1[], int s2[],  int p) //число в числовой массив
    {
       int q[]=new int[p];
       int i,c=0;
       for (i=0; i<p;i++)
       	{
            c = c+s1[i]-s2[i]+10;
            q[i] = c%10;
            if(c < 10) c=-1; else c=0;
          }
       return q;
    }
    public static int [] Mult (int s1[],int s2[], int p,int p1,int p2)
    {
    	int q[]=new int[p];
    	for(int i=0;i<p;i++)
    		q[i]=0;
    	int k=0;
    	for(int i=0;i<p1;i++)
    	  { 
    		for (int j=0; j<p2;j++)
    		{
    			int n = s1[i]*s2[j];
    		      if (i==0 && j>-1)
    		    	  k = j;
    		      	  else
    		      		  if (i>-1 && j==0)
    		      			  k=i;
    		      		  else
    		    		  k=i+j-1;
    		      while  (n>0)
    		      {
    		        n = n+q[k];
    		        q[k] = n%10;
    		        n = n/10;
    		        k = k+1;
    		      }
    		    }
    	  }
    return q;
    }
    public static void main(String[] args) 
    {
        int a1,a2,b1,b2,i;
        
        System.out.println("First number");//вводится первое число
        a1=LongNumber.EnterNumberA();
        b1=LongNumber.EnterNumberB();
        
        System.out.println();
        
        System.out.println("Second number");//вводится второе число
        a2=LongNumber.EnterNumberA();
        b2=LongNumber.EnterNumberB();
       
        int n1 = LongNumber.CreateNumber(a1, b1);
        int n2 = LongNumber.CreateNumber(a2, b2);
        
        System.out.println("a1*2^15+b1="+n1);       //печатает число
        System.out.println("a2*2^15+b2="+n2);       //печатает число
        
        System.out.println();
        
        int k1=LongNumber.AmountVector(n1);
        int k2=LongNumber.AmountVector(n2);
        int k=LongNumber.Length(k1,k2);
        int k0=k1+k2+1;
        
        System.out.println(k1);//длина первого число
        System.out.println(k2);//длина второго числа
        System.out.println(k);// общая длина( для суммы)
        System.out.println(k0);// общая длина( для произведения)
        
        System.out.println();  
        
        int q1[]=LongNumber.CreateVector(n1,k);//создает вектор(массив)
        int q2[]=LongNumber.CreateVector(n2,k);
        //печатает вектор(массив)
        for ( i = k-1; i > -1; i--) 
      	   System.out.print(q1[i]);
        
       System.out.println();  
       //печатает вектор  (масссив)
       for (i = k-1; i > -1; i--)
       	   System.out.print(q2[i]);
       	
       System.out.println();
       //складывает и выводит сумму   
       k=LongNumber.Length(k1,k2);
       int[] AddLongNumber = LongNumber.Add (q1, q2, k);
       while((AddLongNumber[k-1] == 0) && (k > 1)) 
    	   k--;
       System.out.print("AddLongNumber = " + n1 + " + " + n2 + " = ");
       for (i = k-1; i > -1; i--) 
     	   System.out.print(AddLongNumber[i]);
       
       System.out.println();
       //сравнивает число  и выводит большое ( если равны то одно из них ) 
       k=LongNumber.Length(k1,k2);
       int[] Compair= LongNumber.CompaireLongNumber(k1,k2,q1,q2);
       System.out.print("Compair ( " + n1 + " , "+n2 + " ) = ");
       while((Compair[k-1] == 0) && (k > 1)) 
    	   k--;
       for (i = k-1; i > -1; i--) 
     	   System.out.print(Compair[i]);

       System.out.println();
       //разность считает и выводит ( из большого вычитается меньшее) 
       k=LongNumber.Length(k1,k2);
       i=k-1;
       while ((q1[i]==Compair[i])&&(i>0))
       {
   		i--;
   		}
       if (i==0)
   	   		{ int[] SubLongNumber= LongNumber.Sub(q1, q2,k);
   	   		while((SubLongNumber[k-1] == 0) && (k > 1)) 
   	   			k--;
   	   		System.out.print("SubLongNumber = " + n1 + " - " + n2 + " = ");
   	   		for (i = k-1; i > -1; i--) 
   	   			System.out.print(SubLongNumber[i]);}
       else
       		{ int[] SubLongNumber= LongNumber.Sub(q2, q1, k);
       		while((SubLongNumber[k-1] == 0) && (k > 1)) 
   	   			k--;
       		System.out.print("SubLongNumber = " + n1 + " - " + n2 + " = - ");
       		for (i = k-1; i > -1; i--) 
       			System.out.print(SubLongNumber[i]);} 
       
       System.out.println();
       //произведение считает и выводит
        int[] MultLongNumber = LongNumber.Mult(q1, q2, k0, k1, k2);
        while((MultLongNumber[k0-1] == 0) && (k > 1)) 
	   			k0--;
        System.out.print("MultLongNumber = " + n1 + " * " + n2 + " = ");
   		for (i = k0-1; i > -1; i--) 
   			System.out.print(MultLongNumber[i]);       
    } 
}

