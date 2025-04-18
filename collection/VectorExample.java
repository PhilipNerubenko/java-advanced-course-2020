package collection;

import java.util.Vector;

/**
* Class VectorExample demonstrates the usage of Vector in Java.
*/
public class VectorExample {
   public static void main(String[] args) {
       /*  not recommended to use Vector in new code
       * as it is synchronized and has performance overhead
       */
       Vector<String> vector = new Vector<>();
       vector.add("Apple");
       vector.add("Banana");
       vector.add("Cherry");

       System.out.println(vector);
       System.out.println("First element: " + vector.firstElement());
       System.out.println("Last element: " + vector.lastElement());
       System.out.println("Element at index 1: " + vector.get(1));
       System.out.println("Is vector empty? " + vector.isEmpty());
       System.out.println("Index of 'Banana': " + vector.indexOf("Banana"));
       System.out.println("Removing 'Banana': " + vector.remove("Banana"));
       System.out.println("After removal: " + vector);
       System.out.println("Size: " + vector.size());
       System.out.println("Capacity: " + vector.capacity());
       System.out.println("Is 'Banana' still in vector? " + vector.contains("Banana"));
       
       System.out.println("Iterating through vector:");
       for (String fruit : vector) {
           System.out.println(fruit);
       }
       
       System.out.println("Size before clearing: " + vector.size());
       
       vector.clear();
       
       System.out.println("After clearing: " + vector);
       System.out.println("Is vector empty? " + vector.isEmpty());
   }
}

