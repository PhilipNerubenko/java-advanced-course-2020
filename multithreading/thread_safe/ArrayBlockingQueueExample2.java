package multithreading.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample2 {
  /**
   * The main method of the ArrayBlockingQueueExample2 class.
   * It demonstrates the usage of an array blocking queue in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create an array blocking queue with a capacity of 4
    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

    // Create a producer thread that puts items into the queue
    new Thread(() -> {
      int i = 0;
      while (true) {
        try {
          queue.put(++i);
          System.out.println("Produced: " + i + " " + queue);
          Thread.sleep(1000); // Simulate time taken to produce an item
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          break;
        }
      }
    }).start();

    // Create a consumer thread that takes items from the queue
    new Thread(() -> {
      while (true) {
        try {
          Integer item = queue.take();
          System.out.println("Consumed: " + item + " " + queue);
          Thread.sleep(3000); // Simulate time taken to consume an item
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          break;
        }
      }
    }).start();
  }
}
