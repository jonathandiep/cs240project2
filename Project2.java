class Project2 {
  public static void main(String[] args) {
    Set setA = new Set();
    System.out.println(setA.addElement(4));
    System.out.println(setA.addElement(3));
    System.out.println(setA.addElement(1));
    System.out.println(setA.addElement(2));
    Set setB = new Set();
    System.out.println(setB.addElement(2));
    System.out.println(setB.addElement(1));
    System.out.println(setB.addElement(3));
    Set c = setA.complement(setB);
    System.out.println("size: " + c.size());
    Node afterHead = c.head.getNext();
    Node afterHead2 = afterHead.getNext();
    System.out.println(afterHead.getElement());
    System.out.println(afterHead2.getElement());
    /*
    Node afterHead3 = afterHead2.getNext();
    Node afterHead4 = afterHead3.getNext();
    System.out.println(afterHead3.getElement());
    System.out.println(afterHead4.getElement());
    System.out.println("size: " + c.size());
    */
    // 1. ask user how many sets wanted
    // 2. ask user what to enter for each set
  }
}
