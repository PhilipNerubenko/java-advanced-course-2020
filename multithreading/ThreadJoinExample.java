package multithreading;

public class ThreadJoinExample extends Thread {
   /**
    * Prints the numbers from 1 to 10 with a 1-second delay between each number.
    */
   @Override
   public void run() {
       for (int i = 1; i <= 10; i++) {
           try {
               Thread.sleep(1000); // Sleep for 1 second
           } catch (InterruptedException e) {
               System.out.println("Thread interrupted: " + e.getMessage());
           }
           System.out.println(Thread.currentThread().getName() + " - i = " + i);
       }
   }

   /**
    * The main method of the ThreadJoinExample class.
    * It demonstrates the usage of thread joining in Java.
    *
    * @param args Command line arguments (not used in this program)
    * @throws InterruptedException if a thread is interrupted while waiting for another thread to finish
    */
   public static void main(String[] args) throws InterruptedException {
       // Create two threads that run different tasks
       Thread thread1 = new Thread(new CountingRunnable());
       ThreadJoinExample thread2 = new ThreadJoinExample();

       // Start the threads
       thread1.start();
       thread2.start();
       System.out.println("Method main. Thread name: " + Thread.currentThread().getName());

       // Wait for the threads to finish
       thread1.join(); // Wait for thread1 to finish
       thread2.join(); // Wait for thread2 to finish

       // Print a message indicating the end of the main method
       System.out.println("Ends main method. Thread name: " + Thread.currentThread().getName());
   }
}


class CountingRunnable implements Runnable {
   /**
    * Prints the numbers from 1 to 10 with a 1-second delay between each number.
    */
   @Override
   public void run() {
       for (int i = 1; i <= 10; i++) {
           try {
               Thread.sleep(1000); // Sleep for 1 second
           } catch (InterruptedException e) {
               System.out.println("Thread interrupted: " + e.getMessage());
           }
           System.out.println(Thread.currentThread().getName() + " - i = " + i);
       }
   }
}
