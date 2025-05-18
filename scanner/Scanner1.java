package scanner;

import java.util.Scanner;

public class Scanner1 {
  /**
   * Main method to execute Scanner demonstrations.
   *
   * @param args Command line arguments (not used)
   */
  public static void main(String[] args) {
    /**
     * 1. Console input demonstration
     * Create Scanner object for reading from standard input
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Prompt user for two integers and perform division operations
     * nextInt() reads integer values from input
     */
    System.out.println("Input 2 Integer");
    int x = sc.nextInt();
    int y = sc.nextInt();
    System.out.println("Quotient = " + (x / y));
    System.out.println("Remainder = " + (x % y));

    /**
     * Read two strings from input
     * next() reads until whitespace delimiter
     */
    System.out.println("Input 2 String");
    String s1 = sc.next();
    String s2 = sc.next();
    System.out.println("value s1 = " + s1);
    System.out.println("value s2 = " + s2);

    /**
     * Read a double value from input
     * nextDouble() parses floating-point numbers
     */
    System.out.println("Input Double");
    double z = sc.nextDouble();
    System.out.println("value z = " + z);
    sc.close();

    /**
     * 2. String source input demonstration
     * Create Scanner object for reading from a string source
     * Demonstrates line-by-line reading with hasNextLine()/nextLine()
     */
    Scanner sc1 = new Scanner("Hello my friend!\nHow are you doing?\n"
        + "What's good?");

    while (sc1.hasNextLine()) {
      System.out.println(sc1.nextLine());
    }
    sc1.close();
  }
}