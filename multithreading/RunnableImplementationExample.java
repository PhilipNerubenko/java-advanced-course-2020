package multithreading;

public class RunnableImplementationExample implements Runnable {
   /**
    * The main method of the RunnableImplementationExample class.
    * It demonstrates the usage of Runnable implementation in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create three threads that run different tasks
       Thread thread1 = new Thread(new CountUpRunnable());
       Thread thread2 = new Thread(new CountDownRunnable());
       Thread thread3 = new Thread(new RunnableImplementationExample());

       // Start the threads
       thread1.start();
       thread2.start();
       thread3.start();

       // The main thread will also run
       for (int i = 1000; i > 0; i--) {
           System.out.println(i);
       }
   }

   /**
    * Prints the numbers from 1 to 999.
    */
   @Override
   public void run() {
       for (int i = 1; i < 1000; i++) {
           System.out.println(i);
       }
   }
}


class CountUpRunnable implements Runnable {
   /**
    * Prints the numbers from 1 to 999.
    */
   @Override
   public void run() {
       for (int i = 1; i < 1000; i++) {
           System.out.println(i);
       }
   }
}


class CountDownRunnable implements Runnable {
   /**
    * Prints the numbers from 1000 to 1.
    */
   @Override
   public void run() {
       for (int i = 1000; i > 0; i--) {
           System.out.println(i);
       }
   }
}
