package stream;

import java.util.stream.Stream;

public class StreamOperationsDemo {
  /**
   * The main method of the StreamOperationsDemo class.
   * It demonstrates the usage of Java Streams and various operations.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Initialize two streams of integers
    Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);
    Stream<Integer> stream2 = Stream.of(6, 7, 8, 9, 10);

    // Concatenate the two streams and print the elements
    Stream<Integer> stream3 = Stream.concat(stream1, stream2);
    stream3.forEach(System.out::println);

    System.out.println();

    // Initialize a stream of integers with duplicates
    Stream<Integer> stream4 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);

    // Print the distinct elements of the stream
    stream4.distinct().forEach(System.out::println);

    System.out.println();

    // Initialize another stream of integers with duplicates
    Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);

    // Print the distinct elements of the stream and count them
    System.out.println(
        "Count distinct elements stream5: " + stream5.distinct().peek(System.out::println).count());
  }
}
