package multithreading;

public class ClassLockExample {
   /**
    * A static counter variable.
    */
   static int counter = 0;

   /**
    * Increments the counter variable in a synchronized block using the class object as a lock.
    */
   public static void increment() {
       // Synchronized block using class object as lock
       synchronized (ClassLockExample.class) {
           counter++;
       }
   }

   /**
    * The main method of the ClassLockExample class.
    * It demonstrates the usage of class locks in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create two threads that increment the counter
       Thread thread1 = new Thread(new CounterIncrementer());
       Thread thread2 = new Thread(new CounterIncrementer());

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

       // Print the final value of the counter
       System.out.println("Counter: " + counter);
   }
}


class CounterIncrementer implements Runnable {
   /**
    * Increments the counter variable in the ClassLockExample class 1000 times.
    */
   @Override
   public void run() {
       for (int i = 0; i < 1000; i++) {
           ClassLockExample.increment();
       }
   }
}
