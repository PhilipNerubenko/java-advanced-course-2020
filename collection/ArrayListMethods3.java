package collection;

import java.util.ArrayList;

/**
* Class ArrayListMethods3 demonstrates the usage of ArrayList methods in Java.
*/
public class ArrayListMethods3 {
   public static void main(String[] args) {
       ArrayList<String> list = new ArrayList<>();
       list.add("Apple");
       list.add("Banana");
       list.add("Banana");
       list.add("Cherry");
       list.add(1, "Orange");

       System.out.println("List after adding elements: " + list);

       ArrayList<String> list2 = new ArrayList<>();
       list2.add("!!!");
       list2.add("???");

       list.addAll(list2);
       // list.addAll(1, list2); // Uncommenting this will add elements at index 1

       System.out.println("List after adding all elements from list2: " + list);

       System.out.println("Index of 'Banana': " + list.indexOf("Banana"));
       System.out.println("Last index of 'Banana': " + list.lastIndexOf("Banana"));

       System.out.println("Size of the list: " + list.size());
       System.out.println("Is the list empty? " + list.isEmpty());
       System.out.println("Does the list contain 'Apple'? " + list.contains("Apple"));
       System.out.println("Methods toString(): " + list.toString());
       System.out.println("List before clearing: " + list);
       
       list.clear();
       
       System.out.println("List after clearing: " + list);
   }
}

