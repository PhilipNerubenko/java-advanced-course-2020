package comparation;

import java.util.*;

/**
 * Class StringSortExample demonstrates sorting a list of strings using the Collections.sort()
 * method.
 */
public class StringSortExample {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("banana");
    list.add("apple");
    list.add("cherry");
    System.out.println("Before sorting: " + list);

    /**
     * Sorts the list of strings using the Collections.sort() method.
     */
    Collections.sort(list);

    System.out.println("After sorting: " + list);
  }
}
