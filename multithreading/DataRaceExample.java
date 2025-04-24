package multithreading;

public class DataRaceExample {
   /**
    * The main method of the DataRaceExample class.
    * It demonstrates the usage of shared resources and data races in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create a shared counter
       SharedCounter counter = new SharedCounter();

       // Create three threads that increment the counter
       Thread thread1 = new Thread(counter);
       Thread thread2 = new Thread(counter);
       Thread thread3 = new Thread(counter);

       // Start the threads
       thread1.start();
       thread2.start();
       thread3.start();
   }
}


class Counter {
   /**
    * A static counter variable.
    */
   static int count = 0;
}


class SharedCounter implements Runnable {
   /**
    * Increments the counter variable in the Counter class.
    */
   public void increment() {
       Counter.count++;
       System.out.print(Counter.count + " ");
   }

   /**
    * Increments the counter variable in the Counter class three times.
    */
   @Override
   public void run() {
       for (int i = 0; i < 3; i++) {
           increment();
       }
   }
}
