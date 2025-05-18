package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATMQueueExample {
  /**
   * The main method of the ATMQueueExample class.
   * It demonstrates the usage of locks and threads in Java.
   *
   * @param args Command line arguments (not used in this program)
   * @throws InterruptedException if a thread is interrupted while waiting for another thread to
   *     finish
   */
  public static void main(String[] args) throws InterruptedException {
    // Create a lock
    Lock lock = new ReentrantLock();

    // Create three employees that use the lock
    Employee employee1 = new Employee("Employee 1", lock);
    Employee employee2 = new Employee("Employee 2", lock);
    Employee employee3 = new Employee("Employee 3", lock);

    // Wait for 5 seconds
    Thread.sleep(5000);

    // Create two more employees that use the lock
    Employee employee4 = new Employee("Employee 4", lock);
    Employee employee5 = new Employee("Employee 5", lock);

    // Wait for all employees to finish
    try {
      employee1.join();
      employee2.join();
      employee3.join();
      employee4.join();
      employee5.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Employee extends Thread {
  /**
   * The name of the employee.
   */
  String name;

  /**
   * The lock used by the employee.
   */
  private Lock lock;

  /**
   * Constructor for the Employee class.
   *
   * @param name The name of the employee
   * @param lock The lock used by the employee
   */
  public Employee(String name, Lock lock) {
    this.name = name;
    this.lock = lock;
    this.start();
  }

  /**
   * Simulates the employee using an ATM.
   */
  @Override
  public void run() {
    if (lock.tryLock()) {
      try {
        // System.out.println(name + " is waiting");
        // lock.lock();
        System.out.println(name + " is using ATM");
        Thread.sleep(2000);
        System.out.println(name + " is done using ATM");
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        lock.unlock();
      }
    } else {
      System.out.println(name + " is does not want to wait in line");
    }
  }
}
