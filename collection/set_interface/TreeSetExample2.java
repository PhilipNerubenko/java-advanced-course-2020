package collection.set_interface;

import java.util.TreeSet;

/**
 * Class TreeSetExample2 demonstrates the usage of TreeSet in Java.
 */
public class TreeSetExample2 {
  public static void main(String[] args) {
    TreeSet<StudentTreeSet> treeSet = new TreeSet<>();
    StudentTreeSet student1 = new StudentTreeSet("Alice", 1);
    StudentTreeSet student2 = new StudentTreeSet("Bob", 3);
    StudentTreeSet student3 = new StudentTreeSet("Charlie", 2);
    StudentTreeSet student4 = new StudentTreeSet("David", 4);
    StudentTreeSet student5 = new StudentTreeSet("Eve", 2);

    // Adding students to the TreeSet
    treeSet.add(student1);
    treeSet.add(student2);
    treeSet.add(student3);
    treeSet.add(student4);
    treeSet.add(student5);

    System.out.println("TreeSet of Students: " + treeSet);
    System.out.println("First Student: " + treeSet.first());
    System.out.println("Last Student: " + treeSet.last());
    System.out.println("HeadSet (up to Charlie): " + treeSet.headSet(student3));
    System.out.println("TailSet (from Charlie): " + treeSet.tailSet(student3));
    System.out.println("SubSet (from Alice to Charlie): " + treeSet.subSet(student1, student3));
    System.out.println("Size of TreeSet: " + treeSet.size());
    System.out.println("Is TreeSet empty? " + treeSet.isEmpty());
    System.out.println("Does TreeSet contain Bob? " + treeSet.contains(student2));
    System.out.println("Removing Charlie: " + treeSet.remove(student3));
    System.out.println("TreeSet after removal: " + treeSet);

    System.out.println("Equality check: " + student3.equals(student5));
    System.out.println("HashCode of Charlie: " + student3.hashCode());
    System.out.println("HashCode of Eve: " + student5.hashCode());

    System.out.println("Iterating through TreeSet:");
    for (StudentTreeSet student : treeSet) {
      System.out.println(student);
    }

    System.out.println("Clearing TreeSet...");
    treeSet.clear();
    System.out.println("TreeSet after clearing: " + treeSet);
  }
}

/**
 * Class StudentTreeSet represents a student with a name and course.
 */
class StudentTreeSet implements Comparable<StudentTreeSet> {
  String name;
  int course;

  /**
   * Constructor for StudentTreeSet.
   * @param name the name of the student.
   * @param course the course of the student.
   */
  public StudentTreeSet(String name, int course) {
    this.name = name;
    this.course = course;
  }

  @Override
  /**
   * Returns a hash code value for the StudentTreeSet object.
   * @return a hash code value for the StudentTreeSet object.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + course;
    return result;
  }

  @Override
  /**
   * Compares this StudentTreeSet object with the specified object for equality.
   * @param obj the object to be compared.
   * @return true if the objects are equal, false otherwise.
   */
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    StudentTreeSet other = (StudentTreeSet) obj;
    if (course != other.course)
      return false;
    return true;
  }

  @Override
  /**
   * Compares this StudentTreeSet object with the specified StudentTreeSet object for order.
   * @param other the StudentTreeSet object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   *     or greater than the specified object.
   */
  public int compareTo(StudentTreeSet other) {
    return this.course - other.course;
  }

  @Override
  /**
   * Returns a string representation of the StudentTreeSet object.
   * @return a string representation of the StudentTreeSet object.
   */
  public String toString() {
    return "Student{name='" + name + "', course=" + course + "}";
  }
}
