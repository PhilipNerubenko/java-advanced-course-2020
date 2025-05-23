package collection.map_interface;

import java.util.HashMap;
import java.util.Map;

/**
 * Class HashCodeEx1 demonstrates the usage of hashCode in Java.
 */
public class HashCodeEx1 {
  public static void main(String[] args) {
    Student student1 = new Student("Zaur", "Tregulov", 3);
    Student student2 = new Student("Jane", "Doe", 2);
    Student student3 = new Student("Jack", "Smith", 3);

    Map<Student, Double> map = new HashMap<>();
    map.put(student1, 3.5);
    map.put(student2, 4.0);
    map.put(student3, 2.8);

    System.out.println("Initial map: " + map);

    Student studentToCheck = new Student("John", "Doe", 1);

    boolean containsStudent = map.containsKey(studentToCheck);
    Student student4 = new Student("Igor", "Sidorov", 4);

    System.out.println("Map contains student " + studentToCheck + ": " + containsStudent);

    System.out.println(student1.hashCode());
    System.out.println(student2.hashCode());
    System.out.println(student4.hashCode());

    Map<Integer, String> map2 =
        new HashMap<>(16, 0.75f); // default initial capacity is 16 and load factor is 0.75
    // 16 * 0.75 = 12 elements before resizing the table
  }
}

/**
 * Class Student represents a student with a name, surname, and course.
 */
final class Student implements Comparable<Student> {
  final String name;
  final String surname;
  final int course;

  /**
   * Constructor for Student.
   * @param name the name of the student.
   * @param surname the surname of the student.
   * @param course the course of the student.
   */
  public Student(String name, String surname, int course) {
    this.name = name;
    this.surname = surname;
    this.course = course;
  }

  @Override
  /**
   * Returns a string representation of the Student object.
   * @return a string representation of the Student object.
   */
  public String toString() {
    return "Student [name=" + name + ", surname=" + surname + ", course=" + course + "]";
  }

  @Override
  /**
   * Returns a hash code value for the Student object.
   * @return a hash code value for the Student object.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((surname == null) ? 0 : surname.hashCode());
    result = prime * result + course;
    return result;
  }

  // not ideal hashCode better to use autogenerated
  // @Override
  // public int hashCode() {
  //     return name.length() * 7 + surname.length() * 11 + course * 53;
  // }

  @Override
  /**
   * Compares this Student object with the specified object for equality.
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
    Student other = (Student) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (surname == null) {
      if (other.surname != null)
        return false;
    } else if (!surname.equals(other.surname))
      return false;
    if (course != other.course)
      return false;
    return true;
  }

  @Override
  /**
   * Compares this Student object with the specified Student object for order.
   * @param anotherStudent the Student object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   *     or greater than the specified object.
   */
  public int compareTo(Student anotherStudent) {
    return this.name.compareTo(anotherStudent.name);
  }
}
