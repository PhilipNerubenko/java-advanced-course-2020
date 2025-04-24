package stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamNumericOperationsDemo {
   /**
    * The main method of the StreamNumericOperationsDemo class.
    * It demonstrates the usage of Java Streams and numeric operations to process a list of students.
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

       // Find the youngest and oldest students using min and max
       StudentFilter min = students.stream().min((x, y) -> x.getAge() - y.getAge()).get();
       System.out.println("Youngest student: " + min.getName() + ", Age: " + min.getAge());

       StudentFilter max = students.stream().max((x, y) -> x.getAge() - y.getAge()).get();
       System.out.println("Oldest student: " + max.getName() + ", Age: " + max.getAge());

       System.out.println("\nWithout limit and skip:");
       // Print the students older than 20
       students.stream().filter(element -> element.getAge() > 20)
           .forEach(element -> System.out.println("Student older than 20: " + element.getName() + ", Age: " + element.getAge()));

       System.out.println("\nWith limit:");
       // Print the first two students older than 20
       students.stream().filter(element -> element.getAge() > 20)
           .limit(2).forEach(element -> System.out.println("Student older than 20: " + element.getName() + ", Age: " + element.getAge()));

       System.out.println("\nWith skip:");
       // Print the students older than 20, skipping the first two
       students.stream().filter(element -> element.getAge() > 20)
           .skip(2).forEach(element -> System.out.println("Student older than 20: " + element.getName() + ", Age: " + element.getAge()));

       // Use mapToInt to transform the list of students into a list of their courses
       List<Integer> courses = students.stream()
           .mapToInt(element -> element.getCourse())
           .boxed() // convert int to Integer
           .collect(Collectors.toList());
       System.out.println("\nCourses: " + courses);

       // Calculate the sum, average, minimum, and maximum of the courses
       int sum = students.stream()
           .mapToInt(element -> element.getCourse())
           .sum();
       System.out.println("Sum of courses: " + sum);

       double average = students.stream()
           .mapToInt(element -> element.getCourse())
           .average().getAsDouble();
       System.out.println("Average of courses: " + average);

       int min1 = students.stream()
           .mapToInt(element -> element.getCourse())
           .min().getAsInt();
       System.out.println("Minimum of courses: " + min1);

       int max1 = students.stream()
           .mapToInt(element -> element.getCourse())
           .max().getAsInt();
       System.out.println("Maximum of courses: " + max1);
   }
}

