package lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerDemo {
  /**
   * Creates three cars using the provided supplier.
   * @param carSupplier Supplier for creating cars.
   * @return ArrayList of created cars.
   */
  public static ArrayList<ConsumerCar> createThreeCars(Supplier<ConsumerCar> carSupplier) {
    ArrayList<ConsumerCar> cars = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      cars.add(carSupplier.get());
    }
    return cars;
  }

  /**
   * Changes the car using the provided consumer.
   * @param car Car to be changed.
   * @param carConsumer Consumer for changing the car.
   */
  public static void changeCar(ConsumerCar car, Consumer<ConsumerCar> carConsumer) {
    carConsumer.accept(car);
  }

  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create three cars using the provided supplier.
     */
    ArrayList<ConsumerCar> cars = createThreeCars(() -> new ConsumerCar("BMW", "Black", 2.4));
    for (ConsumerCar car : cars) {
      System.out.println(car);
    }

    /**
     * Change the first car using the provided consumer.
     */
    changeCar(cars.get(0), car -> {
      car.color = "Red";
      car.engine = 3.0;
      System.out.println("Updated car: " + car);
    });
    System.out.println("After change:");
    for (ConsumerCar car : cars) {
      System.out.println(car);
    }
  }
}

class ConsumerCar {
  /**
   * Model of the car.
   */
  String model;

  /**
   * Color of the car.
   */
  String color;

  /**
   * Engine of the car.
   */
  double engine;

  /**
   * Constructor for the ConsumerCar class.
   * @param model Model of the car.
   * @param color Color of the car.
   * @param engine Engine of the car.
   */
  public ConsumerCar(String model, String color, double engine) {
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
    return "ConsumerCar [model=" + model + ", color=" + color + ", engine=" + engine + "]";
  }
}
