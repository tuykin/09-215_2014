package long_number;

public class ProgramLongNumber {
	 public static void main(String[] args) 
	    {         
	        System.out.println("First number");//вводится первое число
	        int a1=LongNumber.EnterNumberA();
	        int b1=LongNumber.EnterNumberB();
	                      
	        System.out.println("Second number");//вводится второе число
	        int a2=LongNumber.EnterNumberA();
	        int b2=LongNumber.EnterNumberB();
	       
	        int n1 = LongNumber.CreateNumber(a1, b1);
	        int n2 = LongNumber.CreateNumber(a2, b2);
	        System.out.println("a1*2^15+b1="+n1);       //печатает число
	        System.out.println("a2*2^15+b2="+n2);       //печатает число
	                
	        int k1=LongNumber.AmountNumber(n1);//длина первого число
	        int k2=LongNumber.AmountNumber(n2);//длина второго числа
	        int k=LongNumber.LengthCommon(k1,k2);// общая длина( для суммы)
	        int k0=LongNumber.LengthMult(k1,k2);// общая длина( для произведения)
	                
	        int q1[]=LongNumber.CreateVector(n1,k);//создает вектор(массив)
	        int q2[]=LongNumber.CreateVector(n2,k);
	       
	        LongNumber.PrintAdd(q1,q2,k,n1,n2);
	        LongNumber.PrintSub(q1,q2,k0,k,n1,n2,k1,k2);
	        LongNumber.PrintMult(q1,q2,k0,k,n1,n2); 
	        LongNumber.PrintCompair(q1,q2,k,n1,n2,k1,k2);
	    } 
}
