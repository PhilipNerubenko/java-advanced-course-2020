package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample1 {
  /**
   * The main method of the ThreadPoolExample1 class.
   * It demonstrates the usage of thread pools in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Print a message indicating the start of the main thread
    System.out.println("Main thread started");

    // Create a thread pool with 5 threads
    ExecutorService executor = Executors.newFixedThreadPool(5);

    // Submit 10 tasks to the thread pool
    for (int i = 0; i < 10; i++) {
      executor.execute(new RunnableImplementationExample10());
    }

    // Shutdown the thread pool
    executor.shutdown();

    // Wait for the tasks to finish
    try {
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print a message indicating the end of the main thread
    System.out.println("Main thread ending");
  }
}

class RunnableImplementationExample10 implements Runnable {
  /**
   * Prints the name of the current thread and simulates some work with a 500ms delay.
   */
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " is executing.");
    try {
      Thread.sleep(500); // Simulate some work
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
