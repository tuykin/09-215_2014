package List;

import java.util.Iterator;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class List<Item> implements Iterable<Item> {

	public Node<Item> head;

	private class Node<Item> {
		Item data;
		Node next;
	}

	public List() {
	}

	public List(Item a) {
		Node n = new Node();
		n.data = a;
		this.head = n;
	}

	public Item returnHead() {
		return this.head.data;
	}

	public void firstInsert(Item a) {
		Node oldHead = this.head;
		Node newHead = new Node();
		newHead.data = a;
		this.head = newHead;
		head.next = oldHead;
	}

	public void firstDelete() {
		this.head = head.next;
	}

	public void lastInsert(Item a) {
		if (this.isEmpty())
			this.firstInsert(a);
		else {
			Node insert = new Node();
			insert.data = a;
			Node x = this.head;
			while (x.next != null)
				x = x.next;
			x.next = insert;
		}
	}

	public void lastDelete() {
		Node x = this.head;
		while (x.next != null)
			x = x.next;
		x = null;
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {

		private Node pointer = head;

		public boolean hasNext() {
			return pointer != null;
		}

		public void remove() {
		}

		public Item next() {
			Item item = (Item) pointer.data;
			pointer = pointer.next;
			return item;
		}
	}

}

public class TrigCoef {

	int number;
	int cosCoef;
	int sinCoef;

	public TrigCoef() {
	}

	public TrigCoef(int number, int cosCoef, int sinCoef) {
		this.number = number;
		this.cosCoef = cosCoef;
		this.sinCoef = sinCoef;
	}
}

public class TrigList {

	public static void trigDerivative(List<TrigCoef> a) {
		TrigCoef n = a.returnHead();
		if (n.number == 0)
			a.firstDelete();

		for (TrigCoef x : a) {
			int swap = -(x.cosCoef * x.number);
			x.cosCoef = x.sinCoef * x.number;
			x.sinCoef = swap;
		}

	}

	public static List<TrigCoef> trigInput(String s)
 throws FileNotFoundException {
 Scanner sc = new Scanner(new FileInputStream(s));
 List<TrigCoef> list = new List<TrigCoef😠);
 if (sc.hasNext()) { 
 int a = sc.nextInt();
 if (a != 0)
 list.firstInsert(new TrigCoef(0, a, 0));
 }
 int cos = 0;
 int sin = 0;
 int number = 1;
 while (sc.hasNext())
 { 
 cos = sc.nextInt();
 sin = sc.nextInt();
 if (sin != 0 || cos != 0)
 list.lastInsert(new TrigCoef(number, cos, sin));
 number++;
 cos = 0;
 sin = 0;
 }
 sc.close();
 return list;
 }

	public static void trigOutput(List<TrigCoef> a) {
		int i = 1;
		TrigCoef n = a.returnHead();
		if (n.number == 0) {
			int coef = n.cosCoef + n.sinCoef;
			System.out.print(coef + " ");
		} else
			System.out.print("0" + " ");
		for (TrigCoef x : a) {
			if (x.number != 0) {
				if (x.number == i)
					System.out.print(x.cosCoef + " " + x.sinCoef + " ");
				else {
					for (int j = 0; j < 2 * (x.number - i); j++)
						System.out.print("0" + " ");
					System.out.print(x.cosCoef + " " + x.sinCoef + " ");
				}
				i = x.number + 1;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) throws FileNotFoundException {
		List<TrigCoef> a = trigInput("in.txt");
		trigOutput(a);
		trigDerivative(a);
		trigOutput(a);
	}

}
