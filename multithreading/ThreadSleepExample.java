package multithreading;

public class ThreadSleepExample {
  /**
   * The main method of the ThreadSleepExample class.
   * It demonstrates the usage of thread sleep in Java.
   *
   * @param args Command line arguments (not used in this program)
   * @throws InterruptedException if a thread is interrupted while sleeping
   */
  public static void main(String[] args) throws InterruptedException {
    // Print the numbers from 5 to 1 with a 1-second delay between each number
    for (int i = 5; i > 0; i--) {
      System.out.println("i = " + i);
      Thread.sleep(1000); // Sleep for 1 second
    }

    // Print a message indicating the end of the countdown
    System.out.println("Let's go!");
  }
}
