package generics;

import java.util.*;

/**
 * Class GenericsBoundingExample demonstrates the usage of generics bounding in Java.
 */
public class GenericsBoundingExample {
  public static void main(String[] args) {
    // X x = new Y();

    // // Not a subclass of Lixt<X>
    // List<X> list = new ArrayList<Y>();

    // // allowed
    // List<X> list1 = new ArrayList<X>();

    List<Number> list2 = new ArrayList<Number>();
  }
}

/**
 * Class X is a parameterized class that stores a value of type T.
 * @param <T> the type of the value stored in the X object, which must extend Number and implement
 *     I1 and I2.
 */
class X<T extends Number & I1 & I2> {
  private T t;

  /**
   * Constructor for X.
   * @param t the value to be stored in the X object.
   */
  public X(T t) {
    this.t = t;
  }

  /**
   * Retrieves the value stored in the X object.
   * @return the value stored in the X object.
   */
  public T getT() {
    return t;
  }

  /**
   * Sets the value stored in the X object.
   * @param t the value to be stored in the X object.
   */
  public void setT(T t) {
    this.t = t;
  }
}

/**
 * Class Y extends X.
 */
class Y extends X {
  /**
   * Constructor for Y.
   * @param t the value to be stored in the Y object.
   */
  public Y(Number t) {
    super(t);
  }
}

interface I1 {}
interface I2 {}