import java.util.Scanner;

public class two {

           public static void main(String[] args) {
     		String str2="";
     		Scanner in = new Scanner(System.in);
     		String str=in.nextLine();
     		for(int i=str.length()-1;i>=0;i--) {
     			 str2= str2 + str.charAt(i);
     			}
        		if(str.equals(str2)) {
       			System.out.print("palindrome");
      				}
      		else{ System.out.print("not a palindrome");
       				}
      	}

      }
