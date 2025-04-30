package multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
  /**
   * The main method of the SemaphoreExample class.
   * It demonstrates the usage of a semaphore in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a semaphore with 3 available call boxes
    Semaphore callBox = new Semaphore(3);

    // Create five persons that use the call box
    Person person1 = new Person("Person 1", callBox);
    Person person2 = new Person("Person 2", callBox);
    Person person3 = new Person("Person 3", callBox);
    Person person4 = new Person("Person 4", callBox);
    Person person5 = new Person("Person 5", callBox);
  }
}

class Person extends Thread {
  /**
   * The name of the person.
   */
  String name;

  /**
   * The semaphore representing the call boxes.
   */
  private Semaphore callBox;

  /**
   * Constructor for the Person class.
   *
   * @param name The name of the person
   * @param callBox The semaphore representing the call boxes
   */
  public Person(String name, Semaphore callBox) {
    this.name = name;
    this.callBox = callBox;
    this.start();
  }

  /**
   * Waits for a call box, uses it, and then releases it.
   */
  @Override
  public void run() {
    System.out.println(name + " is waiting for a call box.");
    try {
      callBox.acquire();
      System.out.println(name + " is using a call box.");
      sleep(2000); // Simulate time spent in the call box
      System.out.println(name + " is done using the call box.");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      callBox.release();
    }
  }
}
