
public class Node {
	  Polimonchick element;
	  private Node next;
	  public Polimonchick getElement(){
	  return element;
	  }
	   //установка содержимого для текущего элемента списка
	  public void setElement(Polimonchick e){
	    element = e;
	  }
	  //получение указателя на следующий элемент списка
	  public Node getNext() {
	    return next;
	  }
	  //установка следующего элемента списка
	  public void setNext(Node n) {
	    next = n;
	  }
	}
