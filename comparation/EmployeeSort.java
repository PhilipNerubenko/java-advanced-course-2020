package comparation;

import java.util.*;

/**
 * Class EmployeeSort demonstrates sorting a list of EmployeeComparator objects using a
 * SalaryComparator.
 */
public class EmployeeSort {
  public static void main(String[] args) {
    List<EmployeeComparator> employees = new ArrayList<>();
    EmployeeComparator e1 = new EmployeeComparator(100, "John", "Doe", 50000);
    EmployeeComparator e2 = new EmployeeComparator(15, "Jane", "Smith", 60000);
    EmployeeComparator e3 = new EmployeeComparator(123, "Jane", "Johnson", 55000);

    employees.add(e1);
    employees.add(e2);
    employees.add(e3);

    System.out.println("Before sorting: " + employees);

    /**
     * Sorts the list of EmployeeComparator objects using a SalaryComparator.
     */
    Collections.sort(employees, new SalaryComparator());

    System.out.println("After sorting: " + employees);
  }
}

/**
 * Class EmployeeComparator implements Comparable<EmployeeComparator> to compare EmployeeComparator
 * objects based on their id.
 */
class EmployeeComparator implements Comparable<EmployeeComparator> {
  int id;
  String name;
  String surname;
  int salary;

  /**
   * Constructor for EmployeeComparator.
   * @param id the id of the employee.
   * @param name the name of the employee.
   * @param surname the surname of the employee.
   * @param salary the salary of the employee.
   */
  public EmployeeComparator(int id, String name, String surname, int salary) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.salary = salary;
  }

  @Override
  /**
   * Returns a string representation of the EmployeeComparator object.
   * @return a string representation of the EmployeeComparator object.
   */
  public String toString() {
    return "EmployeeComparator [id=" + id + ", name=" + name + ", surname=" + surname
        + ", salary=" + salary + "]";
  }

  // interface Comparable used to compare objects, using a natural order
  @Override
  /**
   * Compares this EmployeeComparator object with the specified EmployeeComparator object for order.
   * @param other the EmployeeComparator object to be compared.
   * @return a negative integer, zero, or a positive integer as this object is less than, equal to,
   *     or greater than the specified object.
   */
  public int compareTo(EmployeeComparator other) {
    return this.id - other.id;
  }
}

/**
 * Class IdComparator implements Comparator<EmployeeComparator> to compare EmployeeComparator
 * objects based on their id.
 */
// class IdComparator implements Comparator<EmployeeComparator> {
//    @Override
//    /**
//     * Compares two EmployeeComparator objects based on their id.
//     * @param emp1 the first EmployeeComparator object to be compared.
//     * @param emp2 the second EmployeeComparator object to be compared.
//     * @return a negative integer, zero, or a positive integer as the first argument is less than,
//     equal to, or greater than the second.
//     */
//    public int compare(EmployeeComparator emp1, EmployeeComparator emp2) {
//        if (emp1.id > emp2.id) {
//            return 1;
//        } else if (emp1.id < emp2.id) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
// }

/**
 * Class NameComparator implements Comparator<EmployeeComparator> to compare EmployeeComparator
 * objects based on their name.
 */
class NameComparator implements Comparator<EmployeeComparator> {
  @Override
  /**
   * Compares two EmployeeComparator objects based on their name.
   * @param emp1 the first EmployeeComparator object to be compared.
   * @param emp2 the second EmployeeComparator object to be compared.
   * @return a negative integer, zero, or a positive integer as the first argument is less than,
   *     equal to, or greater than the second.
   */
  public int compare(EmployeeComparator emp1, EmployeeComparator emp2) {
    return emp1.name.compareTo(emp2.name);
  }
}

/**
 * Class SalaryComparator implements Comparator<EmployeeComparator> to compare EmployeeComparator
 * objects based on their salary.
 */
class SalaryComparator implements Comparator<EmployeeComparator> {
  @Override
  /**
   * Compares two EmployeeComparator objects based on their salary.
   * @param emp1 the first EmployeeComparator object to be compared.
   * @param emp2 the second EmployeeComparator object to be compared.
   * @return a negative integer, zero, or a positive integer as the first argument is less than,
   *     equal to, or greater than the second.
   */
  public int compare(EmployeeComparator emp1, EmployeeComparator emp2) {
    return emp1.salary - emp2.salary;
  }
}
