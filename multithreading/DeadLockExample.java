package multithreading;

public class DeadLockExample {
  /**
   * Two objects used as locks.
   */
  public static final Object lock1 = new Object();
  public static final Object lock2 = new Object();

  /**
   * The main method of the DeadLockExample class.
   * It demonstrates the usage of deadlocks in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create two threads that run different tasks
    Thread10 thread1 = new Thread10();
    Thread20 thread2 = new Thread20();

    // Set the names of the threads
    thread1.setName("Thread 1");
    thread2.setName("Thread 2");

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
  }
}

class Thread10 extends Thread {
  /**
   * Acquires two locks in a specific order and prints messages indicating the acquisition of each
   * lock.
   */
  @Override
  public void run() {
    synchronized (DeadLockExample.lock1) {
      System.out.println(Thread.currentThread().getName() + " acquired " + DeadLockExample.lock1);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (DeadLockExample.lock2) {
        System.out.println(Thread.currentThread().getName() + " acquired " + DeadLockExample.lock2);
      }
    }
  }
}

class Thread20 extends Thread {
  /**
   * Acquires two locks in a specific order and prints messages indicating the acquisition of each
   * lock.
   */
  @Override
  public void run() {
    synchronized (DeadLockExample.lock2) {
      System.out.println(Thread.currentThread().getName() + " acquired " + DeadLockExample.lock2);
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      synchronized (DeadLockExample.lock1) {
        System.out.println(Thread.currentThread().getName() + " acquired " + DeadLockExample.lock1);
      }
    }
  }
}
