package lambda;

import java.util.function.Function;

public class FunctionDemo {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    // Using a lambda expression to create a Function that converts a String to its length
    /**
     * Create a Function that converts a String to its length using a lambda expression.
     */
    Function<String, Integer> stringLengthFunction = str -> str.length();

    // Using the Function to get the length of a string
    /**
     * Test string.
     */
    String testString = "hello";
    /**
     * Get the length of the test string using the Function.
     */
    Integer length = stringLengthFunction.apply(testString);
    System.out.println("Length of \"" + testString + "\": " + length);

    // Using a method reference to create a Function that converts a String to its uppercase version
    /**
     * Create a Function that converts a String to its uppercase version using a method reference.
     */
    Function<String, String> toUpperCaseFunction = String::toUpperCase;

    // Using the Function to convert a string to uppercase
    /**
     * Convert the test string to uppercase using the Function.
     */
    String upperCaseString = toUpperCaseFunction.apply(testString);
    System.out.println("Uppercase of \"" + testString + "\": " + upperCaseString);
  }
}
