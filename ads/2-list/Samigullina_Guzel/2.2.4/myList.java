
/**
 * Разбить список на два, включая в первый - слова расположенные на нечетных местах,
 * а во второй - слова, расположенные на четных местах.
 */
public class myList {

    private class Node{
        String element;
        Node next;
        private Node(){
            this.element=null;
            this.next=null;
        }
        private Node(String element){
            this.element=element;
            this.next=null;
        }

        public void setElement(String element) {
            this.element = element;
        }
        public String getElement(){
            return this.element;
        }

    }
    Node head;
    public myList(){
        this.head = new Node();
    }
    public void add(String s) {
        if (this.head.element==null)//если список пуст, записываем в голову
            head.setElement(s);
        else{
            Node tmp = head;
            while(tmp.next!=null)
                tmp=tmp.next; //идем по списку до конца
            Node newNode = new Node(s);//создаем новый элемент с заданным значением s, следующий для него - null
            tmp.next = newNode;//последний элемент нашего списка ссылаем на новый элемент.
        }
    }
    public void show(){
        Node tmp = this.head;
        while(tmp!=null){
            System.out.print(tmp.element+ ' ');
            tmp=tmp.next;
        }
    }
    public void nodeSorter(){
        myList List1 = new myList();
        myList List2 = new myList();
        if (this.head.element==null)
            System.out.print("This list is empty");
        else{
            Node tmp = this.head;//создаем временную переменную, с которой пойдем по списку
            boolean isOdd = true;//флажок нечетности слова
            while(tmp!=null){
                //слово нечетное - записываем его в список1,
                // меняем флажок четности, переходим к следующему элементу
                if(isOdd){
                    List1.add(tmp.element);
                    tmp=tmp.next;
                    isOdd=false;
                }
                //для четных слов - список2
                else{
                    List2.add(tmp.element);
                    tmp=tmp.next;
                    isOdd=true;
                }
            }
        }

        System.out.print("Список с нечетными словами: ");
        List1.show();
        System.out.print('\n');
        System.out.print("Список с четными словами: ");
        List2.show();
    }
}
