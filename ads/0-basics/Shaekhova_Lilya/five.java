
public class five {

static int N = 5;
public static double factorial(int N) {
    if (N<0) {System.out.println("Oops!"); return (-1);}
    if(0 == N) return 1;
    return N*factorial(N-1);
}

public static void main(String [] args){
	if (N<0) System.out.println("Error!");
	else {
	double n = Math.log(factorial(N));
	System.out.println("Result ln(N!) is " + n);}
}
}

