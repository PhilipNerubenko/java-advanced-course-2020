package collection;

import java.util.ArrayList;
/**
* Class ArrayListEx1 demonstrates the usage of ArrayList in Java.
*/
public class ArrayListEx1 {
   public static void main(String[] args) {
       // first creation option
       ArrayList<String> list = new ArrayList<String>();

       // second creation option
       // ArrayList<String> list = new ArrayList<>();

       // third creation option
       // ArrayList<String> list = new ArrayList<>(10);

       // fourth creation option
       // ArrayList<String> list = new ArrayList<>(list);

       // fifth creation option
       // ArrayList<String> list = new ArrayList<>(Arrays.asList("Java", "Python", "C++"));
       
       // sixth creation option
       // List<String> list = new ArrayList<>();

       list.add("Java");
       list.add("Python");
       list.add("C++");
       System.out.println("ArrayList: " + list);
   }
}
