import java.util.Scanner;

/**
 * @author Ildar
 * @date {DATE}.
 */
public class Main {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line = scanner.nextLine();
    String newLine = "";
    for (int i = 0; i < line.length(); i++) {
      char s = line.charAt(i);
      if (s >= 'a' && s <= 'z') {
        newLine += '3';
      } else if (s == '*' || s == '/' || s == '+' || s == '-') {
        newLine += '2';
      } else if (s == '(') {
        newLine += '0';
      } else if (s == ')') {
        newLine += '1';
      } else {
        //не правильный символ
        System.out.print("Incorrect symbol =" + s);
        return;
      }
    }
    while (newLine.length() > 1) {
      int l = newLine.length();
      newLine = newLine.replaceAll("0312031", "3");

      //проверка что хотябы одну формулу нашли
      if (l == newLine.length())
        break;
    }
    if (newLine.equals("3")) {
      System.out.print("Correct");
    } else {
      System.out.print("Incorrect");
    }

  }
}
