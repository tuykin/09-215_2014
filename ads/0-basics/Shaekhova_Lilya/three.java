import java.util.*;

public class three {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        System.out.print("\nВведите кол-во строк: ");
        int n=in.nextInt();
        System.out.print("\nВведите для каждой строки через пробелы имя и два числа: ");
        String[] s = new String[n];
        for(int i=0; i<n; i++)
        {
            s[i] = in2.nextLine();
            s[i] = s[i].trim();
        }
        System.out.print("\n \n");
        System.out.printf("| %8s | %8s | %8s | %8s|\n ","Имя","Число_1","Число_2", "Частное" );
        for(int i=0; i<n;i++)
        {
            String[] word = s[i].split("\\s+");
            int word_1 = Integer.valueOf(word[1]);
            int word_2 = Integer.valueOf(word[2]);
            System.out.printf("| %8s | %8d | %8d | %8.3f|\n ", word[0], word_1, word_2, (double) word_1 / word_2);
        }

    }
}
