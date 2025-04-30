package multithreading.thread_safe;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
  /**
   * The main method of the CopyOnWriteArrayListExample class.
   * It demonstrates the usage of a copy-on-write array list in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a copy-on-write array list and add 5 elements to it
    CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    list.add("One");
    list.add("Two");
    list.add("Three");
    list.add("Four");
    list.add("Five");

    // Print the elements of the array list
    System.out.println("ArrayList: " + list);

    // Create a runnable that iterates over the array list
    Runnable runnable = () -> {
      Iterator<String> iterator = list.iterator();
      while (iterator.hasNext()) {
        try {
          Thread.sleep(100);
          String value = iterator.next();
          System.out.println("Value: " + value);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    // Create a runnable that removes an element and adds a new element to the array list
    Runnable runnable2 = () -> {
      try {
        Thread.sleep(200);
        System.out.println("Removing element: Five");
        list.remove(4);
        System.out.println("Element removed");
        System.out.println("Add new element: Six");
        list.add("Six");
        System.out.println("Element added");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    };

    // Create two threads that run the runnables
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable2);

    // Start the threads
    thread1.start();
    thread2.start();

    // Wait for the threads to finish
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print the final elements of the array list
    System.out.println("Final ArrayList: " + list);
  }
}
