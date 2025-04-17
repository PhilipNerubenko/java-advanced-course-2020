package generics;

import java.util.ArrayList;

/**
* Class ParameterizedMethod demonstrates the usage of parameterized methods.
*/
public class ParameterizedMethod {
   public static void main(String[] args) {
       ArrayList<Integer> list = new ArrayList<>();
       list.add(1);
       list.add(2);
       list.add(3);
       int a = GenMethod.getSecondElement(list);
       System.out.println("Second element: " + a);
       ArrayList<String> list2 = new ArrayList<>();
       list2.add("Hello");
       list2.add("World");
       list2.add("Java");
       String b = GenMethod.getSecondElement(list2);
       System.out.println("Second element: " + b);
   }
}


/**
* Class GenMethod contains a parameterized method.
*/
class GenMethod {
   /**
    * Method getSecondElement retrieves the second element from a list.
    * @param list a list of any type.
    * @return the second element of the list.
    */
   public static <T> T getSecondElement(ArrayList<T> list) {
       return list.get(1);
   }
}
