package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SumNumbersCallable {
   /**
    * The value to be summed.
    */
   private static long value = 1_000_000_000L;

   /**
    * The sum of the numbers.
    */
   private static long sum = 0;

   /**
    * The main method of the SumNumbersCallable class.
    * It demonstrates the usage of a fixed thread pool and a partial sum calculation in Java.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Create a fixed thread pool with 10 threads
       ExecutorService executorService = Executors.newFixedThreadPool(10);

       // Create a list to store the future results
       List<Future<Long>> futureResults = new ArrayList<>();

       // Calculate the value divided by 10
       long valueDivided = value / 10;

       // Submit 10 tasks to the executor service
       for (int i = 0; i < 10; i++) {
           long from = valueDivided * i + 1;
           long to = valueDivided * (i + 1);
           PartialSumTask task = new PartialSumTask(from, to);
           Future<Long> futurePartSum = executorService.submit(task);
           futureResults.add(futurePartSum);
       }

       // Get the results of the tasks and add them to the sum
       for (Future<Long> future : futureResults) {
           try {
               sum += future.get();
           } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
           }
       }

       // Shutdown the executor service
       executorService.shutdown();

       // Print the total sum
       System.out.println("Total sum = " + sum);
   }
}

class PartialSumTask implements Callable<Long> {
   /**
    * The starting number of the range.
    */
   long from;

   /**
    * The ending number of the range.
    */
   long to;

   /**
    * The local sum of the range.
    */
   long localSum;

   /**
    * Constructor for the PartialSumTask class.
    *
    * @param from The starting number of the range
    * @param to The ending number of the range
    */
   public PartialSumTask(long from, long to) {
       this.from = from;
       this.to = to;
       this.localSum = 0;
   }

   /**
    * Calculates the sum of the numbers in the range and returns the result.
    *
    * @return The sum of the numbers in the range
    */
   @Override
   public Long call() {
       for (long i = from; i <= to; i++) {
           localSum += i;
       }

       // Print the sum of the range
       System.out.println("Sum from " + from + " to " + to + " = " + localSum);

       return localSum;
   }
}
