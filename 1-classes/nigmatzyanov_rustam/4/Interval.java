package classes;

public class Interval {
	private double a,b;
	
	public Interval() {}
	
	public Interval(double A, double B) {
		if (A > B){
			throw new java.lang.IllegalArgumentException("Создание неправильного интервала "+
		"(начало интервала не должно быть больше конца)");
		}
		a=A; b=B;
	}
	
	public static Interval add(Interval A, Interval B){
		return new Interval(A.a+B.a, A.b+B.b);
	}
	
	public static Interval sub(Interval A, Interval B){
		return new Interval(A.a-B.a, A.b-B.b);
	}
	
	public static Interval mult(Interval A, Interval B){
		return new Interval(min(A.a*B.a, A.a*B.b, A.b*B.a, A.b*B.b), max(A.a*B.a, A.a*B.b, A.b*B.a, A.b*B.b));
	}
	
	public static Interval div(Interval A, Interval B){
		if (B.a==0 || B.b==0)
			throw new java.lang.IllegalArgumentException("Интервал-делитель не должен содержать 0");
		
		B.a=1/B.a;
		B.b=1/B.b;
		return mult(A,B);
	}
	
	public static double min(double x, double y, double z, double t){
		double min=x;
		if(y<min) min=y;
		if(z<min) min=z;
		if(t<min) min=t;
		return min;
	}
	
	public static double max(double x, double y, double z, double t){
		double max=x;
		if(y>max) max=y;
		if(z>max) max=z;
		if(t>max) max=t;
		return max;
	}
	
	public double scope(){
		return b-a;
	}
	
	public String toString(){
		return "["+a+","+b+"]";
	}

	public static void main(String[] args) {
		Interval x=new Interval(-2.2,9);
		Interval y=new Interval(-2.5,7.3);
		System.out.println(x);
		System.out.println(y);
		
		System.out.println("Размах x: " + x.scope());
		System.out.println("Размах y: " + y.scope());
		System.out.println("Сложение: " + add(x,y));
		System.out.println("Вычитание: " + sub(x,y));
		System.out.println("Умножение: " + mult(x,y));
		System.out.println("Деление: " + div(x,y));
	}
}
