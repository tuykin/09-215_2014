import java.util.*;

class Program4 {
    public static void main(String[] args) {
        System.out.println("Enter two integers through gaps for finding their greatest common divisor:");
        Scanner myScanner = new Scanner(System.in);
        int firstNum = myScanner.nextInt();
        int secondNum = myScanner.nextInt();
        myScanner.close();
        int max=firstNum,min=secondNum;
        // проверим на знак, если хоть одно из чисел < 0, то все равно gcd > 0, так как
        // нужен НАИБОЛЬШИЙ общий делитель, а значит > 0
        // поэтому сразу изменим знак у отрицательных чисел, ответ будет тот же
        if(max < 0) {
            max *= -1;
        }
        if(min < 0) {
            min *= -1;
        }
        if(max<min) {
            int cVar = min;
            min=max;
            max=cVar;
        }
        System.out.println("\nSequence of values that are calculated when algorithm was working:");
        System.out.print(max);
        System.out.print(' ');
        System.out.print(min);
        System.out.print(' ');
        // проверка на  0 нужна, т.к. gcd(0,r) = r для любого ненулевого r
        // так как 0 делится на любое целое число, кроме нуля
        if(min == 0) {
            min = max;
            // если второе число так же оказалось 0, то gcd(0,0) не определен
            if(min == 0) {
                System.out.println("\ngcd(0,0) is not defined");
                return;
            }
        }
        while(max%min!=0) {
            int modulo = max%min;
            max = min;
            min = modulo;
            System.out.print(min);
            System.out.print(' ');
        }
        System.out.println("\ngcd(" + firstNum + ',' + secondNum + ") = " + min);
    }
}
