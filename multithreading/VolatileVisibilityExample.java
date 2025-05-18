package multithreading;

public class VolatileVisibilityExample extends Thread {
  /**
   * A volatile boolean variable that controls the execution of the thread.
   */
  // boolean running = true; // The variable is not volatile, so it may be cached by the CPU
  volatile boolean running = true; // The variable is volatile, so it will not be cached by the CPU

  /**
   * Increments a counter variable while the running variable is true.
   */
  @Override
  public void run() {
    long counter = 0;
    while (running) {
      counter++;
    }
    System.out.println("Counter: " + counter);
  }

  /**
   * The main method of the VolatileVisibilityExample class.
   * It demonstrates the usage of volatile variables in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a thread that runs the run method of the VolatileVisibilityExample class
    VolatileVisibilityExample thread = new VolatileVisibilityExample();

    // Start the thread
    thread.start();

    // Let the thread run for a while
    try {
      Thread.sleep(3000); // Let the thread run for a while
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print a message indicating that it is time to wake up
    System.out.println("After 3 seconds it is time to wake up!");

    // Stop the thread
    thread.running = false;

    // Wait for the thread to finish
    try {
      thread.join(); // Wait for the thread to finish
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print a message indicating the end of the main thread
    System.out.println("Main thread finished.");
  }
}
