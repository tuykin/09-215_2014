/**
 * Created by Bulat on 21.12.14.
 */
public class ComplexNumber {
    private double x;
    private double y;

    private ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static ComplexNumber create(double r, double angle) {
        return new ComplexNumber(r * Math.cos(angle), r * Math.sin(angle));
    }

    public ComplexNumber sum(ComplexNumber complexNumber) {
        return new ComplexNumber(x + complexNumber.x, y + complexNumber.y);
    }

    public ComplexNumber minus(ComplexNumber complexNumber) {
        return new ComplexNumber(x - complexNumber.x, y - complexNumber.y);
    }

    public ComplexNumber multi(ComplexNumber complexNumber) {
        return new ComplexNumber(x * complexNumber.x - y * complexNumber.y, y * complexNumber.x + x * complexNumber.y);
    }

    public ComplexNumber del(ComplexNumber complexNumber) {
        double temp = complexNumber.x * complexNumber.x + complexNumber.y * complexNumber.y;
        double newX = (x * complexNumber.x + y * complexNumber.y) / temp;
        double newY = (y * complexNumber.x - x * complexNumber.y) / temp;
        return new ComplexNumber(newX, newY);
    }

    public String toString() {
        return x + "+(" + y + ")i";
    }


}
