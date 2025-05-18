package multithreading.thread_safe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionExample2 {
  /**
   * The main method of the SynchronizedCollectionExample2 class.
   * It demonstrates the usage of synchronized collections in Java.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Create an ArrayList and add 1000 elements to it
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      list.add(i);
    }

    // Create a synchronized list from the ArrayList
    List<Integer> synchList = Collections.synchronizedList(list);

    // Create two runnables that operate on the synchronized list
    Runnable runnable =
        () -> {synchronized (synchList){Iterator<Integer> iterator = synchList.iterator();
    while (iterator.hasNext()) {
      Integer number = iterator.next();
      System.out.println("Number: " + number);
    }
  }
};
Runnable runnable2 = () -> {
  synchList.remove(10);
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

// Print the elements of the synchronized list
System.out.println("List elements: " + synchList);
}
}
