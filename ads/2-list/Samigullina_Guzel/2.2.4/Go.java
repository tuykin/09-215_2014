import java.io.*;
import java.util.*;

/**
 * Разбить список на два, включая в первый - слова расположенные на нечетных местах,
 * а во второй - слова, расположенные на четных местах.
 */
public class Go {
    public static void main(String[]args) throws IOException {
        FileReader input = new FileReader("input.txt");
        myList myText = new myList();
        createMyList(input,myText);
        myText.nodeSorter();
    }

    private static void createMyList(FileReader input, myList myText) throws IOException {
        BufferedReader reader = new BufferedReader(input);
        String s;
        s = reader.readLine();
        while(s!=null){
            StringTokenizer tokenizer = new StringTokenizer(s);
            while (tokenizer.hasMoreTokens()) {
                myText.add(tokenizer.nextToken());
                s=reader.readLine();
            }
        }
        reader.close();
    }

}
