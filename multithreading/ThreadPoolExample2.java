package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample2 {
  /**
   * The main method of the ThreadPoolExample2 class.
   * It demonstrates the usage of scheduled thread pools and cached thread pools in Java.
   *
   * @param args Command line arguments (not used in this program)
   * @throws InterruptedException if a thread is interrupted while waiting for another thread to
   *     finish
   */
  public static void main(String[] args) throws InterruptedException {
    // Create a scheduled thread pool with 1 thread
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    // Print a message indicating the start of the scheduled thread pool with the execute method
    System.out.println("\nScheduledThreadPool, method execute: ");
    // Submit 3 tasks to the thread pool
    for (int i = 0; i < 3; i++) {
      executor.execute(new RunnableImplementationExample11());
    }
    // Wait for the tasks to complete
    Thread.sleep(8000); // Increased to ensure all tasks complete

    // Print a message indicating the start of the scheduled thread pool with the execute method and
    // a delay
    System.out.println("\nScheduledThreadPool, method execute with starts 3 second: ");
    // Submit a task to the thread pool with a 3-second delay
    executor.schedule(new RunnableImplementationExample11(), 3, TimeUnit.SECONDS);
    // Wait for the task to complete
    Thread.sleep(5500); // Adjusted to show clear task execution

    // Print a message indicating the start of the scheduled thread pool with the
    // scheduleAtFixedRate method
    System.out.println("\nScheduledThreadPool, method scheduleAtFixedRate: ");
    // Submit a task to the thread pool with a 3-second initial delay and a 2-second period
    executor.scheduleAtFixedRate(new RunnableImplementationExample11(), 3, 2, TimeUnit.SECONDS);
    // Wait for the tasks to complete
    Thread.sleep(13000); // Increased to show 5 iterations clearly

    // Print a message indicating the start of the scheduled thread pool with the
    // scheduleWithFixedDelay method
    System.out.println("\nScheduledThreadPool, method scheduleWithFixedDelay:");
    // Submit a task to the thread pool with a 3-second initial delay and a 2-second delay between
    // tasks
    executor.scheduleWithFixedDelay(new RunnableImplementationExample11(), 3, 2, TimeUnit.SECONDS);
    // Wait for the tasks to complete
    Thread.sleep(15000); // Increased to show full execution pattern

    // Shutdown the scheduled thread pool
    executor.shutdown();

    // Print a message indicating the start of the cached thread pool
    System.out.println("\nCachedThreadPool: ");
    // Create a cached thread pool
    ExecutorService executor4 = Executors.newCachedThreadPool();
    // Submit 2 tasks to the thread pool
    for (int i = 0; i < 2; i++) {
      executor4.execute(new RunnableImplementationExample11());
    }
    // Shutdown the cached thread pool
    executor4.shutdown();
    // Wait for the tasks to complete
    Thread.sleep(4000); // Reduced to match actual execution time
  }
}

class RunnableImplementationExample11 implements Runnable {
  /**
   * Prints the name of the current thread, simulates some work with a 2-second delay,
   * and then prints a message indicating the completion of the thread.
   */
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " is executing.");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(Thread.currentThread().getName() + " has finished.");
  }
}
