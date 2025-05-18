package multithreading;

public class ThisLockExample {
  /**
   * The main method of the ThisLockExample class.
   * It demonstrates the usage of this locks in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a shared counter
    SharedCounter runnable = new SharedCounter();

    // Create three threads that increment the counter
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);
    Thread thread3 = new Thread(runnable);

    // Start the threads
    thread1.start();
    thread2.start();
    thread3.start();
  }
}

class Counter {
  /**
   * A static counter variable.
   */
  static int count = 0;
}

class SharedCounter implements Runnable {
  /**
   * Prints a message indicating the execution of a non-synchronized method.
   */
  private void nonSynchronizedMethod() {
    System.out.println("Non-synchronized method execution");
  }

  /**
   * Increments the counter variable in the Counter class in a synchronized block using 'this' as a
   * lock.
   */
  private void synchronizedIncrement() {
    nonSynchronizedMethod();

    // Synchronized block using 'this' as lock
    synchronized (this) {
      Counter.count++;
      System.out.println(Counter.count);
    }
  }

  /**
   * Increments the counter variable in the Counter class three times.
   */
  @Override
  public void run() {
    for (int i = 0; i < 3; i++) {
      synchronizedIncrement();
    }
  }
}
