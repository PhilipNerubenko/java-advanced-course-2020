package collection.set_interface;

import java.util.Set;
import java.util.TreeSet;

/**
 * Class TreeSetExample demonstrates the usage of TreeSet in Java.
 */
public class TreeSetExample {
  public static void main(String[] args) {
    Set<Integer> treeSet = new TreeSet<>();

    // Adding elements to the TreeSet
    treeSet.add(5);
    treeSet.add(8);
    treeSet.add(2);
    treeSet.add(1);
    treeSet.add(10);
    // treeSet.add(null); // This will throw NullPointerException

    // Displaying the elements in the TreeSet
    System.out.println("TreeSet elements: " + treeSet);

    // Checking if the TreeSet contains a specific element
    System.out.println("Contains 5: " + treeSet.contains(5));

    // Removing an element from the TreeSet
    treeSet.remove(5);
    System.out.println("After removing 5: " + treeSet);

    // Checking the size of the TreeSet
    System.out.println("Size of TreeSet: " + treeSet.size());

    // Iterating through the TreeSet
    System.out.println("Iterating through TreeSet:");
    for (Integer number : treeSet) {
      System.out.println(number);
    }

    // Clearing the TreeSet
    treeSet.clear();
    System.out.println("After clearing, size of TreeSet: " + treeSet.size());
  }
}
