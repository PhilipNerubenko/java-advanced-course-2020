package collection.set_interface;

import java.util.HashSet;
import java.util.Set;

/**
 * Class HashSetExample demonstrates the usage of HashSet in Java.
 */
public class HashSetExample {
  public static void main(String[] args) {
    // Create a HashSet
    Set<String> hashSet = new HashSet<>();

    // Add elements to the HashSet
    hashSet.add("Apple");
    hashSet.add("Banana");
    hashSet.add("Orange");
    hashSet.add("Mango");

    // Display the HashSet
    System.out.println("HashSet: " + hashSet);

    for (String fruit : hashSet) {
      System.out.println("Fruit: " + fruit);
    }

    // Check if an element exists
    System.out.println("Contains Apple? " + hashSet.contains("Apple"));

    // Remove an element
    hashSet.remove("Orange");
    System.out.println("After removing Orange: " + hashSet);

    // Get the size of the HashSet
    System.out.println("Size of HashSet: " + hashSet.size());

    // is Empty
    System.out.println("Is HashSet empty? " + hashSet.isEmpty());
  }
}
