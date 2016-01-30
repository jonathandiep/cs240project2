import java.util.Arrays;

class Set {
  protected Node head;
  protected int size;

  public Set() {
    head = new Node(null, null);
    size = 0;
  }

  public boolean contain(Object data) {
    Node temp = head.getNext();
    while (temp != null) {
      if (data.equals(temp.getElement())) {
        return true;
      } else {
        temp = temp.getNext();
      }
    }
    return false;
  }

  public boolean remove(Object data) {
    if (contain(data)) {
      Node curr = head.getNext();
      Node prev = head;
      while (curr.getElement() != null) {
        if (data.equals(curr.getElement())) {
          prev.setNext(curr.getNext());
          curr.setNext(null);
          curr.setElement(null);
          size--;
          return true;
        } else {
          prev = curr;
          curr = curr.getNext();
        }
      }
    }
    return false;
  }

  public boolean addElement(Object data) {
    if (contain(data) || data.equals("")) { return false; }

    Node newNode = new Node(data, null);

    if (size == 0) {
      head.setNext(newNode);
    } else {
      Node temp = head;
      while (temp.getNext() != null) {
        temp = temp.getNext();
      }
      temp.setNext(newNode);
    }
    size++;
    return true;
  }

  public int size() {
    return size;
  }

  public boolean subsetOf(Set b) {
    if (this.size() == 0) { return true; }

    Object[] arrayA = new Object[this.size()];
    Object[] arrayB = new Object[b.size()];

    Node tempA = this.head.getNext();
    Node tempB = b.head.getNext();

    for (int i = 0; i < this.size(); i++) {
      arrayA[i] = tempA.getElement();
      tempA = tempA.getNext();
    }

    for (int i = 0; i < b.size(); i++) {
      arrayB[i] = tempB.getElement();
      tempB = tempB.getNext();
    }

    int checkSize = 0;
    for (int i = 0; i < arrayA.length; i++) {
      for (int j = 0; j < arrayB.length; j++) {
        if (arrayA[i].equals(arrayB[j])) {
          checkSize++;
        }
      }
    }

    if (checkSize == arrayA.length) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isEqual(Set b) {
    if (this.size() != b.size()) { return false; }

    Object[] arrayA = new Object[this.size()];
    Object[] arrayB = new Object[b.size()];

    Node tempA = this.head.getNext();
    Node tempB = b.head.getNext();

    for (int i = 0; i < this.size(); i++) {
      arrayA[i] = tempA.getElement();
      tempA = tempA.getNext();
      arrayB[i] = tempB.getElement();
      tempB = tempB.getNext();
    }

    Arrays.sort(arrayA);
    Arrays.sort(arrayB);

    int checkSize = 0;
    for (int i = 0; i < arrayA.length; i++) {
      for (int j = 0; j < arrayB.length; j++) {
        if (arrayA[i].equals(arrayB[j])) {
          checkSize++;
        }
      }
    }

    if (checkSize == arrayA.length) {
      return true;
    } else {
      return false;
    }
  }


  public Set union(Set b) {
    Set c = this;
    Node bNode = b.head.getNext();

    while (bNode != null) {
      c.addElement(bNode.getElement());
      bNode = bNode.getNext();
    }

    Node temp = c.head.getNext();
    Node compare = temp.getNext();

    while (temp.getNext() != null) {
      while (compare.getNext() != null) {
        if (temp.getElement() == compare.getElement()) {
          c.remove(compare.getElement());
        }
        compare = compare.getNext();
      }
      temp = temp.getNext();
      compare = temp.getNext();
    }

    return c;
  }

  public Set intersection(Set b) {
    Set c = new Set();
    Node temp = this.head.getNext();
    Node comp = b.head.getNext();

    while (temp != null) {
      while (comp != null) {
        if (temp.getElement() == comp.getElement()) {
          c.addElement(comp.getElement());
        }
        comp = comp.getNext();
      }
      temp = temp.getNext();
      comp = b.head.getNext();
    }

    return c;
  }

  public Set complement(Set b) {
    Set c = this;
    Node temp = c.head.getNext();
    Node comp = b.head.getNext();

    while (comp != null) {
      while (temp != null) {
        if (comp.getElement() == temp.getElement()) {
          c.remove(comp.getElement());
        }
        temp = temp.getNext();
      }
      comp = comp.getNext();
      temp = c.head.getNext();
    }

    return c;
  }

  public String toString() {
    Set set = this;
    Object[] setArr = new Object[set.size()];
    Node temp = set.head.getNext();
    String print = "{";

    for (int i = 0; i < set.size(); i++) {
      setArr[i] = temp.getElement();
      temp = temp.getNext();
    }

    for (int i = 0; i < set.size(); i++) {
      if (i + 1 == set.size()) {
        print += setArr[i].toString();
      } else {
        print += setArr[i].toString() + ",";
      }
    }

    return print + "}";
  }
}
