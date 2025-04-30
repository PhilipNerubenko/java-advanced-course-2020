package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class RunnableFactorial {
   /**
    * The result of the factorial calculation.
    */
   static int factorialResult;

   /**
    * The main method of the RunnableFactorial class.
    * It demonstrates the usage of a single-thread executor and a factorial calculation in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create a single-thread executor
       ExecutorService executor = Executors.newSingleThreadExecutor();

       // Create a task to calculate the factorial of 5
       Runnable task = new Factorial(5);

       // Submit the task to the executor
       Future future = executor.submit(task);

       // Shutdown the executor
       executor.shutdown();

       // Wait for the task to complete
       try {
           executor.awaitTermination(10, TimeUnit.SECONDS);
           // Print the result of the factorial calculation
           System.out.println("Factorial result: " + factorialResult);
           // Print the result of the future
           System.out.println(future.get());
           // Print whether the future is done
           System.out.println("Future is done? " + future.isDone());
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           e.printStackTrace();
       }
   }
}

class Factorial implements Runnable {
   /**
    * The number for which the factorial is calculated.
    */
   int number;

   /**
    * Constructor for the Factorial class.
    *
    * @param number The number for which the factorial is calculated
    */
   public Factorial(int number) {
       this.number = number;
   }

   /**
    * Calculates the factorial of the number and stores the result in the factorialResult variable of the RunnableFactorial class.
    */
   @Override
   public void run() {
       if (number < 0) {
           System.out.println("Factorial is not defined for negative numbers.");
           return;
       }
       int result = 1;
       for (int i = 1; i <= number; i++) {
           result *= i;
       }
       RunnableFactorial.factorialResult = result;
   }
}
