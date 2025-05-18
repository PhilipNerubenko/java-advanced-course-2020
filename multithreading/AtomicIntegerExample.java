package multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
  // static int counter = 0;
  /**
   * An atomic integer counter.
   */
  static AtomicInteger counter = new AtomicInteger(0);

  /**
   * Increments the counter using various atomic methods.
   */
  public static void increment() {
    counter.incrementAndGet();
    counter.getAndIncrement();
    counter.addAndGet(5);
    counter.getAndAdd(5);
    counter.decrementAndGet();
    counter.getAndDecrement();
  }

  /**
   * Increments the counter using a synchronized method.
   */
  //    public synchronized static void increment() {
  //        counter++;
  //    }

  /**
   * The main method of the AtomicIntegerExample class.
   * It demonstrates the usage of an atomic integer in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create two threads that run the increment method
    Thread thread1 = new Thread(new MyRunnable23());
    Thread thread2 = new Thread(new MyRunnable23());

    // Start the threads
    thread1.start();
    thread2.start();

    // Wait for the threads to finish
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print the final value of the counter
    System.out.println("Final counter value: " + counter);
  }
}

class MyRunnable23 implements Runnable {
  /**
   * Increments the counter 1000 times.
   */
  @Override
  public void run() {
    for (int i = 0; i < 1000; i++) {
      AtomicIntegerExample.increment();
    }
  }
}
