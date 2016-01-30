import java.util.Arrays;

public class Set {
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
      Node curr = head;
      Node prev = null;
      while (curr.getNext() != null) {
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
    if (contain(data)) { return false; }

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
        if (arrayA[i] == arrayB[j]) { checkSize++; }
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

    for (int i = 0; i < arrayA.length; i++) {
      if (arrayA[i] != arrayB[i]) { return false; }
    }
    return true;
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
    Node compare = b.head.getNext();

    while (temp != null) {
      while (compare != null) {
        if (temp.getElement() == compare.getElement()) {
          c.addElement(compare.getElement());
        }
        compare = compare.getNext();
      }
      temp = temp.getNext();
      compare = b.head.getNext();
    }

    return c;
  }
/*

  public Set complement(Set b) {
    Set c = this;
    Node temp = c.head.getNext();
    Node compare = b.head.getNext();
    while (temp.getNext() != null) {
      System.out.println("outside loop");
      while (compare != null) {
        System.out.println("inside loop");
        System.out.println("Temp: " + temp.getElement());
        System.out.println("Comp: " + compare.getElement());
        if (temp.getElement() == compare.getElement()) {
          Node hold = temp;
          temp = temp.getNext();
          c.remove(hold.getElement());
          compare = b.head.getNext();
        } else {
          compare = compare.getNext();
        }
      }
      System.out.println("TempNext: " + temp.getNext().getElement());
      temp = temp.getNext();
      compare = b.head.getNext();
    }

    return c;
  }
*/


  public Set complement(Set b) {
    Set c = this;
    Node temp = c.head.getNext();
    Node compare = b.head.getNext();
    do{
      System.out.println("outside loop");
      while (compare != null) {
        System.out.println("inside loop");
        System.out.println("Temp: " + temp.getElement());
        System.out.println("Comp: " + compare.getElement());
        if (temp.getElement() == compare.getElement()) {
          Node hold = temp;
          temp = temp.getNext();
          c.remove(hold.getElement());
          compare = b.head.getNext();
        } else {
          compare = compare.getNext();
        }
      }
      System.out.println("TempNext: " + temp.getNext().getElement());
      // perform temp checking here
      temp = temp.getNext(); // temp possibly pointing to nothing (after removing)
      compare = b.head.getNext();
    } while(temp.getNext() != null);

    return c;
  }

  /*
  public String toString() {

  }
  */
}

/*
  // union

  Object[] arrayA = new Object[this.size()];
  Object[] arrayB = new Object[b.size()];
  Object[] arrayC = new Object[this.size() + b.size()];
  Set c = new Set();

  Node tempA = this.head.getNext();
  Node tempB = b.head.getNext();

  for (int i = 0; i < arrayA.length; i++) {
    arrayA[i] = tempA.getElement();
    tempA = tempA.getNext();
  }

  for (int i = 0; i < arrayB.length; i++) {
    arrayB[i] = tempB.getElement();
    tempB = tempB.getNext();
  }

  System.arraycopy(arrayA, 0, arrayC, 0 , arrayA.length);
  System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);

  Arrays.sort(arrayC);

  Node tempC = c.head;

  for (int i = 0; i < arrayC.length; i++) {
    if (tempC.getElement() != arrayC[i]) {
      c.addElement(arrayC[i]);
      tempC = tempC.getNext();
    }
  }
  return c;

  // intersection

  Object[] arrayA = new Object[this.size()];
  Object[] arrayB = new Object[b.size()];
  Object[] arrayC = new Object[this.size() + b.size()];
  Set c = new Set();

  Node tempA = this.head.getNext();
  Node tempB = b.head.getNext();

  for (int i = 0; i < arrayA.length; i++) {
    arrayA[i] = tempA.getElement();
    tempA = tempA.getNext();
  }

  for (int i = 0; i < arrayB.length; i++) {
    arrayB[i] = tempB.getElement();
    tempB = tempB.getNext();
  }

  System.arraycopy(arrayA, 0, arrayC, 0 , arrayA.length);
  System.arraycopy(arrayB, 0, arrayC, arrayA.length, arrayB.length);

  Arrays.sort(arrayC);

  Node tempC = c.head;

  for (int i = 0; i < arrayC.length; i++) {
    for (int j = i + 1; j < arrayC.length; j++) {
      if (arrayC[i] == arrayC[j]) {
        arrayC[i] = null;
        arrayC[j] = null;
      }
    }
  }

  for (int i = 0; i < arrayC.length; i++) {
    if (arrayC[i] != null) { c.addElement(arrayC[i]); }
  }
  return c;

*/
