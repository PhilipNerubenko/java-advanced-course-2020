package stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentStreamDemo {
   /**
    * The main method of the StudentStreamDemo class.
    * It demonstrates the usage of Java Streams to process a list of students.
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

       // Print the original list of students
       System.out.println("Original list of students:");
       students.forEach(System.out::println);

       // Sort the list of students by their names and print the sorted list
       students = students.stream().sorted((x, y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());
       System.out.println("\nSorted list of students:");
       students.forEach(System.out::println);

       System.out.println();

       // Use method chaining to process the list of students
       System.out.println("Methods chaining:");
       students.stream()
           .map(element -> {
               element.setName("Mr. " + element.getName());
               return element;
           })
           .filter(element -> element.getSex() == 'M')
           .sorted((x, y) -> x.getAge() - y.getAge())
           .forEach(System.out::println);

       System.out.println();

       // Find the first student in the list after processing and print it
       Optional<StudentFilter> first = students.stream()
           .map(element -> {
               element.setName("Mr. " + element.getName());
               return element;
           })
           .filter(element -> element.getSex() == 'M')
           .sorted((x, y) -> x.getAge() - y.getAge())
           .findFirst();

       System.out.println("First student in the list:");
       if (first.isPresent()) {
           System.out.println(first.get());
       } else {
           System.out.println("No students found.");
       }

       System.out.println();

       // Filter the list of students based on their age and average grade and print the filtered list
       students = students.stream().filter(element -> element.getAge() > 22 &&
               element.getAvgGrade() > 3.5)
               .collect(Collectors.toList());

       System.out.println("Filtered list of students (age > 22 and avgGrade > 3.5):");
       students.forEach(System.out::println);

       // Create a stream of students and print it
       Stream<StudentFilter> stream = Stream.of(student1, student2, student3, student4, student5);
       System.out.println();
       System.out.println("Stream of students:");
       stream.forEach(System.out::println);

       System.out.println();
   }
}


class StudentFilter {
   /**
    * The name of the student.
    */
   private String name;

   /**
    * The sex of the student.
    */
   private char sex;

   /**
    * The age of the student.
    */
   private int age;

   /**
    * The course of the student.
    */
   private int course;

   /**
    * The average grade of the student.
    */
   private double avgGrade;

   /**
    * Constructor for the StudentFilter class.
    *
    * @param name The name of the student
    * @param sex The sex of the student
    * @param age The age of the student
    * @param course The course of the student
    * @param avgGrade The average grade of the student
    */
   public StudentFilter(String name, char sex, int age, int course, double avgGrade) {
       this.name = name;
       this.sex = sex;
       this.age = age;
       this.course = course;
       this.avgGrade = avgGrade;
   }

   /**
    * Returns a string representation of the student.
    *
    * @return A string representation of the student
    */
   @Override
   public String toString() {
       return "StudentFilter [name=" + name + ", sex=" + sex + ", age=" + age + ", course=" + course + ", avgGrade="
               + avgGrade + "]";
   }

   /**
    * Returns the name of the student.
    *
    * @return The name of the student
    */
   public String getName() {
       return name;
   }

   /**
    * Sets the name of the student.
    *
    * @param name The new name of the student
    */
   public void setName(String name) {
       this.name = name;
   }

   /**
    * Returns the sex of the student.
    *
    * @return The sex of the student
    */
   public char getSex() {
       return sex;
   }

   /**
    * Sets the sex of the student.
    *
    * @param sex The new sex of the student
    */
   public void setSex(char sex) {
       this.sex = sex;
   }

   /**
    * Returns the age of the student.
    *
    * @return The age of the student
    */
   public int getAge() {
       return age;
   }

   /**
    * Sets the age of the student.
    *
    * @param age The new age of the student
    */
   public void setAge(int age) {
       this.age = age;
   }

   /**
    * Returns the course of the student.
    *
    * @return The course of the student
    */
   public int getCourse() {
       return course;
   }

   /**
    * Sets the course of the student.
    *
    * @param course The new course of the student
    */
   public void setCourse(int course) {
       this.course = course;
   }

   /**
    * Returns the average grade of the student.
    *
    * @return The average grade of the student
    */
   public double getAvgGrade() {
       return avgGrade;
   }

   /**
    * Sets the average grade of the student.
    *
    * @param avgGrade The new average grade of the student
    */
   public void setAvgGrade(double avgGrade) {
       this.avgGrade = avgGrade;
   }
}
