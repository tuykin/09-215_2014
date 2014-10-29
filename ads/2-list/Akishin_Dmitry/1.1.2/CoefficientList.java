import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CoefficientList {

	private Node head;

	public CoefficientList() {
		head = null;
	}

	// Добавление в конец списка
	public void add(int degree, double coef) {
		if (head == null) {
			head = new Node(degree, coef);
		} else {
			Node tail = head;
			while (tail.hasNext()) {
				tail = tail.next;
			}
			Node newNode = new Node(degree, coef);
			tail.next = newNode;
			newNode.back = tail;
		}
	}

	// Добавление в начало списка
	public void addToHead(int degree, double coef) {
		if (head == null)
			head = new Node(degree, coef);
		else {
			Node newNode = new Node(degree, coef);
			newNode.next = head;
			head = newNode;
		}
	}

	// Загрузка списка из файла
	public void load(String path) throws IOException {
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = br.readLine();
		if (line != null) {
			StringTokenizer st = new StringTokenizer(line, " ,;");
			int degree = 0;
			double coef;
			while (st.hasMoreTokens()) {
				coef = Double.parseDouble(st.nextToken());
				if (coef != 0) {
					this.add(degree, coef);
				}
				degree++;
			}
		}
		br.close();
	}

	// Вывод списка в консоль
	public void print() {
		int degree = 0;
		Node node = head;
		if (node == null)
			System.out.print("Polynomial doesn't exist");
		while (node != null) {
			while (node.degree > degree) {
				System.out.print((degree == 0 ? "0"
						: (" + 0 * x" + (degree == 1 ? "" : "^" + degree))));
				degree++;
			}
			System.out
					.print((node.coefficient < 0 ? (degree == 0 ? "-" : " - ")
							: (degree == 0 ? "" : " + "))
							+ Math.abs(node.coefficient)
							+ (degree == 0 ? "" : " * x"
									+ (node.degree == 1 ? ""
											: ("^" + node.degree))));
			node = node.next;
			degree++;
		}
	}

	// Частное от деления на (c+dx)
	public CoefficientList divideBy(double c, double d) {
		CoefficientList quotient = new CoefficientList();
		if (d == 0)
			if (c == 0)
				System.out.print("На ноль делить нельзя!!11\n");
			else {
				Node node = head;
				while (node != null) {
					quotient.add(node.degree, node.coefficient / c);
					node = node.next;
				}
			}
		else {

			// Делим столбиком

			// Доходим до конца списка
			Node tail = head;
			while (tail.hasNext())
				tail = tail.next;
			int degree = tail.degree;
			// Подразумевается, что старший коэффициент != 0
			double a = tail.coefficient;
			double z;
			double currCoeff;
			while (degree != 0) {
				z = a / d;
				if (z != 0)
					quotient.addToHead(degree - 1, z);
				if (tail.back == null || tail.back.degree < degree - 1)
					currCoeff = 0;
				else {
					tail = tail.back;
					currCoeff = tail.coefficient;
				}
				a = currCoeff - z * c;
				degree--;
			}
		}
		return quotient;
	}

	private class Node {
		public int degree;
		public double coefficient;
		public Node next;
		public Node back;

		public Node(int degree, double coef) {
			this.degree = degree;
			this.coefficient = coef;
			next = null;
			back = null;
		}

		public boolean hasNext() {
			return (next != null);
		}
	}

}
