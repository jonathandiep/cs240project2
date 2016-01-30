public class Node {
  Object element;
  Node next;

  public Node(Object e, Node n) {
    element = e;
    next = n;
  }

  public Object getElement() {
    return element;
  }

  public Node getNext() {
    return next;
  }

  public void setElement(Object newElement) {
    element = newElement;
  }

  public void setNext(Node newNext) {
    next = newNext;
  }
}
