package collection.map_interface;

import java.util.LinkedHashMap;

/**
 * Class LinkedHashMapExample demonstrates the usage of LinkedHashMap in Java.
 */
public class LinkedHashMapExample {
  public static void main(String[] args) {
    LinkedHashMap<Double, Student> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);

    Student student1 = new Student("Zaur", "Tregulov", 3);
    Student student2 = new Student("Jane", "Doe", 2);
    Student student3 = new Student("Jack", "Smith", 3);
    Student student4 = new Student("Igor", "Sidorov", 4);

    linkedHashMap.put(3.5, student1);
    linkedHashMap.put(2.5, student2);
    linkedHashMap.put(3.0, student3);
    linkedHashMap.put(4.0, student4);

    System.out.println("Initial map:" + linkedHashMap);

    System.out.println("Value for key 3.0:" + linkedHashMap.get(3.0));
    System.out.println("Value for key 2.5:" + linkedHashMap.get(2.5));

    System.out.println("Map after getting:" + linkedHashMap);
  }
}
