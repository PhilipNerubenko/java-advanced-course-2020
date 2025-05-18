package collection;

import java.util.ArrayList;

/**
 * Class ArrayListMethods1 demonstrates the usage of ArrayList methods in Java.
 */
public class ArrayListMethods1 {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("Apple");
    list.add("Banana");
    list.add("Cherry");
    list.add(1, "Orange");

    // This will throw an IndexOutOfBoundsException
    // list.add(6, "Grapes");

    for (String fruit : list) {
      System.out.println(fruit);
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i) + " is at index " + i);
    }

    System.out.println("Size of the list: " + list.size());

    System.out.println("Is the list empty? " + list.isEmpty());

    list.set(0, "Pineapple");

    System.out.println("First element: " + list.get(0));

    System.out.println("Does the list contain 'Banana'? " + list.contains("Banana"));

    list.remove("Banana");

    System.out.println("After removing 'Banana': " + list);

    list.remove(1);

    System.out.println("After removing element at index 1: " + list);

    list.clear();

    System.out.println("After clearing the list: " + list);
  }
}
