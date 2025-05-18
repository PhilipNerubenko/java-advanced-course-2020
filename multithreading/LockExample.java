package multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
  /**
   * The main method of the LockExample class.
   * It demonstrates the usage of locks in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a call object
    Call call = new Call();

    // Create three threads that perform different tasks
    Thread mobileThread = new Thread(() -> call.mobileCall());
    Thread skypeThread = new Thread(() -> call.skypeCall());
    Thread whatsappThread = new Thread(() -> call.whatsappCall());

    // Start the threads
    mobileThread.start();
    skypeThread.start();
    whatsappThread.start();

    // Wait for the threads to finish
    try {
      mobileThread.join();
      skypeThread.join();
      whatsappThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

class Call {
  /**
   * A lock used to synchronize the methods.
   */
  private Lock lock = new ReentrantLock();

  /**
   * Simulates a mobile call.
   */
  void mobileCall() {
    lock.lock();
    try {
      System.out.println("Mobile call started");
      Thread.sleep(3000);
      System.out.println("Mobile call ended");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  /**
   * Simulates a Skype call.
   */
  void skypeCall() {
    lock.lock();
    try {
      System.out.println("Skype call started");
      Thread.sleep(5000);
      System.out.println("Skype call ended");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }

  /**
   * Simulates a WhatsApp call.
   */
  void whatsappCall() {
    lock.lock();
    try {
      System.out.println("WhatsApp call started");
      Thread.sleep(7000);
      System.out.println("WhatsApp call ended");
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      lock.unlock();
    }
  }
}
