import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListOfWords {
    private class Node {
        private String info;
        private Node next;
        Node(String ourInf) {
            this.info = ourInf;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    // default constructor
    ListOfWords() {
        this.head = this.tail = null;
    }

    // adds word to the end of the list
    private void AddInTheEnd(String elem) {
        Node forAdd = new Node(elem);
        if(this.head == null)
            this.head = this.tail = forAdd;
        else {
            this.tail.next = forAdd;
            this.tail = forAdd;
        }
    }

    // fills the list from the text file
    public void FillFromTextFile(String fName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fName));
        while(sc.hasNextLine())
            AddInTheEnd(sc.nextLine());
        sc.close();
    }

    // displays the list in the console window
    public void PrintToConsole() {
        Node forShow = this.head;
        if(forShow == null)
            System.out.print("This ListOfWords is empty.");
        while(forShow != null) {
            System.out.print(forShow.info + " ");
            forShow = forShow.next;
        }
        System.out.println();
    }

    // adds semicolon before every word beginning with 'z'
    public void AddSemicolons() {
        if(this.head != null) {
            if(this.head.info.charAt(0) == 'z') {
                Node phantom = new Node("; ");
                phantom.next = this.head;
                this.head = phantom;
            }
        }
        else return;
        Node phantom = this.head;
        Node forIterate = this.head.next;
        while(forIterate != null) {
            if(forIterate.info.charAt(0) == 'z') {
                phantom.next = new Node("; ");
                phantom.next.next = forIterate;
            }
            phantom = phantom.next;
            forIterate = forIterate.next;
        }
    }
}