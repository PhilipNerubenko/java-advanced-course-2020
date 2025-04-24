package multithreading;

public class ThreadStartVsRunExample implements Runnable {
   /**
    * Prints a message indicating the name of the current thread.
    */
   @Override
   public void run() {
       System.out.println("Method run. Thread name: " + Thread.currentThread().getName());
   }

   /**
    * The main method of the ThreadStartVsRunExample class.
    * It demonstrates the difference between calling run and start on a thread.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create a thread that runs the run method of the ThreadStartVsRunExample class
       Thread thread1 = new Thread(new ThreadStartVsRunExample());

       // Call the run method directly (not recommended)
       thread1.run(); // thread main not thread1

       // Start the thread (recommended)
       thread1.start();

       // Print a message indicating the name of the main thread
       System.out.println("Method main. Thread name: " + Thread.currentThread().getName());
   }
}
