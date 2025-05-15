package stream;

import java.util.List;

public class ParallelStreamDemo {
  /**
   * The main method of the ParallelStreamDemo class.
   * It demonstrates the usage of Java Streams to perform operations on a list of doubles.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Initialize a list of doubles
    List<Double> numbers = List.of(10.0, 5.0, 1.0, 0.25);

    // Calculate the sum of the numbers using a parallel stream
    double sum = numbers.parallelStream().reduce((a, b) -> a + b).get();
    System.out.println("Sum of numbers: " + sum);

    // Calculate the division of the numbers using a regular stream
    // (parallel stream is not used because it would give a wrong answer)
    double division = numbers.stream().reduce((a, b) -> a / b).get();
    System.out.println("Division of numbers: " + division);
  }
}
