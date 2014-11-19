public class Palindrom {
        
    public static void main(String[] args) {
    String str=new String ("reduider");
	int n=str.length();
	Boolean flag=true;
	int i=0;
	int j=n-1;
    char a;
    char b;
	while(i<j)
		{
         a=str.charAt(i);
         b=str.charAt(j);
		if(a!=b)
			{
			flag=false;
			System.out.print("false");
			return;
			}
		else
			{
			i++;
			j--;
			}
		}
	System.out.print("true");
	return;
	}
}		
	