package collection.queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Class ArrayDequeExample demonstrates the usage of ArrayDeque in Java.
 */
public class ArrayDequeExample {
  public static void main(String[] args) {
    Deque<Integer> deque = new ArrayDeque<>();

    // Add elements to the deque
    deque.addFirst(3);
    deque.addFirst(5);
    deque.addLast(7);
    deque.offerFirst(1);
    deque.offerLast(8);

    // Print the deque
    System.out.println("Deque: " + deque);

    // Remove elements from the deque
    int firstElement = deque.removeFirst();
    int lastElement = deque.pollLast();
    System.out.println("Removed first element: " + firstElement);
    System.out.println("Removed last element: " + lastElement);

    // Peek at the first and last elements
    int peekFirst = deque.peekFirst();
    int peekLast = deque.getLast();
    System.out.println("First element after removal: " + peekFirst);
    System.out.println("Last element after removal: " + peekLast);
  }
}
