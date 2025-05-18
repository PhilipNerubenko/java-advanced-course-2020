package stream;

import java.util.ArrayList;
import java.util.List;

public class StreamFlatMapDemo {
  /**
   * The main method of the StreamFlatMapDemo class.
   * It demonstrates the usage of Java Streams and flatMap to process a list of faculties and their
   * students.
   *
   * @param args Command line arguments (not used in this program)
   */
  public static void main(String[] args) {
    // Initialize a list of students
    StudentFilter student1 = new StudentFilter("John", 'M', 20, 2, 3.5);
    StudentFilter student2 = new StudentFilter("Jane", 'F', 22, 3, 4.0);
    StudentFilter student3 = new StudentFilter("Mike", 'M', 21, 2, 3.8);
    StudentFilter student4 = new StudentFilter("Sara", 'F', 23, 3, 3.9);
    StudentFilter student5 = new StudentFilter("Tom", 'M', 19, 1, 3.2);

    // Initialize a list of faculties and add students to them
    Faculty faculty1 = new Faculty("Computer Science");
    Faculty faculty2 = new Faculty("Mathematics");

    faculty1.addStudentToFaculty(student1);
    faculty1.addStudentToFaculty(student2);
    faculty1.addStudentToFaculty(student3);
    faculty2.addStudentToFaculty(student4);
    faculty2.addStudentToFaculty(student5);

    // Create a list of faculties
    List<Faculty> faculties = new ArrayList<>();
    faculties.add(faculty1);
    faculties.add(faculty2);

    // Use flatMap to flatten the list of faculties and their students, and print the names of the
    // students
    faculties.stream()
        .flatMap(faculty -> faculty.getStudentsOnFaculty().stream())
        .forEach(e -> System.out.println(e.getName()));
  }
}

class Faculty {
  /**
   * The name of the faculty.
   */
  private String name;

  /**
   * The list of students on the faculty.
   */
  private List<StudentFilter> studentsOnFaculty;

  /**
   * Constructor for the Faculty class.
   *
   * @param name The name of the faculty
   */
  public Faculty(String name) {
    this.name = name;
    this.studentsOnFaculty = new ArrayList<>();
  }

  /**
   * Returns the list of students on the faculty.
   *
   * @return The list of students on the faculty
   */
  public List<StudentFilter> getStudentsOnFaculty() {
    return studentsOnFaculty;
  }

  /**
   * Adds a student to the faculty.
   *
   * @param student The student to be added
   */
  public void addStudentToFaculty(StudentFilter student) {
    studentsOnFaculty.add(student);
  }

  /**
   * Returns the name of the faculty.
   *
   * @return The name of the faculty
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the faculty.
   *
   * @param name The new name of the faculty
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Sets the list of students on the faculty.
   *
   * @param studentsOnFaculty The new list of students on the faculty
   */
  public void setStudentsOnFaculty(List<StudentFilter> studentsOnFaculty) {
    this.studentsOnFaculty = studentsOnFaculty;
  }
}
