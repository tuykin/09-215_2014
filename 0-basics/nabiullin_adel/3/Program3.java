import java.io.*;
import java.util.*;

class Program3 {
    public static void main(String[] args) {
        String[] myStrings;
        try {
            System.out.println("Enter the number of strings you want:");
            Scanner sc = new Scanner(System.in);
            int quantity = sc.nextInt();
            myStrings = new String[quantity];
            System.out.println("On the every line enter: \"name first_num second_num\" through gaps:");
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            for(int i = 0; i < quantity; i++) {
                myStrings[i] = buf.readLine();
            }
            int firstNum = 0 , secondNum = 0;
            for(int i = 0; i < quantity; i++) {
                int t = 0;
                for(int w = 0; w < 81; w++)
                    System.out.print('-');
                System.out.print('\n');
                StringTokenizer st = new StringTokenizer(myStrings[i]);
                while(st.hasMoreTokens()) {
                    System.out.print('|');
                    String forReading = st.nextToken();
                    int strLength = forReading.length();
                    System.out.printf("%19s", forReading);
                    int Num = 0;
                    if(t==1||t==2) {
                        char[] myCMass = forReading.toCharArray();
                        int r  = 0, q = strLength;
                        while(r<strLength) {
                            int k = 1;
                            for(int p = 0; p < q-1; p++){
                                k*=10;
                            }
                            q--;
                            Num+=k*((int)myCMass[r]-(int)'0');
                            r++;
                        }
                    }
                    if(t==1)
                        firstNum = Num;
                    if(t==2)
                        secondNum = Num;
                    t++;
                }
                System.out.print("|");
                System.out.printf("%19.3f|\n",(double)firstNum/secondNum);
            }
            for(int w = 0; w < 81; w++)
                System.out.print('-');
        }
        catch(Exception ourException) {
            System.out.println("Something is wrong: " + ourException);
        }
    }
}
