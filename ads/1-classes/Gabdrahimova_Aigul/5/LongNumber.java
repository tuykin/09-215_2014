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
	public static int AmountNumber(int s) //количество элементов в числе
	{
        int i=0;
        while(s>0) 
        {
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
    public static int LengthCommon (int p1, int p2)
    {
    if (p1==p2)
    	return (p1+1);
    else 
    	if (p1<p2)
    	return p2;
    	else 
    		return p1;
    }
    public static int LengthMult (int p1, int p2)
    {
    	if (p1>p2)
        	return (p1*2);
        	else return (p2*2);
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
    public static int [] Mult (int s1[],int s2[], int p,int p1) //перемножает числа
    {
    	int q[]=new int[p];
    	for(int i=0;i<p;i++)
    		q[i]=0;
    	int k=0;
    	for(int i=0;i<p1;i++)
    	  { 
    		for (int j=0; j<p1;j++)
    		{
    			int n = s1[i]*s2[j];
    			if (i==0 && j==0)
    				k=i;
    			if (i>0 && j==0)
    				k=i;
    			if (i==0 && j>0)
    				k=j;
    			else k=i+j;
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
    public static void PrintVector (int q[], int k) //печатает вектор  (масссив)
    {
    	for (int i = k-1; i > -1; i--)
    	   System.out.print(q[i]);
    	System.out.println();
    }
    public static int DeleteZero (int q[], int k)//удаляет ведущие ноли
    {
    	while((q[k-1] == 0) && (k > 1)) 
			k--;
    	return k;
    }
    public static void PrintMult ( int s1[],int s2[],int p0, int p, int q1, int q2)//произведение считает и выводит
    {
    	int[] MultLongNumber = LongNumber.Mult(s1, s2, p0, p); 
        int m=LongNumber.DeleteZero(MultLongNumber,p0); 
        System.out.print("MultLongNumber = " + q1 + " * " + q2 + " = ");
        PrintVector(MultLongNumber,m);      
    }
    public static void PrintSub ( int s1[],int s2[],int p0, int p, int q1, int q2,int p1, int p2)//разность считает и выводит ( из большого вычитается меньшее) 
    {
    	int[] Compair= LongNumber.CompaireLongNumber(p1,p2,s1,s2);
    	int i=p-1;//( из большого вычитается меньшее) 
        while ((s1[i]==Compair[i])&&(i>0))
        {
    		i--;
    		}
        if (i==0)
    	   		{ 
     	   		int[] SubLongNumber= LongNumber.Sub(s1, s2,p); 
     	   		int m=LongNumber.DeleteZero(SubLongNumber,p);
    	   		System.out.print("SubLongNumber = " + q1 + " - " + q2 + " = ");
    	   		PrintVector(SubLongNumber,m);
    	   		}
        else
        		{ 
     	   		int[] SubLongNumber= LongNumber.Sub(s2, s1, p);
     	   		int m=LongNumber.DeleteZero(SubLongNumber,p);
        		System.out.print("SubLongNumber = " + q1 + " - " + q2 + " = - ");
        		PrintVector(SubLongNumber,m);
        		} 
    }
    public static void PrintCompair ( int s1[],int s2[], int p, int q1, int q2,int p1, int p2)//сравнивает число  и выводит большое ( если равны то одно из них ) 
    {
    	 int[] Compair= LongNumber.CompaireLongNumber(p1,p2,s1,s2);
         System.out.print("Compair ( " + q1 + " , "+q2 + " ) = ");
         int m=LongNumber.DeleteZero(Compair,p);
         PrintVector(Compair,m);
    }
    public static void PrintAdd( int s1[],int s2[], int p, int q1, int q2)//складывает и выводит сумму  
    {
    	int[] AddLongNumber = LongNumber.Add (s1, s2, p); 
        int m=LongNumber.DeleteZero(AddLongNumber,p); 
        System.out.print("AddLongNumber = " + q1 + " + " + q2 + " = ");
        PrintVector(AddLongNumber,m);
    }
   
}

