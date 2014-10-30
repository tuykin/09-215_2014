class Program2_2_2 {
    public static void main(String[] args) {
        ListOfWords myList = new ListOfWords();
        try {
            myList.FillFromTextFile("input.txt");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        myList.PrintToConsole();
        myList.AddSemicolons();
        myList.PrintToConsole();
    }
}