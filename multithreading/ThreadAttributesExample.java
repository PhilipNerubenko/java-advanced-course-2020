package multithreading;

public class ThreadAttributesExample {
   /**
    * The main method of the ThreadAttributesExample class.
    * It demonstrates the usage of thread attributes in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create two custom threads
       CustomThread thread1 = new CustomThread();
       CustomThread thread2 = new CustomThread();

       // Set the name and priority of thread1
       thread1.setName("MyThread1");
       thread1.setPriority(9);
       thread1.setPriority(Thread.MIN_PRIORITY); // 1
       thread1.setPriority(Thread.NORM_PRIORITY); // 5
       thread1.setPriority(Thread.MAX_PRIORITY); // 10

       // Print the name and priority of thread1 and thread2
       System.out.println("Name of thread1: " + thread1.getName()
           + ", Priority of thread1: " + thread1.getPriority());
       System.out.println("Name of thread2: " + thread2.getName()
           + ", Priority of thread2: " + thread2.getPriority());
   }
}


class CustomThread extends Thread {
   /**
    * Prints a message indicating that the thread is running.
    */
   @Override
   public void run() {
       System.out.println("Thread 1 is running");
   }
}
