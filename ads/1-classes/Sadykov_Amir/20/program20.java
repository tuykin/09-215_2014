package work2;


public class program20 {
	
	public static void main(String[] args)
	{
		FIO teacher1=new FIO("Anvar","Tuykin","Maratovich");
		Lesson L1=new Lesson(teacher1,"09-215","APA 16.10.2014 10:10","audience 1112");
		FIO teacher2=new FIO("Elina","Stepanova","Radikovna");
		Lesson L2=new Lesson(teacher2,"09-215",
				"modern information technology 16.10.2014 11:50","audience 910");
		L1.Show();
		L2.Show();
		System.out.println("after transformation:");
		if(L2.IsCompatibility(L1))
			L2.UniteWith(L1);
		else
			{
			   L1.ChangeTeacher("Amir", "Sadykov", "Radikovich");
			   Lesson L3=Lesson.CreateNewInGroup(L1, L2.getTeacherFIO(),
					   "computer graphics 16.10.2014 11:50", "audience 910");
			   L3.Show();
			}
		L1.Show();
		L2.Show();
	}

}
