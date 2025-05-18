package collection.map_interface;

import java.util.TreeMap;

/**
 * Class TreeMapExample demonstrates the usage of TreeMap in Java.
 */
public class TreeMapExample {
  public static void main(String[] args) {
    // binary search red-black tree
    TreeMap<Double, Student> treeMap = new TreeMap<>();
    TreeMap<Student, Double> treeMap2 =
        new TreeMap<>(); // TreeMap with Student as key and Double as value

    Student student1 = new Student("Zaur", "Tregulov", 3);
    Student student2 = new Student("Jane", "Doe", 2);
    Student student3 = new Student("Jack", "Smith", 3);
    Student student4 = new Student("Igor", "Sidorov", 4);
    Student student5 = new Student("John", "Doe", 1);
    Student student6 = new Student("Alice", "Johnson", 2);
    Student student7 = new Student("Bob", "Brown", 3);
    Student student8 = new Student("Petr", "Brown", 3);

    treeMap.put(5.8, student1);
    treeMap.put(4.0, student2);
    treeMap.put(2.8, student3);
    treeMap.put(3.5, student4);
    treeMap.put(4.5, student5);
    treeMap.put(3.0, student6);
    treeMap.put(4.2, student7);
    treeMap.put(4.2, student8); // This will replace the previous entry with the same key

    treeMap2.put(student1, 3.5);
    treeMap2.put(student2, 4.0);
    treeMap2.put(student3, 2.8);
    treeMap2.put(student4, 3.5);
    treeMap2.put(student5, 4.0);
    treeMap2.put(student6, 2.8);
    treeMap2.put(student7, 3.5);
    treeMap2.put(student8, 3.5); // This will replace the previous entry with the same key

    System.out.println("Initial TreeMap2: " + treeMap2);
    System.out.println("TreeMap2 get: "
        + treeMap2.get(student1)); // Retrieves the value associated with the key student1
    System.out.println("TreeMap2 contains key student1: "
        + treeMap2.containsKey(student1)); // Checks if the key student1 exists
    System.out.println("TreeMap2 contains value 3.5: "
        + treeMap2.containsValue(3.5)); // Checks if the value 3.5 exists
    System.out.println("TreeMap2 size: "
        + treeMap2.size()); // Returns the number of key-value pairs in the TreeMap
    System.out.println(
        "TreeMap2 is empty: " + treeMap2.isEmpty()); // Checks if the TreeMap is empty
    System.out.println(
        "TreeMap2 first key: " + treeMap2.firstKey()); // Returns the first key in the TreeMap
    System.out.println(
        "TreeMap2 last key: " + treeMap2.lastKey()); // Returns the last key in the TreeMap
    System.out.println("TreeMap2 headMap(student1): "
        + treeMap2.headMap(student1)); // Returns a view of the portion of this map whose keys are
                                       // strictly less than student1
    System.out.println("TreeMap2 tailMap(student1): "
        + treeMap2.tailMap(student1)); // Returns a view of the portion of this map whose keys are
                                       // greater than or equal to student1
    System.out.println("TreeMap2 removing key student1: "
        + treeMap2.remove(student1)); // Removes the entry with key student1
    System.out.println("TreeMap2 after removing key student1: "
        + treeMap2); // Prints the TreeMap after removing the entry with key student1
    System.out.println(
        "TreeMap2 last entry: " + treeMap2.lastEntry()); // Returns the last entry in the TreeMap
    System.out.println(
        "TreeMap2 first entry: " + treeMap2.firstEntry()); // Returns the first entry in the TreeMap
    System.out.println("TreeMap2 keySet: "
        + treeMap2.keySet()); // Returns a Set view of the keys contained in this map
    System.out.println("TreeMap2 values: "
        + treeMap2.values()); // Returns a Collection view of the values contained in this map

    System.out.println("Initial TreeMap: " + treeMap);

    System.out.println(
        "TreeMap get: " + treeMap.get(4.2)); // Retrieves the value associated with the key 4.2
    System.out.println(
        "TreeMap contains key 4.2: " + treeMap.containsKey(4.2)); // Checks if the key 4.2 exists
    System.out.println("TreeMap contains value " + student1 + ": "
        + treeMap.containsValue(student1)); // Checks if the value student1 exists
    System.out.println(
        "TreeMap size: " + treeMap.size()); // Returns the number of key-value pairs in the TreeMap
    System.out.println("TreeMap is empty: " + treeMap.isEmpty()); // Checks if the TreeMap is empty
    System.out.println(
        "TreeMap first key: " + treeMap.firstKey()); // Returns the first key in the TreeMap
    System.out.println(
        "TreeMap last key: " + treeMap.lastKey()); // Returns the last key in the TreeMap
    System.out.println("TreeMap headMap(4.2): "
        + treeMap.headMap(4.2)); // Returns a view of the portion of this map whose keys are
                                 // strictly less than 4.2
    System.out.println("TreeMap tailMap(4.2): "
        + treeMap.tailMap(4.2)); // Returns a view of the portion of this map whose keys are greater
                                 // than or equal to 4.2
    System.out.println(
        "TreeMap removing key 4.2: " + treeMap.remove(4.2)); // Removes the entry with key 4.2
    System.out.println("TreeMap after removing key 4.2: "
        + treeMap); // Prints the TreeMap after removing the entry with key 4.2
    System.out.println(
        "TreeMap last entry: " + treeMap.lastEntry()); // Returns the last entry in the TreeMap
    System.out.println(
        "TreeMap first entry: " + treeMap.firstEntry()); // Returns the first entry in the TreeMap
  }
}
