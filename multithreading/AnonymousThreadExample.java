package multithreading;

public class AnonymousThreadExample {
  /**
   * The main method of the AnonymousThreadExample class.
   * It demonstrates the usage of anonymous threads in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create and start a new thread using a lambda expression
    new Thread(() -> {
      for (int i = 1; i < 1000; i++) {
        System.out.println(i);
      }
    }).start();

    // Create and start a new thread using an anonymous inner class
    new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 1000; i > 0; i--) {
          System.out.println(i);
        }
      }
    }).start();
  }
}
