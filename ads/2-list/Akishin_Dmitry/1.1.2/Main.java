import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoefficientList polynomial = new CoefficientList();
		try {
			polynomial.load("C:\\Users\\sony\\Desktop\\input.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		polynomial.print();

		double c = 5, d = 2;
		System.out.print("\nЧастное от деления на (" + c + " + " + d
				+ " * x) :\n");
		polynomial.divideBy(c, d).print();

	}
}
