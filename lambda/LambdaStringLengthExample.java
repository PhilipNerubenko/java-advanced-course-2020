package lambda;

public class LambdaStringLengthExample {
  /**
   * Method to print the length of a string.
   * @param i Interface I.
   */
  static void def(I i) {
    System.out.println(i.abc("hello"));
  }
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Print the length of the string "hello" using a lambda expression.
     */
    def((String str) -> { return str.length(); });
  }
}

interface I {
  int abc(String s);
}