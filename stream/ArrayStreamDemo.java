package stream;

import java.util.Arrays;

public class ArrayStreamDemo {
  /**
   * The main method of the ArrayStreamDemo class.
   * It demonstrates the usage of Java Streams to process an array of integers.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Initialize an array of integers
    int[] array = {5, 9, 3, 8, 1};

    // Print the original array
    System.out.println("Original array: " + Arrays.toString(array));

    // Process each element of the array using a lambda expression
    Arrays.stream(array).forEach(element -> {
      element *= 2;
      System.out.println("Element after processing: " + element);
    });

    System.out.println();

    // Print each element of the array using a method reference
    Arrays.stream(array).forEach(System.out::println);

    System.out.println();

    // Process each element of the array using a static method reference
    Arrays.stream(array).forEach(Utils::myMethod);
  }
}

class Utils {
  /**
   * A static method that takes an integer, adds 5 to it, and prints the result.
   *
   * @param element The integer to be processed
   */
  public static void myMethod(int element) {
    element += 5;
    System.out.println("Element : " + element);
  }
}
