package collection;

import java.util.ArrayList;

/**
 * Class ArrayListMethods2 demonstrates the usage of ArrayList methods in Java.
 */
public class ArrayListMethods2 {
  public static void main(String[] args) {
    Student student1 = new Student("Alice", 'F', 20, 2, 3.5);
    Student student2 = new Student("Bob", 'M', 22, 3, 3.8);
    Student student3 = new Student("Charlie", 'M', 21, 2, 3.2);
    Student student4 = new Student("Diana", 'F', 23, 4, 3.9);
    Student student5 = new Student("Eve", 'F', 19, 1, 3.6);

    ArrayList<Student> students = new ArrayList<>();

    students.add(student1);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);

    System.out.println("Students in the list:");
    for (Student student : students) {
      System.out.println(student);
    }

    Student student6 = new Student("Eve", 'F', 19, 1, 3.6);

    students.remove(student6);

    System.out.println("After removing Eve:");
    for (Student student : students) {
      System.out.println(student);
    }

    int index = students.indexOf(student1);
    if (index != -1) {
      System.out.println("Found " + student1 + " at index " + index);
    } else {
      System.out.println(student1 + " not found in the list.");
    }
  }
}

/**
 * Class Student represents a student with various attributes.
 */
class Student {
  private String name;
  private char sex;
  private int age;
  private int course;
  private double avgGrade;

  /**
   * Constructor for Student.
   * @param name the name of the student.
   * @param sex the sex of the student.
   * @param age the age of the student.
   * @param course the course of the student.
   * @param avgGrade the average grade of the student.
   */
  public Student(String name, char sex, int age, int course, double avgGrade) {
    this.name = name;
    this.sex = sex;
    this.age = age;
    this.course = course;
    this.avgGrade = avgGrade;
  }

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
    if (sex != other.sex)
      return false;
    if (age != other.age)
      return false;
    if (course != other.course)
      return false;
    if (Double.doubleToLongBits(avgGrade) != Double.doubleToLongBits(other.avgGrade))
      return false;
    return true;
  }

  @Override
  /**
   * Returns a string representation of the Student object.
   * @return a string representation of the Student object.
   */
  public String toString() {
    return "Student [name=" + name + ", sex=" + sex + ", age=" + age + ", course=" + course
        + ", avgGrade=" + avgGrade + "]";
  }
}
