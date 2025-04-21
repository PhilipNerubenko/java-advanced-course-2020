package lambda;

import java.util.List;

public class ForEachDemo {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create a list of strings.
     */
    List<String> list = List.of("hello", "world", "java", "lambda");

    // Using a lambda expression to print each element
    /**
     * Print each element of the list using a lambda expression.
     */
    list.forEach(item -> System.out.println(item));

    // Using a method reference to print each element
    /**
     * Print each element of the list using a method reference.
     */
    list.forEach(System.out::println);

    // Using a method reference to print each element with a custom message
    /**
     * Print each element of the list with a custom message using a lambda expression.
     */
    list.forEach(item -> System.out.println("Item: " + item));

    /**
     * Create a list of integers.
     */
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);

    // Using a lambda expression to print each number multiplied by 2
    /**
     * Print each number of the list multiplied by 2 using a lambda expression.
     */
    numbers.forEach(number -> {
      System.out.println("Number: " + number);
      number *= 2; // This will not change the original number in the list
      System.out.println(number);
    });
  }
}
