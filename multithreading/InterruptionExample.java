package multithreading;

public class InterruptionExample {
  /**
   * The main method of the InterruptionExample class.
   * It demonstrates the usage of thread interruption in Java.
   *
   * @param args Command line arguments (not used in this program)
   * @throws InterruptedException if a thread is interrupted while waiting for another thread to
   *     finish
   */
  public static void main(String[] args) throws InterruptedException {
    // Print a message indicating the start of the main thread
    System.out.println("Main thread started");

    // Create an interrupted thread and start it
    InterruptedThread interruptedThread = new InterruptedThread();
    interruptedThread.setName("Interrupted Thread");
    interruptedThread.start();

    // Wait for 2 seconds
    Thread.sleep(2000);

    // Interrupt the thread
    // interruptedThread.stop(); // Deprecated method, but used for demonstration purposes
    interruptedThread.interrupt(); // Interrupt the thread
    System.out.println("Interrupted thread interrupted");

    // Wait for the thread to finish
    interruptedThread.join(); // Wait for the thread to finish

    // Print a message indicating the end of the main thread
    System.out.println("Main thread ending");
  }
}

class InterruptedThread extends Thread {
  /**
   * A variable to store the sum of square roots.
   */
  double sqrtSum = 0;

  /**
   * Calculates the sum of square roots from 1 to 1000000000.
   * If the thread is interrupted, it prints a message and exits.
   */
  @Override
  public void run() {
    for (int i = 1; i <= 1000000000; i++) {
      if (isInterrupted()) {
        System.out.println("Thread interrupted, exiting...");
        return; // Exit the thread if interrupted
      }
      sqrtSum += Math.sqrt(i);
      try {
        sleep(100);
      } catch (InterruptedException e) {
        System.out.println("Thread interrupted during sleep, exiting...");
        return; // Exit the thread if interrupted during sleep
      }
    }
    System.out.println("Sum sqrt: " + sqrtSum);
  }
}
