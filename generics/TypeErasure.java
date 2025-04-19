package generics;

/**
 * Class TypeErasure demonstrates the concept of type erasure in Java.
 */
public class TypeErasure {
  /**
   * Method abc is erased in the JVM to:
   * public void abc(Info info) {
   *     String s = (String) info.getValue();
   * }
   * @param info an Info object with a String value.
   */
  public void abc(Info<String> info) { // Erasure of method abc(Info<String>) is the same as another
                                       // method in type TypeErasure
    String s = info.getValue();
  }

  /**
   * Method abc is erased in the JVM to:
   * public void abc(Info info) {
   *     Integer s = (Integer) info.getValue();
   * }
   * @param info an Info object with an Integer value.
   */
  public void abc(Info<Integer> info) { // Erasure of method abc(Info<Integer>) is the same as
                                        // another method in type TypeErasure
    Integer i = info.getValue();
  }
}

/**
 * Class Info is a parameterized class that stores a value of type T.
 * @param <T> the type of the value stored in the Info object.
 */
class Info<T> {
  // static T value; // Error: Cannot use static type parameter
  private T value;

  /**
   * Constructor for Info.
   * @param value the value to be stored in the Info object.
   */
  public Info(T value) {
    this.value = value;
  }

  @Override
  /**
   * Returns a string representation of the Info object.
   * @return a string representation of the Info object.
   */
  public String toString() {
    return "Info [value=" + value + "]";
  }

  /**
   * Retrieves the value stored in the Info object.
   * @return the value stored in the Info object.
   */
  public T getValue() {
    return value;
  }
}

/**
 * Class Parent.
 */
class Parent {
  /**
   * Method abc.
   * @param info an Info object with a String value.
   */
  public void abc(Info<String> info) {
    String s = info.getValue();
  }
}

/**
 * Class Child extends Parent.
 */
class Child extends Parent {
  /**
   * Method abc is not an override of a method from Parent, but a new method.
   * @param info an Info object with an Integer value.
   */
  public void abc(Info<Integer> info) { // Error: Cannot override the method from Parent
    Integer i = info.getValue();
  }
}
