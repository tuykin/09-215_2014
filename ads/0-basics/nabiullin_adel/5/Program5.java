class Program5 {
    static double MyLogFactorial(int cVar) {
        if(cVar != 1)
            return Math.log(cVar)+MyLogFactorial(cVar - 1);
        else
            return 0;
    }
    public static void main(String[] args) {
        System.out.println("Enter non-negative integer N to calculate the log(N!):");
        Scanner MyScanner = new Scanner(System.in);
        int ourNum = MyScanner.nextInt();
        // проверка на знак
        if(ourNum < 0) {
            System.out.println("You've entered the negative number, but I've told you not to do that. So why? =/");
            return;
        }
        // проверка на 0, 0! = 1
        if(ourNum == 0) {
            System.out.println("log(0!) = 0");
            return;
        }
        System.out.println("log(" + ourNum + "!) = " + MyLogFactorial(ourNum));
    }
}
