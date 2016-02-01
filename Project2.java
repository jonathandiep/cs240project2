import java.util.Scanner;

class Project2 {
  public static void main(String[] args) {
    System.out.println("Assign a value for Set A (submit empty value for empty set):");
    Scanner sc = new Scanner(System.in);
    Object i = sc.nextLine();
    Set setA = new Set();
    setA.addElement(i);
    while (!(i.equals(""))) {
      System.out.println("Assign the next value for Set A (submit empty value when finished):");
      i = sc.nextLine();
      setA.addElement(i);
    }
    System.out.println("Set A: " + setA.toString());
    System.out.println();

    System.out.println("Assign a value for Set B:");
    Object j = sc.nextLine();
    Set setB = new Set();
    setB.addElement(j);
    while (!(j.equals(""))) {
      System.out.println("Assign the next value for Set B:");
      j = sc.nextLine();
      setB.addElement(j);
    }


    System.out.println("Set A: " + setA.toString());
    System.out.println("Set B: " + setB.toString());
    System.out.println("sizes: " + setA.size() + " | " + setB.size());
    System.out.println();
    System.out.println("A subset B:     " + setA.subsetOf(setB));
    System.out.println("A equal B:      " + setA.isEqual(setB));
    System.out.println("A union B:      " + setA.union(setB));
    System.out.println("A intersect B:  " + setA.intersection(setB));
    System.out.println("A complement B: " + setA.complement(setB));

  }
}
