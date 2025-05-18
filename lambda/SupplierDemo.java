package lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

public class SupplierDemo {
  /**
   * Creates three cars using the provided supplier.
   * @param carSupplier Supplier for creating cars.
   * @return ArrayList of created cars.
   */
  public static ArrayList<SupplierCar> createThreeCars(Supplier<SupplierCar> carSupplier) {
    ArrayList<SupplierCar> cars = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      cars.add(carSupplier.get());
    }
    return cars;
  }

  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create three cars using the provided supplier.
     */
    ArrayList<SupplierCar> cars = createThreeCars(() -> new SupplierCar("BMW", "Black", 2.4));
    for (SupplierCar car : cars) {
      System.out.println(car);
    }
  }
}

class SupplierCar {
  /**
   * Model of the car.
   */
  private String model;

  /**
   * Color of the car.
   */
  private String color;

  /**
   * Engine of the car.
   */
  private double engine;

  /**
   * Constructor for the SupplierCar class.
   * @param model Model of the car.
   * @param color Color of the car.
   * @param engine Engine of the car.
   */
  public SupplierCar(String model, String color, double engine) {
    this.model = model;
    this.color = color;
    this.engine = engine;
  }

  /**
   * Returns a string representation of the car.
   * @return String representation of the car.
   */
  @Override
  public String toString() {
    return "SupplierCar [model=" + model + ", color=" + color + ", engine=" + engine + "]";
  }
}
