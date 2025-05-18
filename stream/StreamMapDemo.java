package stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMapDemo {
  /**
   * The main method of the StreamMapDemo class.
   * It demonstrates the usage of Java Streams and map to process a list of strings and an array of
   * integers.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Initialize a list of strings
    List<String> list = List.of("Java", "C++", "Javascript", "Python");

    // Print the original list
    System.out.println("Original list: " + list);

    // Use map to transform the list of strings into a list of their lengths
    List<Integer> lengthList =
        list.stream().map(element -> element.length()).collect(Collectors.toList());

    // Print the list of lengths
    System.out.println("Length of each element: " + lengthList);

    // Initialize an array of integers
    int[] array = {5, 9, 3, 8, 1};

    // Print the original array
    System.out.println("\nOriginal array: " + Arrays.toString(array));

    // Use map to transform the array of integers
    array = Arrays.stream(array)
                .map(element -> {
                  if (element % 3 == 0) {
                    element = element / 3;
                  }
                  return element;
                })
                .toArray();

    // Print the array after processing
    System.out.println("Array after processing: " + Arrays.toString(array));

    // Initialize a set of strings
    Set<String> set = new TreeSet<>();
    set.add("Java");
    set.add("C++");
    set.add("Javascript");
    set.add("Python");

    // Print the set
    System.out.println("\nSet: " + set);

    // Use map to transform the set of strings into a set and a list of their lengths
    Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
    List<Integer> list2 = set.stream().map(e -> e.length()).collect(Collectors.toList());

    // Print the set and list of lengths
    System.out.println("Set of lengths: " + set2);
    System.out.println("List of lengths: " + list2);
  }
}
