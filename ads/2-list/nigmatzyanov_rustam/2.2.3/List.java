package lists;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class List<Item> {
	// узел списка, хранит информацию и указатель на следующий узел
	public class Node {
		Item data;
		Node next;
	}

	private Node head; // голова списка, хранит указатель на первый узел
	private int N; // размер списка (кол-во эл-в)

	public List() {
		this.N = 0;
	}

	public void push(Item item) // добавление эл-та в начало списка
	{
		Node newNode = new Node();
		newNode.data = item;

		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
		this.N++;
	}

	public Item pop() // удаление эл-та с начала списка
	{
		if (head == null)
			return null;
		else {
			Item tmp = head.data; // сохраняем значение головы
			head = head.next; // смещаем голову и объект автоматически удаляется
								// (сборкой мусора)
			this.N--;
			return tmp;
		}
	}

	public void addLast(Item item) // добавление эл-та в конец списка
	{
		if (head == null) {
			head = new Node();
			head.data = item;
		} else {
			Node helpNode = head; // создаём указатель на голову, чтобы не
									// нарушать порядок списка

			while (helpNode.next != null)
				// в цикле доходим до последнего эл-та
				helpNode = helpNode.next;

			Node newNode = new Node();
			newNode.data = item;

			helpNode.next = newNode; // вставляем после последнего
		}
		this.N++;
	}

	public boolean isEmpty() { // проверка списка на пустоту
		//return N == 0;
		return this.head == null;
	}

	public int size() { // размер списка
		return N;
	}

	public Item peak() { // посмотреть голову списка
		return this.head.data;
	}

	public void print() // вывод содержимого списка
	{
		if (head != null) {
			Node helpNode = head;

			while (helpNode != null) {
				System.out.print(helpNode.data + " ");
				helpNode = helpNode.next;
			}

			System.out.println();
		} else
			System.out.println("Список пуст");
	}

	// метод для создания списка по текстовому файлу
	public static List<String> createList(FileReader fr) throws IOException {
		BufferedReader bRf = new BufferedReader(fr);
		List<String> newlist = new List<>();
		String str = bRf.readLine();

		while (str != null) {
			if (!str.equals("")) { // пробелы не записываем
				newlist.addLast(str);
				str = bRf.readLine();
			}
			else
				str = bRf.readLine();
		}
		return newlist;
	}

	// исключить из списка слова, начинающиеся с символа «z»
	public void deleteWordZ() { 
		Node helpNode = this.head;
		
		while (helpNode != null) {
			if (helpNode.data.toString().charAt(0) == 'z' || helpNode.data.toString().charAt(0) == 'Z') {
				if (helpNode == this.head) { // удаление слов, начин-ся на 'z', с начала списка
					this.head = helpNode.next;
					helpNode.next = null; // delete эл-т
					helpNode = this.head;
				} else {
					Node pred = previous(helpNode); //сохраняем предыдущий эл-т
					pred.next = helpNode.next;
					helpNode.next = null; // delete эл-т
					helpNode = pred.next;
				}
			} else
				helpNode = helpNode.next;
		}
	}

	public Node previous(Node tec) { // метод, возвращающий предыдущий эл-т от указанного
		Node pred = this.head;
		while(pred.next != tec)
			pred = pred.next;
		
		return pred;
	}
	
	// Задание 2.2.3
	public void combineLists (List<Item>list2) {
		Node l1 = this.head;
		Node l2 = list2.head;
		
		this.push(l2.data); //добавить эл-т из второго списка в начало первого
		l2=l2.next;
		int position = 1; // позиция в первом списке
		
		while (l2 != null && l1 != null) {
			if (position % 2 != 0) { // если нечётная позиция
				Node newNode = new Node(); // вставляемый узел
				newNode.data = l2.data;
				
				// вставка в первый список после текущего
				newNode.next = l1.next;
				l1.next = newNode;
				
				l1 = l1.next;
				l2 = l2.next;
				position++;
			}
			else { // если позиция чётная
				l1 = l1.next;
				position++;
			}
		}
			if (l2 != null && l1 == null) {
				while (l2 != null) {
					this.addLast(l2.data);
					l2 = l2.next;
				}
			}
	}

	public static void main(String[] args) throws IOException {
		FileReader fr1 = new FileReader("src/lists/list1.txt");
		List<String> list1 = new List<>();
		FileReader fr2 = new FileReader("src/lists/list2.txt");
		List<String> list2 = new List<>();
		
		list1 = createList(fr1);
		list2 = createList(fr2);
		list1.print();
		list2.print();
		
		System.out.println("Объединённый список: ");
		list1.combineLists(list2);
		list1.print();
		System.out.println("Исключены слова, начинающиеся на 'z': ");
		list1.deleteWordZ();
		list1.print();
	}
}
