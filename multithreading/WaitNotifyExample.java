package multithreading;

public class WaitNotifyExample {
  /**
   * The main method of the WaitNotifyExample class.
   * It demonstrates the usage of wait and notify in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a market
    Market market = new Market();

    // Create a producer and a consumer that use the market
    Producer producer = new Producer(market);
    Consumer consumer = new Consumer(market);

    // Create threads for the producer and consumer
    Thread producerThread = new Thread(producer, "Producer");
    Thread consumerThread = new Thread(consumer, "Consumer");

    // Start the threads
    producerThread.start();
    consumerThread.start();

    // Wait for the threads to finish
    try {
      producerThread.join();
      consumerThread.join();
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}

class Market {
  /**
   * The number of breads in the market.
   */
  private int breadCount = 0;

  /**
   * A lock used to synchronize the methods.
   */
  private final Object lock = new Object();

  /**
   * Takes a bread from the market.
   */
  public void getBread() {
    synchronized (lock) {
      while (breadCount < 1) {
        try {
          System.out.println("Waiting for bread...");
          lock.wait(1000); // Wait for 1 second
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      breadCount--;
      System.out.println("Bread taken. Remaining: " + breadCount);
      lock.notify();
    }
  }

  /**
   * Adds a bread to the market.
   */
  public void putBread() {
    synchronized (lock) {
      while (breadCount >= 5) {
        try {
          System.out.println("Waiting for bread to be taken...");
          lock.wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      }
      breadCount++;
      System.out.println("Bread added. Total: " + breadCount);
      lock.notify();
    }
  }
}

class Producer implements Runnable {
  /**
   * The market used by the producer.
   */
  private final Market market;

  /**
   * Constructor for the Producer class.
   *
   * @param market The market used by the producer
   */
  public Producer(Market market) {
    this.market = market;
  }

  /**
   * Adds bread to the market 10 times with a 1-second delay between each addition.
   */
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      market.putBread();
      try {
        Thread.sleep(1000); // Simulate time taken to produce bread
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}

class Consumer implements Runnable {
  /**
   * The market used by the consumer.
   */
  private final Market market;

  /**
   * Constructor for the Consumer class.
   *
   * @param market The market used by the consumer
   */
  public Consumer(Market market) {
    this.market = market;
  }

  /**
   * Takes bread from the market 10 times with a 2-second delay between each take.
   */
  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      market.getBread();
      try {
        Thread.sleep(2000); // Simulate time taken to consume bread
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}
