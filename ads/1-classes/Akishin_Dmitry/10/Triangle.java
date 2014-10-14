public class Triangle {

	private Point mA;
	private Point mB;
	private Point mC;

	// Конструктор с параметрами - точками
	public Triangle(Point a, Point b, Point c) {
		// Проверяем, не совпадают ли точки
		if (a.isEqualTo(b) || b.isEqualTo(c) || c.isEqualTo(a)) {
			System.err.println("Ошибка построения треугольника c вершинами ("
					+ a.x + "; " + a.y + "),(" + b.x + "; " + b.y + "),(" + c.x
					+ "; " + c.y + "):" + "\n" + "   совпадающие точки");
			System.exit(1);
		}
		// Проверяем, лежат ли точки на одной прямой
		// Для этого проверим на коллинеарность векторы AB, AC
		else if (new Vector(a, b).isCollinearWith(new Vector(a, c))) {
			System.err.println("Ошибка построения треугольника c вершинами ("
					+ a.x + "; " + a.y + "),(" + b.x + "; " + b.y + "),(" + c.x
					+ "; " + c.y + "):" + "\n"
					+ "   точки лежат на одной прямой");
			System.exit(1);
		}

		this.mA = new Point(a);
		this.mB = new Point(b);
		this.mC = new Point(c);
	}

	// Конструктор с параметрами - координатами точек
	public Triangle(double ax, double ay, double bx, double by, double cx,
			double cy) {
		Point a = new Point(ax, ay);
		Point b = new Point(bx, by);
		Point c = new Point(cx, cy);
		// Проверяем, не совпадают ли точки
		if (a.isEqualTo(b) || b.isEqualTo(c) || c.isEqualTo(a)) {
			System.err.println("Ошибка построения треугольника c вершинами ("
					+ ax + "; " + ay + "),(" + bx + "; " + by + "),(" + cx
					+ "; " + cy + "):" + "\n" + "   совпадающие точки");
			System.exit(1);
		}
		// Проверяем, лежат ли точки на одной прямой
		// Для этого проверим на коллинеарность векторы AB, AC
		else if (new Vector(a, b).isCollinearWith(new Vector(a, c))) {
			System.err.println("Ошибка построения треугольника c вершинами ("
					+ ax + "; " + ay + "),(" + bx + "; " + by + "),(" + cx
					+ "; " + cy + "):" + "\n"
					+ "   точки лежат на одной прямой");
			System.exit(1);
		}
		this.mA = new Point(a);
		this.mB = new Point(b);
		this.mC = new Point(c);
	}

	// Длины сторон
	// Порядок: AB, BC, AC
	public double[] getSideLengths() {
		double[] lengthArray = new double[3];
		lengthArray[0] = new Vector(mA, mB).length();
		lengthArray[1] = new Vector(mB, mC).length();
		lengthArray[2] = new Vector(mC, mA).length();
		return lengthArray;
	}

	// Углы (в радианах)
	// Порядок: A, B, C
	public double[] getAngles() {
		double[] angleArray = new double[3];
		angleArray[0] = new Vector(mA, mB).angleWith(new Vector(mA, mC));
		angleArray[1] = new Vector(mB, mA).angleWith(new Vector(mB, mC));
		angleArray[2] = new Vector(mC, mB).angleWith(new Vector(mC, mA));
		return angleArray;
	}

	// Площадь
	public double getArea() {
		// S = 1/2 * AB*AC*sin(A)
		double[] lengths = this.getSideLengths();
		return 0.5 * lengths[0] * lengths[2] * Math.sin(this.getAngles()[0]);
	}

	// Сдвиг треугольника на заданное расстояние
	// Параметры - величины сдвига по осям ассцисс и ординат
	public void shift(double distanceRight, double distanceUp) {
		this.mA.x += distanceRight;
		this.mB.x += distanceRight;
		this.mC.x += distanceRight;
		this.mA.y += distanceUp;
		this.mB.y += distanceUp;
		this.mC.y += distanceUp;
	}

	// Поворот вокруг нуля на угол, заданный в градусах
	// (против часовой стрелки)
	public void rotate(double angle) {
		double t = angle * Math.PI / 180;
		double cosT = Math.cos(t);
		double sinT = Math.sin(t);

		double mAx = this.mA.x;
		this.mA.x = mAx * cosT - this.mA.y * sinT;
		this.mA.y = mAx * sinT + this.mA.y * cosT;
		double mBx = this.mB.x;
		this.mB.x = mBx * cosT - this.mB.y * sinT;
		this.mB.y = mBx * sinT + this.mB.y * cosT;
		double mCx = this.mC.x;
		this.mC.x = mCx * cosT - this.mC.y * sinT;
		this.mC.y = mCx * sinT + this.mC.y * cosT;
	}

	// Координаты вершин треугольника
	public double[] getVerticesCoordinates() {
		double[] verticeArray = new double[6];
		verticeArray[0] = this.mA.x;
		verticeArray[1] = this.mA.y;
		verticeArray[2] = this.mB.x;
		verticeArray[3] = this.mB.y;
		verticeArray[4] = this.mC.x;
		verticeArray[5] = this.mC.y;
		return verticeArray;
	}

}

