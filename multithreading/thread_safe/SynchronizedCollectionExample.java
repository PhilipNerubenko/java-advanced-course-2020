package multithreading.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollectionExample {
  /**
   * The main method of the SynchronizedCollectionExample class.
   * It demonstrates the usage of synchronized collections in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create an ArrayList and add 10 elements to it
    ArrayList<Integer> list = new ArrayList<>();
    // ArrayList<Integer> target = new ArrayList<>();
    List<Integer> target = Collections.synchronizedList(new ArrayList<>());

    for (int i = 0; i < 10; i++) {
      list.add(i);
    }

    // Create a runnable that adds all elements of the list to the target list
    Runnable runnable = () -> target.addAll(list);

    // Create two threads that run the runnable
    Thread thread1 = new Thread(runnable);
    Thread thread2 = new Thread(runnable);

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

    // Print the elements of the target list
    System.out.println("Target list : " + target);
  }
}
