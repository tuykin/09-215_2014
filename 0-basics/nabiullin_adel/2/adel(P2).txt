import java.io.*;

class Program2 {
    public static void main(String[] args) {
        System.out.println("You have to type a string, end it pressing the \"Enter\" key.\n");
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            String cVar;
            cVar = buf.readLine();
            int strLength = cVar.length();
            char[] strCopy = cVar.toCharArray();
            int i =0;
            while((strCopy[i] == strCopy[strLength-i-1]) && (i<strLength/2)) {
                i++;
            }
            if(i==strLength/2) {
                System.out.println("Your string is a palindrome.");
            }
        }
        catch(Exception ourException) {
            System.out.println("\nSomething is wrong: " + ourException);
        }
    }
}
