package collection.map_interface;

import java.util.Hashtable;

/**
 * Class HashTableExample demonstrates the usage of Hashtable in Java.
 */
public class HashTableExample {
  public static void main(String[] args) {
    // Hashtable is a synchronized map that does not allow null keys or values and not recommended
    // for new code, use ConcurrentHashMap instead.
    Hashtable<Double, Student> hashtable = new Hashtable<>();

    Student student1 = new Student("Zaur", "Tregulov", 3);
    Student student2 = new Student("Jane", "Doe", 2);
    Student student3 = new Student("Jack", "Smith", 3);
    Student student4 = new Student("Igor", "Sidorov", 4);

    hashtable.put(3.5, student1);
    hashtable.put(2.5, student2);
    hashtable.put(3.0, student3);
    hashtable.put(4.0, student4);

    System.out.println("Initial map:" + hashtable);

    System.out.println("Value for key 3.0:" + hashtable.get(3.0));
    System.out.println("Value for key 2.5:" + hashtable.get(2.5));

    System.out.println("Map after getting:" + hashtable);

    System.out.println("Removing key 3.0:" + hashtable.remove(3.0));
    System.out.println("Map after removing:" + hashtable);

    System.out.println("Contains key 2.5:" + hashtable.containsKey(2.5));

    System.out.println("Contains value " + student1 + ":" + hashtable.containsValue(student1));

    System.out.println("Size of the map:" + hashtable.size());

    System.out.println("Clearing the map:");
    hashtable.clear();
    System.out.println("Map after clearing:" + hashtable);

    System.out.println("Is the map empty? " + hashtable.isEmpty());

    System.out.println("Size of the map after clearing:" + hashtable.size());
  }
}
