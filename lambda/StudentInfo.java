package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.*;

public class StudentInfo {
  /**
   * Tests the students using the provided student predicate.
   * @param students ArrayList of students.
   * @param studentPredicate StudentPredicate to test the students.
   */
  void testStudents(ArrayList<Student> students, StudentPredicate studentPredicate) {
    for (Student student : students) {
      if (studentPredicate.test(student)) {
        System.out.println(student);
      }
    }
  }

  /**
   * Tests the students using the provided Predicate.
   * @param students ArrayList of students.
   * @param studentPredicate Predicate to test the students.
   */
  void testStudents(ArrayList<Student> students, Predicate<Student> studentPredicate) {
    for (Student student : students) {
      if (studentPredicate.test(student)) {
        System.out.println(student);
      }
    }
  }

  /**
   * Prints the students with grade over the provided grade.
   * @param students ArrayList of students.
   * @param grade Grade to compare with.
   */
  void printStudentOverGrade(ArrayList<Student> students, double grade) {
    for (Student student : students) {
      if (student.getGrade() > grade) {
        System.out.println(student);
      }
    }
  }

  /**
   * Prints the students with age under the provided age.
   * @param students ArrayList of students.
   * @param age Age to compare with.
   */
  void printStudentUnderAge(ArrayList<Student> students, int age) {
    for (Student student : students) {
      if (student.getAge() < age) {
        System.out.println(student);
      }
    }
  }

  /**
   * Prints the students with age over the provided age, grade under the provided grade, and sex
   * equal to the provided sex.
   * @param students ArrayList of students.
   * @param age Age to compare with.
   * @param grade Grade to compare with.
   * @param sex Sex to compare with.
   */
  void printStudentsMixCondition(ArrayList<Student> students, int age, double grade, char sex) {
    for (Student student : students) {
      if (student.getAge() > age && student.getGrade() < grade && student.getSex() == sex) {
        System.out.println(student);
      }
    }
  }
}

class Test {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create five students.
     */
    Student student = new Student("John Doe", 'M', 20, 2, 3.5);
    Student student2 = new Student("Jane Doe", 'F', 20, 3, 9.8);
    Student student3 = new Student("Jim Doe", 'M', 21, 1, 2.9);
    Student student4 = new Student("Jill Doe", 'F', 23, 4, 2.9);
    Student student5 = new Student("Jack Doe", 'M', 19, 2, 3.0);

    /**
     * Create an ArrayList of students.
     */
    ArrayList<Student> students = new ArrayList<>();
    students.add(student);
    students.add(student2);
    students.add(student3);
    students.add(student4);
    students.add(student5);

    /**
     * Create a StudentInfo object.
     */
    StudentInfo studentInfo = new StudentInfo();

    /**
     * Sort the students by course.
     */
    Collections.sort(students, (Student o1, Student o2) -> o1.getCourse() - o2.getCourse());
    System.out.println("Students sorted by course:");
    for (Student s : students) {
      System.out.println(s);
    }
    System.out.println("\nStudents with grade over 8.0:");
    studentInfo.testStudents(students, new StudentOverGrade());

    // Use anonymous class for the first condition
    System.out.println("\nStudents under age 21:");
    studentInfo.testStudents(students, new StudentPredicate() {
      @Override
      public boolean test(Student student) {
        return student.getSex() == 'F' && student.getAge() < 21;
      }
    });

    // Use lambda expressions for the other conditions
    System.out.println("\nStudents with grade over 3.0:");
    StudentPredicate studentPredicate = (Student s) -> s.getGrade() > 3.0;
    studentInfo.testStudents(students, studentPredicate);

    // work only with one parameter in interface
    // studentInfo.testStudents(students, s -> s.getGrade() > 3.0);

    System.out.println("\nStudents with grade over 3.0:");
    studentInfo.printStudentOverGrade(students, 3.0);
    System.out.println("\nStudents under age 21:");
    studentInfo.printStudentUnderAge(students, 21);
    System.out.println("\nStudents over age 20, grade under 3.0 and female:");
    studentInfo.printStudentsMixCondition(students, 20, 3.0, 'F');
  }
}

// functional interface, only one abstract method
interface StudentPredicate {
  boolean test(Student student);
}

class StudentOverGrade implements StudentPredicate {
  /**
   * Tests if the student's grade is over 8.0.
   * @param student Student to test.
   * @return True if the student's grade is over 8.0, false otherwise.
   */
  @Override
  public boolean test(Student student) {
    return student.getGrade() > 8.0;
  }
}
