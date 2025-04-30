package multithreading.thread_safe;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
  /**
   * The main method of the ConcurrentHashMapExample class.
   * It demonstrates the usage of a concurrent hash map in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create a concurrent hash map and add 5 key-value pairs to it
    ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
    map.put(1, "One");
    map.put(2, "Two");
    map.put(3, "Three");
    map.put(4, "Four");
    map.put(5, "Five");
    // map.put(null, null); // Exception not allowed null
    System.out.println("HashMap: " + map);

    // Create a runnable that iterates over the keys of the map and prints the key-value pairs
    Runnable runnable = () -> {
      Iterator<Integer> iterator = map.keySet().iterator();
      while (iterator.hasNext()) {
        try {
          Thread.sleep(100);
          Integer key = iterator.next();
          String value = map.get(key);
          System.out.println("Key: " + key + ", Value: " + value);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    };

    // Create a runnable that adds a key-value pair to the map after a delay
    Runnable runnable2 = () -> {
      try {
        Thread.sleep(300);
        map.put(6, "Six");
        System.out.println("Added key 6");
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

    // Print the final state of the map
    System.out.println("Final HashMap: " + map);
  }
}
