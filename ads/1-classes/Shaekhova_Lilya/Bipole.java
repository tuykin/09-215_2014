
public class Bipole {
    private	double I;
	private double R;
	public Bipole(int I, int R) {
		this.R = R;
	}
	public double Voltage() {
		Bipole A = this;
		double U = I*R;
		return U;
	}
	public double Power() {
		Bipole A = this;
		double U = A.Voltage();
		double W = U * I;
		return W;
	}
	public void ParallelConnection(Bipole B) {
		Bipole A = this;
		double Resistance = (A.R * B.R) / (A.R + B.R);
		System.out.println("Amperage "+(A.I+B.I)+", Resistance "+Resistance);
	}
	public  void SeriesConnection(Bipole B) {
		Bipole A = this;
		double U1 = A.Voltage();
		double U2 = B.Voltage();
		System.out.println("Voltage "+(U1+U2)+", Resistance "+(A.R+B.R));
	}
	public static void main(String[] args) {
		Bipole A = new Bipole(2,6);
        Bipole B = new Bipole(2,3);
		A.SeriesConnection(B);

	}
}

