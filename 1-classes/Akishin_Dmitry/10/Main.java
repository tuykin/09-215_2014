import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	// вариант 10 - треугольник на плоскости с декартовыми координатами

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Triangle triangle = new Triangle(0, 0, 0, 8, -6, 0);
		analyseTriangle(triangle);
		triangle.rotate(90);
		analyseTriangle(triangle);
		triangle.shift(0, 5);
		analyseTriangle(triangle);
		triangle.shift(-2, -2);
		analyseTriangle(triangle);
	}

	// При выводе на экран все числа округляем до 2 знаков после запятой
	// с помощью класса BigDecimal:
	private static double round(double number) {
		return new BigDecimal(number).setScale(2, RoundingMode.HALF_UP)
				.doubleValue();
	}

	// Вывод информации по треугольнику
	private static void analyseTriangle(Triangle triangle) {
		System.out.println("---==== Анализ треугольника ===---");

		// Вывод координат вершин треугольника
		double[] vertices = triangle.getVerticesCoordinates();
		System.out.print("Вершины: ");
		System.out.print("  A(" + round(vertices[0]) + "; "
				+ round(vertices[1]) + "),");
		System.out.print("  B(" + round(vertices[2]) + "; "
				+ round(vertices[3]) + "),");
		System.out.println("  C(" + round(vertices[4]) + "; "
				+ round(vertices[5]) + ")");

		// Вывод длин сторон
		double[] lengths = triangle.getSideLengths();
		System.out.print("Длины сторон: ");
		System.out.print("  AB = " + round(lengths[0]) + ",");
		System.out.print("  BC = " + round(lengths[1]) + ",");
		System.out.println("  AC = " + round(lengths[2]) + ",");

		// Вывод углов (в градусах)
		double[] angles = triangle.getAngles();
		System.out.print("Углы (в градусах): ");
		System.out.print("  A = " + round(angles[0] * 180 / Math.PI) + ",");
		System.out.print("  B = " + round(angles[1] * 180 / Math.PI) + ",");
		System.out.println("  C = " + round(angles[2] * 180 / Math.PI) + ",");

		// Вывод площади
		System.out.println("Площадь:   S = " + round(triangle.getArea()));

		System.out.println("---============================---");

	}
}
