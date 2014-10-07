public class Point {
	// точка на плоскости с декартовыми координатами
	// x - абсцисса точки
	// y - ордината точки
	public double x;
	public double y;

	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(Point a) {
		this.x = a.x;
		this.y = a.y;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public boolean isEqualTo(Point p) {
		return (this.x == p.x && this.y == p.y);
	}
	
}
