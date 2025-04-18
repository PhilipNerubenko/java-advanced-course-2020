package collection;

import java.util.LinkedList;

/**
* Class LinkedListEx1 demonstrates the usage of LinkedList in Java.
*/
public class LinkedListEx1 {
   public static void main(String[] args) {
       Student2 student1 = new Student2("John", 20);
       Student2 student2 = new Student2("Jane", 22);
       Student2 student3 = new Student2("Jack", 21);
       Student2 student4 = new Student2("Jill", 23);
       Student2 student5 = new Student2("Joe", 24);

       // Create a LinkedList and add Student objects, doubly linked
       LinkedList<Student2> studentList = new LinkedList<>();
       studentList.add(student1);
       studentList.add(student2);
       studentList.add(student3);
       studentList.add(student4);
       studentList.add(student5);

       // Print the LinkedList
       System.out.println("LinkedList of Students:");
       for (Student2 student : studentList) {
           System.out.println(student);
       }

       // Remove a student from the LinkedList
       studentList.remove(student3);

       System.out.println("\nAfter removing student3:");
       for (Student2 student : studentList) {
           System.out.println(student);
       }

       // Add a student at a specific position
       studentList.add(2, new Student2("Jake", 25));
       System.out.println("\nAfter adding Jake at index 2:");
       for (Student2 student : studentList) {
           System.out.println(student);
       }

       // Get a student at a specific position
       Student2 studentAtIndex1 = studentList.get(1);

       System.out.println("\nStudent at index 1: " + studentAtIndex1);

       // Get the size of the LinkedList
       int size = studentList.size();
       System.out.println("\nSize of the LinkedList: " + size);

       // Check if the LinkedList contains a specific student
       boolean containsStudent4 = studentList.contains(student4);
       System.out.println("\nContains student4: " + containsStudent4);

       // Clear the LinkedList
       studentList.clear();
       System.out.println("\nAfter clearing the LinkedList:");
       for (Student2 student : studentList) {
           System.out.println(student);
       }

       // Check if the LinkedList is empty
       boolean isEmpty = studentList.isEmpty();
       System.out.println("\nIs the LinkedList empty? " + isEmpty);
   }
}


/**
* Class Student2 represents a student with a name and age.
*/
class Student2 {
   private String name;
   private int age;

   /**
    * Constructor for Student2.
    * @param name the name of the student.
    * @param age the age of the student.
    */
   public Student2(String name, int age) {
       this.name = name;
       this.age = age;
   }

   /**
    * Retrieves the name of the student.
    * @return the name of the student.
    */
   public String getName() {
       return name;
   }

   /**
    * Retrieves the age of the student.
    * @return the age of the student.
    */
   public int getAge() {
       return age;
   }

   @Override
   /**
    * Returns a string representation of the Student2 object.
    * @return a string representation of the Student2 object.
    */
   public String toString() {
       return "Student2{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
   }
}
