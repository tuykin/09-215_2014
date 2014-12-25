package apa;

import java.util.Scanner;

public class List {
	private int i;
	private int a;
	private int b;
	private List next;
	private List prev;
	private List head;

	public List() {
		this.next = null;
		this.prev = null;
	}

	public List(int i, int a, int b) {
		this.i = i;
		this.a = a;
		this.b = b;
		this.next = null;
		this.prev = null;
	}

	public void AddNode2End(int i, int a, int b) {
		List new3 = new List(i, a, b);
		if (head == null) {
			head = new3;
		} else {
			List step = head;
			while (step.next != null) {
				step = step.next;
			}
			step.next = new3;
			step.next.prev = step;
		}
	}

	public void AddNode2Start(int i, int a, int b) {
		List new3 = new List(i, a, b);
		if (head == null) {
			head = new3;
		} else {
			new3.next = head;
			new3.next.prev = new3;
			head = new3;
		}
	}

	public void AddNodeBefore(List q, int i, int a, int b) {
		List new3 = new List(i, a, b);
		if (q.prev == null) {
			q.prev = new3;
			q.prev.next = q;
			head = new3;
		} else {
			new3.prev = q.prev;
			new3.prev.next = new3;
			q.prev = new3;
			q.prev.next = q;
		}
	}

	public void DelNode(List q) {
		if ((q.next == null) && (q.prev != null)) {
			q = q.prev;
			q.next = null;
		}
		if ((q.next != null) && (q.prev == null)) {
			q = q.next;
			q.prev = null;
			head = q;
		}
		if ((q.next != null) && (q.prev != null))
			q.prev.next = q.next;
		q.next.prev = q.prev;
		q = q.prev;
	}

	public void InputPolinom() {
		int vmore = 1;
		while (vmore == 1) {
			System.out.print("Введите коэффициент радиан(i): ");
			Scanner sc = new Scanner(System.in);
			int vi = sc.nextInt();
			System.out.print("Введите коэффициент косинуса(a): ");
			int va = sc.nextInt();
			System.out.print("Введите коэффициент синуса(b): ");
			this.AddNode2End(vi, va, sc.nextInt());
			System.out.print("Добавить еще тройку? 0/1: ");
			vmore = sc.nextInt();
			sc.close();
		}
	}

	public void PlusPolinom(List p2)
	{
		List step = head;
		while (step.next != null)
		{
			step = step.next;
		}
		step.next = p2.head;
		step.next.prev = step;
	}

	public void FindUseless()
	{
		List i = head;
		while (i != null)
		{
			List j = i.next;
			while (j != null)
			{
				if (i.i == j.i)
				{
					i.a += j.a;
					i.b += j.b;
					DelNode(j);
				}
				j = j.next;
			}
			if ((i.a == 0) && (i.b == 0))
			{
				DelNode(i);
			}
			i = i.next;
		}
	}

	public void PrintPolinom()
	{
		List pr = head;
		if (pr == null)
		{
			System.out.println("Полином пуст в результате сокращений");
		} else
		{
			while (pr != null)
			{
				if (pr.next == null)
				{
					if (pr.a == 0)
					{
						System.out.print(+pr.b + "sin(" + pr.i + "x)");
					}
					if (pr.b == 0)
					{
						System.out.print(pr.a + "cos(" + pr.i + "x)");
					}
					if ((pr.b != 0) && (pr.a != 0)) {
						System.out.print(pr.a + "cos(" + pr.i + "x) + " + pr.b
								+ "sin(" + pr.i + "x)");
					}
				} else
				{
					if (pr.a == 0)
					{
						System.out.print(+pr.b + "sin(" + pr.i + "x) + ");
					}
					if (pr.b == 0)
					{
						System.out.print(pr.a + "cos(" + pr.i + "x) + ");
					}
					if ((pr.b != 0) && (pr.a != 0)) {
						System.out.print(pr.a + "cos(" + pr.i + "x) + " + pr.b
								+ "sin(" + pr.i + "x) + ");
					}
				}
				pr = pr.next;
			}
			System.out.println("");
		}
	}
}