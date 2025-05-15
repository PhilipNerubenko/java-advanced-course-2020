package stream;

import java.util.Arrays;

public class StreamMethodChainingDemo {
  /**
   * The main method of the StreamMethodChainingDemo class.
   * It demonstrates the usage of Java Streams and method chaining to process an array of integers.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Initialize an array of integers
    int[] arr = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};

    // Sort the array using a stream and print the sorted array
    arr = Arrays.stream(arr).sorted().toArray();
    System.out.println(Arrays.toString(arr));

    System.out.println();

    // Use method chaining to filter, map, and reduce the array of integers
    int result = Arrays.stream(arr)
                     .filter(e -> e % 2 == 1)
                     .map(e -> {
                       if (e % 3 == 0) {
                         e = e / 3;
                       }
                       return e;
                     })
                     .reduce((a, e) -> a + e)
                     .getAsInt();

    // Print the result of the method chaining
    System.out.println(result);
  }
}
