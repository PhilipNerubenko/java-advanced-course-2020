package multithreading;

public class ThreadExtensionExample extends Thread {
  /**
   * Prints the numbers from 1 to 999.
   */
  @Override
  public void run() {
    for (int i = 1; i < 1000; i++) {
      System.out.println(i);
    }
  }

  /**
   * The main method of the ThreadExtensionExample class.
   * It demonstrates the usage of thread extension in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create three threads that run different tasks
    CountUpThread thread1 = new CountUpThread();
    CountDownThread thread2 = new CountDownThread();
    ThreadExtensionExample thread3 = new ThreadExtensionExample();

    // Start the threads
    thread1.start();
    thread2.start();
    thread3.start();

    // The main thread will also run
    for (int i = 1000; i > 0; i--) {
      System.out.println(i);
    }
  }
}

class CountUpThread extends Thread {
  /**
   * Prints the numbers from 1 to 999.
   */
  @Override
  public void run() {
    for (int i = 1; i < 1000; i++) {
      System.out.println(i);
    }
  }
}

class CountDownThread extends Thread {
  /**
   * Prints the numbers from 1000 to 1.
   */
  @Override
  public void run() {
    for (int i = 1000; i > 0; i--) {
      System.out.println(i);
    }
  }
}
