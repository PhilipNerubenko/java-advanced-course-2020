package multithreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
  /**
   * A count down latch with an initial count of 3.
   */
  static CountDownLatch latch = new CountDownLatch(3);

  /**
   * Simulates the market staff arriving at the market.
   *
   * @throws InterruptedException if a thread is interrupted while sleeping
   */
  private static void marketStaffIsOnPlace() throws InterruptedException {
    Thread.sleep(2000);
    System.out.println("Market staff is on place");
    latch.countDown();
    System.out.println("CountDownLatch count: " + latch.getCount());
  }

  /**
   * Simulates everything being ready at the market.
   *
   * @throws InterruptedException if a thread is interrupted while sleeping
   */
  private static void everythingIsReady() throws InterruptedException {
    Thread.sleep(3000);
    System.out.println("Everything is ready");
    latch.countDown();
    System.out.println("CountDownLatch count: " + latch.getCount());
  }

  /**
   * Simulates the market opening.
   *
   * @throws InterruptedException if a thread is interrupted while sleeping
   */
  private static void marketIsOpen() throws InterruptedException {
    Thread.sleep(4000);
    System.out.println("Market is open");
    latch.countDown();
    System.out.println("CountDownLatch count: " + latch.getCount());
  }

  /**
   * The main method of the CountDownLatchExample class.
   * It demonstrates the usage of a count down latch in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create five friends that use the count down latch
    Friend friend1 = new Friend("Friend 1", latch);
    Friend friend2 = new Friend("Friend 2", latch);
    Friend friend3 = new Friend("Friend 3", latch);
    Friend friend4 = new Friend("Friend 4", latch);
    Friend friend5 = new Friend("Friend 5", latch);

    // Simulate the market staff arriving, everything being ready, and the market opening
    try {
      marketStaffIsOnPlace();
      everythingIsReady();
      marketIsOpen();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print a message indicating that all friends can go to the market
    System.out.println("All friends can go to the market now");
  }
}

class Friend extends Thread {
  /**
   * The name of the friend.
   */
  private String name;

  /**
   * The count down latch used by the friend.
   */
  private CountDownLatch latch;

  /**
   * Constructor for the Friend class.
   *
   * @param name The name of the friend
   * @param latch The count down latch used by the friend
   */
  public Friend(String name, CountDownLatch latch) {
    this.name = name;
    this.latch = latch;
    this.start();
  }

  /**
   * Waits for the count down latch to reach zero and then prints a message indicating that the
   * friend is going to the market.
   */
  @Override
  public void run() {
    try {
      System.out.println(name + " is waiting for the market to open");
      latch.await();
      System.out.println(name + " is going to the market");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
