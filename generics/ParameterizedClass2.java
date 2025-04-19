package generics;

/**
 * Class ParameterizedClass2 demonstrates the usage of parameterized classes.
 */
public class ParameterizedClass2 {
  public static void main(String[] args) {
    /**
     * Creates an instance of Pair with a String and an Integer parameter.
     */
    Pair<String, Integer> pair1 = new Pair<>("Hello", 123);
    System.out.println("First Value: " + pair1.getFirstValue());
    System.out.println("Second Value: " + pair1.getSecondValue());

    /**
     * Creates an instance of Pair with an Integer and a String parameter.
     */
    Pair<Integer, String> pair2 = new Pair<>(456, "World");
    System.out.println("First Value: " + pair2.getFirstValue());
    System.out.println("Second Value: " + pair2.getSecondValue());

    /**
     * Creates an instance of OtherPair with two String parameters.
     */
    OtherPair<String> otherPair1 = new OtherPair<>("Hello", "World");
    System.out.println("First Value: " + otherPair1.getFirstValue());
    System.out.println("Second Value: " + otherPair1.getSecondValue());
  }
}

/**
 * Class Pair is a parameterized class that stores two values of types V1 and V2.
 * @param <V1> the type of the first value stored in the Pair object.
 * @param <V2> the type of the second value stored in the Pair object.
 */
class Pair<V1, V2> {
  private V1 value1;
  private V2 value2;

  /**
   * Constructor for Pair.
   * @param value1 the first value to be stored in the Pair object.
   * @param value2 the second value to be stored in the Pair object.
   */
  public Pair(V1 value1, V2 value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  /**
   * Retrieves the first value stored in the Pair object.
   * @return the first value stored in the Pair object.
   */
  public V1 getFirstValue() {
    return value1;
  }

  /**
   * Retrieves the second value stored in the Pair object.
   * @return the second value stored in the Pair object.
   */
  public V2 getSecondValue() {
    return value2;
  }
}

/**
 * Class OtherPair is a parameterized class that stores two values of the same type V.
 * @param <V> the type of the values stored in the OtherPair object.
 */
class OtherPair<V> {
  private V value1;
  private V value2;

  /**
   * Constructor for OtherPair.
   * @param value1 the first value to be stored in the OtherPair object.
   * @param value2 the second value to be stored in the OtherPair object.
   */
  public OtherPair(V value1, V value2) {
    this.value1 = value1;
    this.value2 = value2;
  }

  /**
   * Retrieves the first value stored in the OtherPair object.
   * @return the first value stored in the OtherPair object.
   */
  public V getFirstValue() {
    return value1;
  }

  /**
   * Retrieves the second value stored in the OtherPair object.
   * @return the second value stored in the OtherPair object.
   */
  public V getSecondValue() {
    return value2;
  }
}
