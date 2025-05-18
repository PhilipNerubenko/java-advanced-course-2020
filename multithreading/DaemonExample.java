package multithreading;

public class DaemonExample {
  /**
   * The main method of the DaemonExample class.
   * It demonstrates the usage of daemon threads in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Print a message indicating the start of the main thread
    System.out.println("Main thread started");

    // Create a user thread and start it
    UserThread userThread = new UserThread();
    userThread.setName("User Thread");
    userThread.start();

    // Print a message indicating the start of the user thread
    System.out.println("User thread started");

    // Create a daemon thread, set it as a daemon, and start it
    DaemonThread daemonThread = new DaemonThread();
    daemonThread.setName("Daemon Thread");
    daemonThread.setDaemon(true); // Before starting the thread, set it as a daemon
    daemonThread.start();

    // Print a message indicating the start of the daemon thread
    System.out.println("Daemon thread started");

    // Print a message indicating the end of the main thread
    System.out.println("Main thread ending");
  }
}

class UserThread extends Thread {
  /**
   * Prints the name of the current thread and whether it is a daemon thread.
   * Then prints the letters from A to J with a 300ms delay between each letter.
   */
  public void run() {
    System.out.println(Thread.currentThread().getName() + " is daemon thread: " + isDaemon());
    for (char i = 'A'; i <= 'J'; i++) {
      try {
        Thread.sleep(300);
        System.out.println(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class DaemonThread extends Thread {
  /**
   * Prints the name of the current thread and whether it is a daemon thread.
   * Then prints the numbers from 1 to 1000 with a 100ms delay between each number.
   */
  public void run() {
    System.out.println(Thread.currentThread().getName() + " is daemon thread: " + isDaemon());
    for (int i = 1; i <= 1000; i++) {
      try {
        Thread.sleep(100);
        System.out.println(i);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
