package collection.queue_interface;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class LinkedListExample demonstrates the usage of LinkedList in Java.
 */
public class LinkedListExample {
  public static void main(String[] args) {
    // Create a LinkedList
    Queue<String> list = new LinkedList<>();

    // Add elements to the LinkedList using offer()
    list.offer("A");
    list.offer("B");

    // Add more elements to the LinkedList
    list.add("C");
    list.add("D");
    list.add("E");

    // Print the LinkedList
    System.out.println("LinkedList: " + list);

    // Remove elements from the LinkedList using poll()
    String removedElement = list.poll(); // Removes the head of the LinkedList
    String peekedElement = list.peek(); // Retrieves the head of the LinkedList without removing it
    System.out.println("Removed element using poll(): " + removedElement);
    System.out.println("Peeked element using peek(): " + peekedElement);
    System.out.println("LinkedList after removal: " + list);

    // Remove elements from the LinkedList using remove()
    String removedElement2 = list.remove(); // Removes the next head of the LinkedList
    String peekedElement2 = list.peek(); // Retrieves the head of the LinkedList without removing it
    System.out.println("Removed element using remove(): " + removedElement2);
    System.out.println("Removed element using peek(): " + peekedElement2);
    System.out.println("LinkedList after removal: " + list);
  }
}
