package lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class RemoveIf {
  /**
   * Main method of the class.
   * @param args Command line arguments.
   */
  public static void main(String[] args) {
    /**
     * Create an ArrayList of students.
     */
    ArrayList<String> students = new ArrayList<>();
    students.add("java");
    students.add("python");
    students.add("c++");
    students.add("javascript");
    students.add("html");

    System.out.println("Before removeIf: " + students);

    // students.removeIf(s -> s.length() < 5);

    /**
     * Predicate to check if the length of a string is greater than 5.
     */
    Predicate<String> predicate = s -> s.length() > 5;
    /**
     * Predicate to check if the length of a string is less than 3.
     */
    Predicate<String> predicate2 = s -> s.length() < 3;

    // Remove elements that satisfy both predicate and predicate2
    /**
     * Remove elements that satisfy both predicate and predicate2.
     */
    students.removeIf(predicate.and(predicate2));
    System.out.println("After removeIf (and): " + students);

    // Remove elements that satisfy either predicate or predicate2
    /**
     * Remove elements that satisfy either predicate or predicate2.
     */
    students.removeIf(predicate.or(predicate2));
    System.out.println("After removeIf (or): " + students);

    // Remove elements that do not satisfy predicate
    /**
     * Remove elements that do not satisfy predicate.
     */
    students.removeIf(predicate.negate());
    System.out.println("After removeIf (negate): " + students);
  }
}
