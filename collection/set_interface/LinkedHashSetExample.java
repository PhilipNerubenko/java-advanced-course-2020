package collection.set_interface;

import java.util.LinkedHashSet;

/**
 * Class LinkedHashSetExample demonstrates the usage of LinkedHashSet in Java.
 */
public class LinkedHashSetExample {
  public static void main(String[] args) {
    // based on HashMap, so does not support depending on their last use
    // LinkedHashSet is a collection that maintains insertion order
    LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

    // Adding elements to the LinkedHashSet
    linkedHashSet.add(5);
    linkedHashSet.add(3);
    linkedHashSet.add(1);
    linkedHashSet.add(8);
    linkedHashSet.add(10);

    // Displaying the elements in the LinkedHashSet
    System.out.println("Elements in LinkedHashSet: " + linkedHashSet);

    // Checking if an element exists
    boolean containsElement = linkedHashSet.contains(3);
    System.out.println("Contains 3: " + containsElement);

    // Removing an element
    linkedHashSet.remove(3);
    System.out.println("After removing 3: " + linkedHashSet);

    // Checking the size of the LinkedHashSet
    int size = linkedHashSet.size();
    System.out.println("Size of LinkedHashSet: " + size);

    // Iterating through the LinkedHashSet
    System.out.println("Iterating through LinkedHashSet:");
    for (Integer element : linkedHashSet) {
      System.out.println(element);
    }

    // Clearing the LinkedHashSet
    linkedHashSet.clear();
    System.out.println("After clearing, size of LinkedHashSet: " + linkedHashSet.size());

    // Checking if the LinkedHashSet is empty
    boolean isEmpty = linkedHashSet.isEmpty();
    System.out.println("Is LinkedHashSet empty? " + isEmpty);
  }
}
