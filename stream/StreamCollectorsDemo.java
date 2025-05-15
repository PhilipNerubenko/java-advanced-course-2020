package stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamCollectorsDemo {
  /**
   * The main method of the StreamCollectorsDemo class.
   * It demonstrates the usage of Java Streams and Collectors to process a list of students.
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

    List<StudentFilter> students = List.of(student1, student2, student3, student4, student5);

    // Group the students by their course using a stream and Collectors.groupingBy
    Map<Integer, List<StudentFilter>> map1 =
        students.stream()
            .map(element -> {
              element.setName(element.getName().toUpperCase());
              return element;
            })
            .collect(Collectors.groupingBy(element -> element.getCourse()));

    // Print the students grouped by course
    for (Map.Entry<Integer, List<StudentFilter>> entry : map1.entrySet()) {
      System.out.println("Course: " + entry.getKey());
      for (StudentFilter student : entry.getValue()) {
        System.out.println(student);
      }
    }

    System.out.println();

    // Partition the students into two groups based on their average grade using
    // Collectors.partitioningBy
    Map<Boolean, List<StudentFilter>> map2 = students.stream().collect(
        Collectors.partitioningBy(element -> element.getAvgGrade() > 3.5));

    // Print the students partitioned by their average grade
    for (Map.Entry<Boolean, List<StudentFilter>> entry : map2.entrySet()) {
      System.out.println("Do they study well? " + entry.getKey());
      for (StudentFilter student : entry.getValue()) {
        System.out.println(student);
      }
    }
  }
}
