package work2;

public class FIO {
	private String name;
	private String surname;
	private String patronymic;
	//методы-конструкторы
	public FIO(){
	
	};
	
	public FIO(String name,String surname,String patronymic)
	{
		this.name=name;
		this.surname=surname;
		this.patronymic=patronymic;
	}
	//Методы-Селекторы:
	public void Show()
	{
		System.out.println(this.name+" "+this.surname+" "+this.patronymic);
	}
	
	public String getFIO()
	{
		return(this.name+" "+this.surname+" "+this.patronymic);
	}
	
}
