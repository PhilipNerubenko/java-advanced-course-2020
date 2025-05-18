package multithreading;

public class SharedLockExample {
  /**
   * A shared lock object.
   */
  static final Object lock = new Object();

  /**
   * Simulates a mobile call.
   */
  void mobileCall() {
    synchronized (lock) {
      System.out.println("Mobile call starts");
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Mobile call ends");
    }
  }

  /**
   * Simulates a Skype call.
   */
  void skypeCall() {
    synchronized (lock) {
      System.out.println("Skype call starts");
      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Skype call ends");
    }
  }

  /**
   * Simulates a WhatsApp call.
   */
  void whatsappCall() {
    synchronized (lock) {
      System.out.println("WhatsApp call starts");
      try {
        Thread.sleep(7000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("WhatsApp call ends");
    }
  }

  /**
   * The main method of the SharedLockExample class.
   * It demonstrates the usage of shared locks in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create three threads that perform different tasks
    Thread mobileThread = new Thread(new MobileCallTask());
    Thread skypeThread = new Thread(new SkypeCallTask());
    Thread whatsappThread = new Thread(new WhatsAppCallTask());

    // Start the threads
    mobileThread.start();
    skypeThread.start();
    whatsappThread.start();
  }
}

class MobileCallTask implements Runnable {
  /**
   * Simulates a mobile call by calling the mobileCall method of the SharedLockExample class.
   */
  @Override
  public void run() {
    new SharedLockExample().mobileCall();
  }
}

class SkypeCallTask implements Runnable {
  /**
   * Simulates a Skype call by calling the skypeCall method of the SharedLockExample class.
   */
  @Override
  public void run() {
    new SharedLockExample().skypeCall();
  }
}

class WhatsAppCallTask implements Runnable {
  /**
   * Simulates a WhatsApp call by calling the whatsappCall method of the SharedLockExample class.
   */
  @Override
  public void run() {
    new SharedLockExample().whatsappCall();
  }
}
