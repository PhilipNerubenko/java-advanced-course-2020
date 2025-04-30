package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFactorial {
   /**
    * The result of the factorial calculation.
    */
   static int factorialResult;

   /**
    * The main method of the CallableFactorial class.
    * It demonstrates the usage of a single-thread executor and a factorial calculation in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create a single-thread executor
       ExecutorService executor = Executors.newSingleThreadExecutor();

       // Create a task to calculate the factorial of 5
       Callable<Integer> task = new Factorial2(5);

       // Submit the task to the executor
       Future<Integer> future = executor.submit(task);

       try {
           // Print whether the future is done
           System.out.println("Future is done? " + future.isDone());
           // Print a message indicating that we want to get the result
           System.out.println("We want to get results...");
           // Get the result of the factorial calculation
           factorialResult = future.get();
           // Print a message indicating that we got the result
           System.out.println("Got the result");
           // Print whether the future is done
           System.out.println("Future is done? " + future.isDone());
           // Print the result of the factorial calculation
           System.out.println("Factorial result: " + factorialResult);
       } catch (InterruptedException e) {
           e.printStackTrace();
       } catch (ExecutionException e) {
           System.out.println("Exception occurred while calculating factorial: " + e.getCause());
       } finally {
           // Shutdown the executor
           executor.shutdown();
       }
   }
}


class Factorial2 implements Callable<Integer> {
   /**
    * The number for which the factorial is calculated.
    */
   int number;

   /**
    * Constructor for the Factorial2 class.
    *
    * @param number The number for which the factorial is calculated
    */
   public Factorial2(int number) {
       this.number = number;
   }

   /**
    * Calculates the factorial of the number and returns the result.
    *
    * @return The factorial of the number
    * @throws Exception if the number is negative
    */
   @Override
   public Integer call() throws Exception {
       if (number < 0) {
           throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
       }
       int result = 1;
       for (int i = 1; i <= number; i++) {
           result *= i;
           Thread.sleep(1000); // Simulate some time-consuming operation
       }
       return result;
   }
}
