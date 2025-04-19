package collection.queue_interface;

import java.util.PriorityQueue;

/**
 * Class PriorityQueueExample2 demonstrates the usage of PriorityQueue in Java.
 */
public class PriorityQueueExample2 {
  public static void main(String[] args) {
    PriorityQueue<StudentPriorityQueue> queue = new PriorityQueue<>();
    StudentPriorityQueue student1 = new StudentPriorityQueue("Alice", 1);
    StudentPriorityQueue student2 = new StudentPriorityQueue("Bob", 3);
    StudentPriorityQueue student3 = new StudentPriorityQueue("Charlie", 2);
    StudentPriorityQueue student4 = new StudentPriorityQueue("David", 4);
    StudentPriorityQueue student5 = new StudentPriorityQueue("Eve", 2);

    // Add elements to the PriorityQueue
    queue.offer(student1);
    queue.offer(student2);
    queue.offer(student3);
    queue.offer(student4);
    queue.offer(student5);

    // Print the PriorityQueue, not sorting when displayed on screen
    System.out.println("PriorityQueue: " + queue);

    // remove the head of the queue
    System.out.println("Removed head: " + queue.poll());
    System.out.println("Removed head: " + queue.poll());
    System.out.println("Removed head: " + queue.poll());
    System.out.println("Removed head: " + queue.poll());
    System.out.println("Removed head: " + queue.poll());
    System.out.println("Removed head: " + queue.poll());
  }
}

/**
 * Class StudentPriorityQueue represents a student with a name and course.
 */
class StudentPriorityQueue implements Comparable<StudentPriorityQueue> {
  String name;
  int course;

  /**
   * Constructor for StudentPriorityQueue.
   * @param name the name of the student.
   * @param course the course of the student.
   */
  public StudentPriorityQueue(String name, int course) {
    this.name = name;
    this.course = course;
  }

  @Override
  /**
   * Returns a hash code value for the StudentPriorityQueue object.
   * @return a hash code value for the StudentPriorityQueue object.
   */
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + course;
    return result;
  }

  @Override
  /**
   * Compares this StudentPriorityQueue object with the specified object for equality.
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
    StudentPriorityQueue other = (StudentPriorityQueue) obj;
    if (course != other.course)
      return false;
    return true;
  }

  @Override
  /**
   * Compares this StudentPriorityQueue object with the specified StudentPriorityQueue object for
   * order.
   * @param other the StudentPriorityQueue object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   *     or greater than the specified object.
   */
  public int compareTo(StudentPriorityQueue other) {
    return this.course - other.course;
  }

  @Override
  /**
   * Returns a string representation of the StudentPriorityQueue object.
   * @return a string representation of the StudentPriorityQueue object.
   */
  public String toString() {
    return "Student{name='" + name + "', course=" + course + "}";
  }
}
