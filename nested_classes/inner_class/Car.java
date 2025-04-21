package nested_classes.inner_class;

public class Car {
  /**
   * Color of the car.
   */
  String color;

  /**
   * Number of doors in the car.
   */
  private int doorCount;

  /**
   * Engine of the car.
   */
  Engine engine;

  /**
   * Constructor for the Car class.
   * @param color Color of the car.
   * @param doorCount Number of doors in the car.
   */
  public Car(String color, int doorCount) {
    Engine engine = new Engine(100);
    System.out.println("Car constructor Engine: " + engine.horsePower);

    this.color = color;
    this.doorCount = doorCount;
    // this.engine = this.new Engine(horsePower);
  }

  /**
   * Sets the engine of the car.
   * @param engine Engine of the car.
   */
  public void setEngine(Engine engine) {
    this.engine = engine;
  }

  /**
   * Returns a string representation of the car.
   * @return String representation of the car.
   */
  @Override
  public String toString() {
    return "My car: [color=" + color + ", doorCount=" + doorCount + ", engine=" + engine + "]";
  }

  // inner nested class
  /**
   * Inner class representing the engine of the car.
   */
  public class Engine {
    /**
     * Horsepower of the engine.
     */
    private int horsePower;
    // The field a cannot be declared static in a non-static inner type, unless initialized with a
    // constant expression public static int a = 5; // not allowed
    public final static int a = 5;

    /**
     * Constructor for the Engine class.
     * @param horsePower Horsepower of the engine.
     */
    public Engine(int horsePower) {
      System.out.println("Engine constructor doorCount: " + doorCount);
      this.horsePower = horsePower;
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
    /**
     * Create a new car with color "Red" and 4 doors.
     */
    Car car = new Car("Red", 4);

    /**
     * Create a new engine with 120 horsepower.
     */
    Car.Engine engine = car.new Engine(120);

    /**
     * Print the car and engine before setting the engine.
     */
    System.out.println("Before setting engine:");
    System.out.println(car);
    System.out.println(engine);

    /**
     * Set the engine of the car.
     */
    car.setEngine(engine);

    /**
     * Print the car after setting the engine.
     */
    System.out.println("After setting engine:");
    System.out.println(car);

    /**
     * Create a new car with color "Blue" and 2 doors and a new engine with 150 horsepower.
     */
    Car.Engine engine2 = new Car("Blue", 2).new Engine(150);

    /**
     * Print the new engine.
     */
    System.out.println("New engine:");
    System.out.println(engine2);
  }
}
