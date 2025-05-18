package collection.set_interface;

import java.util.HashSet;

/**
 * Class HashSetExample2 demonstrates the usage of HashSet in Java.
 */
public class HashSetExample2 {
  public static void main(String[] args) {
    HashSet<Integer> hashSet1 = new HashSet<>();
    HashSet<Integer> hashSet2 = new HashSet<>();

    // Adding elements to the HashSet1
    hashSet1.add(5);
    hashSet1.add(2);
    hashSet1.add(3);
    hashSet1.add(1);
    hashSet1.add(8);
    hashSet1.add(8); // Duplicate element, will not be added

    // Adding elements to the HashSet2
    hashSet2.add(7);
    hashSet2.add(4);
    hashSet2.add(3);
    hashSet2.add(5);
    hashSet2.add(8);

    // Union of two HashSets
    HashSet<Integer> unionSet = new HashSet<>(hashSet1);
    unionSet.addAll(hashSet2);
    System.out.println("Union of HashSet1 and HashSet2: " + unionSet);

    // Intersection of two HashSets
    HashSet<Integer> intersectionSet = new HashSet<>(hashSet1);
    intersectionSet.retainAll(hashSet2);
    System.out.println("Intersection of HashSet1 and HashSet2: " + intersectionSet);

    // Subtract of two HashSets
    HashSet<Integer> subtractSet = new HashSet<>(hashSet1);
    subtractSet.removeAll(hashSet2);
    System.out.println("Difference of HashSet1 and HashSet2: " + subtractSet);
  }
}
