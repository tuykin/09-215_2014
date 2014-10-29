import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class List {
	
	private Node first;
	private Node last;
	
	//конструктор
	List()
	{
		this.first=this.last=null;
	}
	
	//методы
	
	public void push(String info)
	{
		if(this.isEmpty()) //
		{
			Node newNode=new Node(info);
			this.first=newNode;
			this.last=newNode;
		}
		else
		{
			Node newNode=new Node(info);
			this.last.next=newNode;
			this.last=newNode;
		}
	}
	
	public boolean isEmpty()
	{
		return this.first==null;
	}
	
	public String pop()
	{
		if(!this.isEmpty())
		{
			String a;
			if(this.first==this.last) //когда в списке только один элемент
			{
				 a=this.first.info;
				 this.first=this.last=null;
				 return a;
			}
			a=this.last.info;
			Node n=this.first;
			while(n.next!=this.last)
				n=n.next;
			this.last=n;
			last.next=null;
			return a;
		}
        System.out.println("List is empty!");
     	return "";		
	}
	
	public void Show()
	{
		if(!this.isEmpty())
		{
			Node n=this.first;
			while(n!=null)
			{
				System.out.print(n.info+" ");
				n=n.next;
			}
			System.out.println();
		}
		else
			System.out.print("List is empty!");	
	}
	
	public void CreateFromFile(String FileName) throws FileNotFoundException 
	{
		Scanner scan=new Scanner(new File(FileName));
		while(scan.hasNextLine())
			this.push(scan.nextLine());
		scan.close();	
	}

	//метод для задачи 2.2.2
	public void ModifyList() 
	{
		if(!this.isEmpty())
		{
			Node n=this.first;
			if(this.first.info.charAt(0)=='z')
			{
				Node newNode=new Node("; ");
				newNode.next=this.first;
				this.first=newNode;
				n=this.first.next;
				}
			while(n.next!=null)
			{
				if(n.next.info.charAt(0)=='z')
				{
					Node newNode=new Node("; ");
					newNode.next=n.next;
					n.next=newNode;
					n=n.next;
					}
				n=n.next;
			}
		}
	}
		
	//метод для задачи 2.2.1
	public void RemoveNeighbors()
	{
		if(!this.isEmpty())
		{
			Node n=this.first;
			while(n.next!=null)
			{
				if(n.info.equals(n.next.info))
				{
					n.next=n.next.next;
				}
				else
					n=n.next;	
			}
		}
	}
	public static void main(String[] args)
	{
		List MyList=new List();
		try {
			MyList.CreateFromFile("text.txt");
		} catch (FileNotFoundException e)
		{
			System.out.print(e.getMessage()); //выводим ошибку
		}
		MyList.Show();
		MyList.RemoveNeighbors();
		MyList.ModifyList();
		MyList.Show();

		
	}

}



