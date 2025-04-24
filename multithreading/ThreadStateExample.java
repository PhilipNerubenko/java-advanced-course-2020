package multithreading;

public class ThreadStateExample {
   /**
    * The main method of the ThreadStateExample class.
    * It demonstrates the usage of thread states in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Print a message indicating the start of the main thread
       System.out.println("Main thread started: " + Thread.currentThread().getName());

       // Create a thread that runs the WorkerTask
       Thread workerThread = new Thread(new WorkerTask());

       // Print the state of the worker thread (NEW)
       System.out.println(workerThread.getState());

       // Start the worker thread
       workerThread.start();

       // Print the state of the worker thread (RUNNABLE)
       System.out.println(workerThread.getState());

       // Wait for the worker thread to finish
       try {
           //workerThread.join(1500); // Wait for the worker thread to finish, but only for 1500ms
           workerThread.join(); // Wait indefinitely for the worker thread to finish
       } catch (InterruptedException e) {
           System.out.println("Main thread interrupted: " + e.getMessage());
       }

       // Print the state of the worker thread (TERMINATED)
       System.out.println(workerThread.getState());

       // Print a message indicating the end of the main thread
       System.out.println("Main thread finished: " + Thread.currentThread().getName());
   }
}


class WorkerTask implements Runnable {
   /**
    * Simulates work by printing a message, sleeping for 2 seconds, and then printing another message.
    */
   @Override
   public void run() {
       System.out.println("Work in progress...");
       try {
           Thread.sleep(2000); // Simulate work with sleep
       } catch (InterruptedException e) {
           System.out.println("Worker interrupted: " + e.getMessage());
       }
       System.out.println("Work completed.");
   }
}
