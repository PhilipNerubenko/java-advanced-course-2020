package nested_classes.local_inner_class;

public class LocalInner1 {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create a new Math object.
     */
    Math math = new Math();

    /**
     * Get the result of the operation with 21 and 4.
     */
    math.getResult(21, 4);
  }
}

class Math {
  /**
   * Private field a with initial value 10.
   */
  private int a = 10;

  /**
   * Method to get the result of the operation.
   * @param dividend The dividend.
   * @param divisor The divisor.
   */
  public void getResult(final int dividend, final int divisor) {
    // // effectively final or final
    //    final int dividend = 21;
    /**
     * Local inner class representing the division operation.
     */
    class Division {
      //    private int dividend;
      //    private int divisor;

      /**
       * Method to get the dividend.
       * @return The dividend.
       */
      //    public int getDividend() {
      //        return dividend;
      //    }

      /**
       * Method to set the dividend.
       * @param dividend The dividend.
       */
      //    public void setDividend(int dividend) {
      //        this.dividend = dividend;
      //    }

      /**
       * Method to get the divisor.
       * @return The divisor.
       */
      //    public int getDivisor() {
      //        return divisor;
      //    }

      /**
       * Method to set the divisor.
       * @param divisor The divisor.
       */
      //    public void setDivisor(int divisor) {
      //        this.divisor = divisor;
      //    }

      /**
       * Method to get the quotient of the division operation.
       * @return The quotient of the division operation.
       */
      public int getQuotient() {
        return dividend / divisor;
      }

      /**
       * Method to get the remainder of the division operation.
       * @return The remainder of the division operation.
       */
      public int getRemainder() {
        System.out.println(a);
        return dividend % divisor;
      }
    }

    /**
     * Create a new Division object.
     */
    Division division = new Division();
    // division.setDividend(21);
    // division.setDivisor(4);

    /**
     * Print the dividend, divisor, quotient, and remainder.
     */
    System.out.println("Dividend: " + dividend);
    System.out.println("Divisor: " + divisor);
    System.out.println("Quotient: " + division.getQuotient());
    System.out.println("Remainder: " + division.getRemainder());
  }
}
