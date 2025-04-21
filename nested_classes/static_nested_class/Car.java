package nested_classes.static_nested_class;

public class Car {
  /**
   * Color of the car.
   */
  String color;

  /**
   * Number of doors in the car.
   */
  int doorCount;

  /**
   * Engine of the car.
   */
  Engine engine;

  /**
   * Static field a.
   */
  private static int a;

  /**
   * Constructor for the Car class.
   * @param color Color of the car.
   * @param doorCount Number of doors in the car.
   * @param engine Engine of the car.
   */
  public Car(String color, int doorCount, Engine engine) {
    this.color = color;
    this.doorCount = doorCount;
    this.engine = engine;
  }

  /**
   * Method to print the count of engines and create a new engine.
   */
  void method() {
    System.out.println(Engine.countOfEngines);
    Engine engine = new Engine(200);
    System.out.println(engine.horsePower);
  }

  /**
   * Returns a string representation of the car.
   * @return String representation of the car.
   */
  @Override
  public String toString() {
    return "My car: [color=" + color + ", doorCount=" + doorCount + ", engine=" + engine + "]";
  }

  /**
   * Interface I.
   */
  interface I {}

  // static nested class
  /**
   * Static nested class representing the engine of the car.
   */
  public static class Engine {
    // non-static fields
    /**
     * Horsepower of the engine.
     */
    private int horsePower;
    // static field
    /**
     * Count of engines.
     */
    static int countOfEngines = 0;

    /**
     * Constructor for the Engine class.
     * @param horsePower Horsepower of the engine.
     */
    public Engine(int horsePower) {
      System.out.println(a);
      System.out.println(doorCount); // This will cause a compilation error
      // Cannot access non-static field from static context
      this.horsePower = horsePower;
      countOfEngines++;
    }

    /**
     * Returns a string representation of the engine.
     * @return String representation of the engine.
     */
    @Override
    public String toString() {
      return "Engine [horsePower=" + horsePower + "]";
    }
  }
}

class Test {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    // Create an instance of the static nested class
    /**
     * Create a new Engine object with 150 horsepower.
     */
    Car.Engine engine = new Car.Engine(150);

    /**
     * Print the engine.
     */
    System.out.println(engine);

    // Create an instance of the outer class using the nested class
    /**
     * Create a new Car object with color "Red", 4 doors, and the engine.
     */
    Car car = new Car("Red", 4, engine);

    /**
     * Print the car.
     */
    System.out.println(car);
  }
}
