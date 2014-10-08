package work2;


public class Lesson {
	
	private FIO teacher;
	private int group_number;
	private String what_when;
	private String where;
	//методы-конструкторы
	public Lesson(String teacher_name,String teacher_surname,
			String teacher_patronymic,int group_number,String what_when,String where)
	{
		this.teacher=new FIO(teacher_name,teacher_surname,teacher_patronymic);
		this.group_number=group_number;
		this.what_when=what_when;
		this.where=where;
	};
	
	//методы-селекторы
	 public void Show()
	 {
		 this.teacher.Show();
		 System.out.println(this.group_number+" "+this.what_when+" "+this.where);
		 
	 }
	 
	 public String getTeacherStr()
	 {
		 return(this.teacher.getFIO());
	 }
	 
	 public FIO getTeacherFIO()
	 {
		 return this.teacher;
	 }
	 
	 public boolean IsCompatibility(Lesson les)
	 {
		 if(this.what_when.equals(les.what_when))
			 return true;
		 return false;
	 }
	 
	 //методы-модификаторы
	 public void UniteWith(Lesson les)
	 {
		 if(this.IsCompatibility(les))
		 { 
			 this.teacher=les.teacher;
			 this.where=les.where;
		 }
		 else
			 System.out.println("Lessons are incompatible!");
	 }
	 public void ChangeTeacher(String name,String surname,String patronymic)
	 {
		 FIO teacher=new FIO(name,surname,patronymic);
		 this.teacher=teacher;
	 }
	 public void ChangeTeacherFromLesson(Lesson les)
	 {
		 this.teacher=les.teacher;
	 }
	 
	 //методы-генераторы
	/* public void CreateNewInGroup(Lesson les,FIO teacher,String what_when,String where)
	 {
		 
	 }*/
	 
	 
}
