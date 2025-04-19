package collection;

import java.util.*;

/**
 * Class ArrayListMethods4 demonstrates the usage of ArrayList methods in Java.
 */
public class ArrayListMethods4 {
  public static void main(String[] args) {
    StringBuilder sb1 = new StringBuilder("A");
    StringBuilder sb2 = new StringBuilder("B");
    StringBuilder sb3 = new StringBuilder("C");
    StringBuilder sb4 = new StringBuilder("D");

    StringBuilder[] arrayBuilders = {sb1, sb2, sb3, sb4};

    List<StringBuilder> list = new ArrayList<>(Arrays.asList(arrayBuilders));

    System.out.println(list);

    arrayBuilders[0].append("X");

    System.out.println(list);
  }
}
