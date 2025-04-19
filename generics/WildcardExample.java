package generics;

import java.util.*;

/**
 * Class WildcardExample demonstrates the usage of wildcards in Java.
 */
public class WildcardExample {
  public static void main(String[] args) {
    /* List<Number> list = new ArrayList<Integer>();
     * List<object> list1 = new ArrayList<Integer>();
     */
    List<?> list = new ArrayList<String>();
    list.add("hello"); // compile error

    // bounded wildcard
    List<? extends Number> list30 = new ArrayList<Integer>();
    List<? super Number> list31 = new ArrayList<Number>();
    List<? super Number> list32 = new ArrayList<Object>();

    List<Double> list1 = new ArrayList<>();
    list1.add(1.0);
    list1.add(2.0);
    list1.add(3.0);
    showListInfo(list1);

    List<String> list2 = new ArrayList<>();
    list2.add("hello");
    list2.add("world");
    list2.add("java");
    showListInfo(list2);

    ArrayList<Double> list3 = new ArrayList<>();
    list3.add(1.0);
    list3.add(2.0);
    list3.add(3.0);
    System.out.println("Sum of list3: " + sum(list3));

    ArrayList<Integer> list4 = new ArrayList<>();
    list4.add(1);
    list4.add(2);
    list4.add(3);
    System.out.println("Sum of list4: " + sum(list4));
  }

  /**
   * Method showListInfo prints the size and elements of a list.
   * @param list a list of any type.
   */
  static void showListInfo(List<?> list) {
    System.out.println("list contsains: " + list.size() + " elements");
    System.out.println("Elements in list: " + list.toString());
  }

  /**
   * Method sum calculates the sum of a list of numbers.
   * @param list a list of numbers.
   * @return the sum of the numbers in the list.
   */
  public static double sum(ArrayList<? extends Number> list) {
    double sum = 0;
    for (Number number : list) {
      sum += number.doubleValue();
    }
    return sum;
  }
}
