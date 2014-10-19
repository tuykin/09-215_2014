//x>0, e<x
import java.util.Scanner;
////////////////////////////////////////////////////////////////////////
public class Arifmetica {
	 public  int x,e;
	 public Arifmetica(int a, int b )
	 {
		 x=a;
	     e=b;
	 }
	 public Arifmetica(int[] a )// двумерный вектор [начало, конец]
	 {
		 x= (a[1]-a[0])/2; 
		 e=a[1]-x;
	 }
	 
    public Arifmetica() { }
//////////////////////////////////////////////////////////////////////	
	public static int [] createVector(int x,int e)
	{
		int []u=new int[2];
		u[0] = x - e;
		u[1] = x + e;
		return u;
	}
	
///////////////////////////////////////////////////////////////////// //  Arifmetica.Add()
	public static  int[] Add(int[] u, int[] v)  
	{
		int[] AddVector = new int[2];
		for (int i = 0; i < AddVector.length; i++)
		AddVector[i] = u[i] + v[i];
		return AddVector;
	}
/////////////////////////////////////////////////////////////////////
	public  static int[] Sub(int[] u, int[] v)
	{
		int [] SubVector = new int[2];
		for (int i = 0; i < SubVector.length; i++)
		SubVector[i] = u[i] - v[i];
		return SubVector;
	}
///////////////////////////////////////////////////////////////////
    public  static int[] Mult(int[] u, int[] v)
    {
        int[] MultVector = new int[2];
        for (int i = 0; i < MultVector.length; i++)
        MultVector[i] = u[i] * v[i];
        return MultVector;
    }
//////////////////////////////////////////////////////////////////
   public  static double[] Del(int[] u, int[] v)
   {
        double [] DelVector = new double[2];
        double a, b;
        for (int i = 0; i < DelVector.length; i++)
           {
        	
        	a = (double)v[i]; 
            b = (double)u[i];
            DelVector[i]=a / b;
           }
        return DelVector;
   }
/////////////////////////////////////////////////////////////////
   public static boolean Ravno(Arifmetica u, Arifmetica v) // if( Arifmetica.Ravno(u,v))
   {
       
           if (u.x==v.x && u.e==v.e)
            	return true ;
            else return  false;
             
    }
////////////////////////////////////////////////////////////////////
   
/////////////////////////////////////////////////////////////////////
	public static void main(String[] args) 
	{
		System.out.print("y=");
			
		
		String s ;
		Scanner sc= new Scanner(System.in);
		s=sc.nextLine();
		int y = Integer.parseInt(s);

		System.out.print("a=");
		 s=sc.nextLine();
         int a = Integer.parseInt(s);
         
         System.out.println("z=");
         s=sc.nextLine();         
         int z = Integer.parseInt(s);
         
        
         
         System.out.println("b=");
         s=sc.nextLine();
         int b = Integer.parseInt(s);
        
                 
	     int[] U = Arifmetica.createVector(y, a);
		 int[] V = Arifmetica.createVector(z, b);
		
		System.out.println("U = (" + U[0] + "; " + U[1]+ ")");
		System.out.println("V = (" + V[0] + "; " + V[1] + ")");
		
		int[] AddVector = Arifmetica.Add(U, V);
		System.out.println("AddVector = (" + AddVector[0] + "; " + AddVector[1] + ")");
		
		int[] SubVector = Arifmetica.Sub(U, V);
		System.out.println("SubVector = (" + SubVector[0] + "; " + SubVector[1] + ")");

		int[] MultVector = Arifmetica.Mult(U, V);
		System.out.println("MultVector = (" + MultVector[0] + "; " + MultVector[1] + ")");

		double[] DelVector = Arifmetica.Del(U, V);
		System.out.println("DelVector = (" + DelVector[0] + "; " + DelVector[1] + ")");

		boolean bo = Arifmetica.Ravno(new Arifmetica(U),new Arifmetica(V) );
		if (bo == true) System.out.println("=");
		else System.out.println("!=");
		System.out.println();
		}
	
	}


