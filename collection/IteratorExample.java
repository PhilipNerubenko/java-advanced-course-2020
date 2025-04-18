package collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
* Class IteratorExample demonstrates the usage of Iterator in Java.
*/
public class IteratorExample {
   public static void main(String[] args) {
       ArrayList<String> list = new ArrayList<>();
       list.add("Apple");
       list.add("Banana");
       list.add("Banana");
       list.add("Cherry");
       list.add("Orange");

       Iterator<String> iterator = list.iterator();
       while (iterator.hasNext()) {
           iterator.next(); // without this line, exception will be thrown IllegalStateException
           iterator.remove(); // This will remove the last element returned by next()
       }
       // Print the list after removing elements
       System.out.println("List after removing elements: " + list);
   }
}
