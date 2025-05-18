package collection;

/**
 * Class StackExample demonstrates the usage of stack in Java.
 */
public class StackExample {
  /**
   * Method abc1.
   */
  static void abc1() {
    System.out.println("abc1 starts");
    System.out.println("abc1 ends");
  }

  /**
   * Method abc2.
   */
  static void abc2() {
    System.out.println("abc2 starts");
    abc1();
    System.out.println("abc2 ends");
  }
  /**
   * Method abc3.
   */
  static void abc3() {
    System.out.println("abc3 starts");
    abc2();
    System.out.println("abc3 ends");
  }

  /**
   * Main method.
   * @param args the command line arguments.
   */
  public static void main(String[] args) {
    System.out.println("main starts");
    abc3();
    System.out.println("main ends");
  }
}
