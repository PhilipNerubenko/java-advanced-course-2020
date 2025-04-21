package nested_classes.local_inner_class;

public class LocalInner2 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Local inner class implementing Math2 interface for summation operation.
     */
    class Summation implements Math2 {
      @Override
      public int doOperation(int a, int b) {
        return a + b;
      }
    }

    /**
     * Create a new Summation object.
     */
    Summation summation = new Summation();

    /**
     * Print the result of summation operation.
     */
    System.out.println("Sum: " + summation.doOperation(10, 20));
  }
}

interface Math2 {
  int doOperation(int a, int b);
}