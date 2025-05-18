package multithreading.thread_safe;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {
  /**
   * The main method of the ArrayBlockingQueueExample class.
   * It demonstrates the usage of an array blocking queue in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create an array blocking queue with a capacity of 4
    ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(4);

    // Add 4 elements to the queue
    queue.add(1);
    queue.add(2);
    queue.add(3);
    queue.add(4);

    // Try to add a fifth element to the queue
    queue.offer(5); // This will return false as the queue is full

    // Print the elements of the queue
    System.out.println("ArrayBlockingQueue: " + queue);
  }
}
