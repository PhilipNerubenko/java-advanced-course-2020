package nested_classes.anonymous_class;

public class AnonymousClass {
  /**
   * Private field x with initial value 5.
   */
  private int x = 5;

  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Anonymous class implementing Math2 interface for summation operation.
     */
    Math2 summation = new Math2() {
      @Override
      public int doOperation(int a, int b) {
        AnonymousClass anonymousClass = new AnonymousClass();
        return a + b + anonymousClass.x;
      }
    };

    /**
     * Anonymous class implementing Math2 interface for subtraction operation.
     */
    Math2 subtraction = new Math2() {
      @Override
      public int doOperation(int a, int b) {
        return a - b;
      }
    };

    /**
     * Print the result of summation operation.
     */
    System.out.println("Sum: " + summation.doOperation(10, 20));

    /**
     * Print the result of subtraction operation.
     */
    System.out.println("Subtraction: " + subtraction.doOperation(20, 10));
  }
}

// interface Math2 {
//     int doOperation(int a, int b);
// }

class Math2 {
  /**
   * Performs division operation on two integers.
   * @param a The dividend.
   * @param b The divisor.
   * @return The result of the division operation.
   */
  public int doOperation(int a, int b) {
    return a / b;
  }
}
