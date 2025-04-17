package collection;

import java.util.*;

/**
* Class ArrayListMethods5 demonstrates the usage of ArrayList methods in Java.
*/
public class ArrayListMethods5 {
   public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
       list.add("Apple");
       list.add("Banana");
       list.add("Banana");
       list.add("Cherry");
       list.add(1, "Orange");
       
       System.out.println("List after adding elements: " + list);
       
       ArrayList<String> list2 = new ArrayList<>();
       list2.add("Banana");
       list2.add("Apple");
       list2.add("Cherry");
       list2.add("Mango");

       // Removing all elements from list2
       // list.removeAll(list2);
       // System.out.println("List after removing all elements from list2: " + list);
       
       // Retaining all elements from list2
       // list.retainAll(list2);
       // System.out.println("List after retaining all elements from list2: " + list);
       boolean result = list.containsAll(list2);
       
       System.out.println("List contains all elements from list2: " + result);

       List<String> subList = list.subList(1, 3);
       
       System.out.println("Sublist from index 1 to 3: " + subList);
       
       subList.add("Kiwi");
       
       System.out.println("List after modifying sublist: " + list);
       System.out.println("Sublist after modification: " + subList);
       
       list.add("Grapes");
       
       System.out.println("List after adding Grapes: " + list);
       // java.util.ConcurrentModificationException
       // System.out.println("Sublist after adding Grapes: " + subList);

       Object[] array = list.toArray();
       System.out.println("Array from list: " + Arrays.toString(array));
       
       String[] stringArray = list.toArray(new String[0]);
       System.out.println("String array from list: " + Arrays.toString(stringArray));

       // version jdk 11, not allowed modify and value null
       List<Integer> list3 = List.of(1, 2, 3, 4, 5);
       System.out.println("List3: " + list3);

       List<String> list4 = List.copyOf(list);
       System.out.println("List4: " + list4);
   }
}

