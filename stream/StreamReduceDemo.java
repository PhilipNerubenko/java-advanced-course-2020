package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamReduceDemo {
   /**
    * The main method of the StreamReduceDemo class.
    * It demonstrates the usage of Java Streams and the reduce operation.
    *
    * @param args Command line arguments (not used in this program)
    */
   public static void main(String[] args) {
       // Initialize a list of integers
       List<Integer> list = List.of(5, 8, 2, 4, 3);

       // Use reduce to calculate the product of the elements in the list
       int result = list.stream().reduce((accumulator, element) ->
           accumulator * element).get();

       // Print the result
       System.out.println(result);

       System.out.println();

       // Use reduce with an initial value to calculate the product of the elements in the list
       int result2 = list.stream().reduce(1, (accumulator, element) ->
           accumulator * element);

       // Print the result
       System.out.println(result2);

       System.out.println();

       // Initialize a list of strings
       List<String> list3 = List.of("Java", "C++", "Javascript", "Python");

       // Use reduce to concatenate the elements in the list
       String result3 = list3.stream().reduce((accumulator, element) ->
           accumulator + " " + element).get();

       // Print the result
       System.out.println(result3);

       System.out.println();

       // Initialize an empty list of integers
       List<Integer> list2 = new ArrayList<>();

       // Use reduce to calculate the product of the elements in the list
       Optional<Integer> resultOptional = list2.stream().reduce((accumulator, element) ->
           accumulator * element);

       // Print the result if it exists, otherwise print "No result"
       if (resultOptional.isPresent()) {
           System.out.println(resultOptional.get());
       } else {
           System.out.println("No result");
       }
   }
}

