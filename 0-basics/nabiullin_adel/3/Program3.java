import java.io.*;
import java.util.*;

class Program3 {
    public static void main(String[] args) {
        String[] myStrings;
        try {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the number of strings you want:");
            int quantity = 0;
            // дальше идет считывание количества{string} строк и
            // конвертирование его в char[], потом в int
            String myStr = buf.readLine();
            int strLength = myStr.length();
            char[] myCMass = myStr.toCharArray();
            int i = 0, j = strLength;
            while(i<strLength) {
                int k = 1;
                for(int p = 0; p < j-1; p++){
                    k*=10;
                }
                j--;
                quantity+=k*((int)myCMass[i]-(int)'0');
                i++;
            }
            myStrings = new String[quantity];
            // будем считывать строки в myStrings из консоли
            System.out.println("On the every line enter: \"name first_num second_num\" through gaps:");
            for(i = 0; i < quantity; i++) {
                myStrings[i] = buf.readLine();
            }
            int w = 0;
            double firstNum = 0 , secondNum = 0;
            for(i = 0; i < quantity; i++) {
                int t = 0;
                for(w = 0; w < 81; w++)
                    System.out.print('-');
                System.out.print('\n');
                StringTokenizer st = new StringTokenizer(myStrings[i]);
                while(st.hasMoreTokens()) {
                    System.out.print('|');
                    String forReading = st.nextToken();
                    strLength = forReading.length();
                    System.out.printf("%19s", forReading);
                    myCMass = forReading.toCharArray();
                    double Num = 0;
                    if(t==1||t==2) {
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
                // "%.3f" - чтобы было 3 знака после запятой, но не дает юзать сразу 2 '%'
                System.out.printf("%19f",firstNum/secondNum);
                System.out.println("|");
            }
            for(w = 0; w < 81; w++)
                System.out.print('-');
        }
        catch(Exception ourException) {
            System.out.println("Something is wrong: " + ourException);
        }
    }
}
