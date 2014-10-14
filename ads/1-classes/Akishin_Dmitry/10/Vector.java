public class Vector {
	// Вектор на плоскости, заданный двумя точками
	private Point mInitialPoint;
	private Point mTerminalPoint;

	public Vector(Point a, Point b) {
		this.mInitialPoint = new Point(a);
		this.mTerminalPoint = new Point(b);
	}

	// Компоненты вектора
	public double getComponentX() {
		return (this.mTerminalPoint.x - this.mInitialPoint.x);
	}

	public double getComponentY() {
		return (this.mTerminalPoint.y - this.mInitialPoint.y);
	}

	// Скалярное произведение на вектор
	public double scalarProduct(Vector v) {
		return (this.getComponentX() * v.getComponentX() + this.getComponentY()
				* v.getComponentY());
	}

	// Длина вектора
	public double length() {
		return Math.sqrt(Math.pow(this.getComponentX(), 2)
				+ Math.pow(this.getComponentY(), 2));
	}

	// Угол между векторами this и v (векторы исходят из одной точки)
	public double angleWith(Vector v) {
		return Math.acos(this.scalarProduct(v) / (this.length() * v.length()));
	}

	// Коллинеарность с вектором v
	public boolean isCollinearWith(Vector v) {
		return (this.getComponentX() * v.getComponentY() - this.getComponentY()
				* v.getComponentX() == 0);
	}

}
