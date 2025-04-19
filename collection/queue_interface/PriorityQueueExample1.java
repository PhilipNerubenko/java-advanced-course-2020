package collection.queue_interface;

import java.util.PriorityQueue;

/**
 * Class PriorityQueueExample1 demonstrates the usage of PriorityQueue in Java.
 */
public class PriorityQueueExample1 {
  public static void main(String[] args) {
    PriorityQueue<Integer> queue = new PriorityQueue<>();

    // Add elements to the PriorityQueue
    queue.offer(4);
    queue.offer(1);
    queue.offer(7);
    queue.offer(10);
    queue.offer(8);

    // Print the PriorityQueue not sorting when displayed on screen
    System.out.println("PriorityQueue: " + queue);

    // Peek at the head of the queue
    System.out.println("Head of the queue: " + queue.peek());

    // Remove the head of the queue
    System.out.println("Removed head: " + queue.poll());

    // Print the PriorityQueue after removal, not sorting when displayed on screen
    System.out.println("PriorityQueue after removal: " + queue);
  }
}
